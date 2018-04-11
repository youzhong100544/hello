package com.hello.mapreduce.demo;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * TQDemo
 * 
 * 数据：
 * 		1949-10-01 14:21:02	34c
 * 		1949-10-01 19:21:02	38c
 * 		1949-10-02 14:01:02	36c
 * 		1950-01-01 11:21:02	32c
 * 		1950-10-01 12:21:02	37c
 * 		1951-12-01 12:21:02	23c
 * 		1950-10-02 12:21:02	41c
 * 		1950-10-03 12:21:02	27c
 * 		1951-07-01 12:21:02	45c
 * 		1951-07-02 12:21:02	46c
 * 		1951-07-03 12:21:03	47c
 * 
 * 需求：
 * 		找出每个月气温最高的2天
 *
 * @author
 * @date
 */
public class TQDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Configuration conf = new Configuration(true);
		
		Job job = Job.getInstance(conf, "TQDemo");
	
		job.setJarByClass(TQDemo.class);
		
		// 输入输出路径
		Path input = new Path("/data/tq/input");
		FileInputFormat.addInputPath(job, input);
		
		Path output = new Path("/datatq/output");
		if (output.getFileSystem(conf).exists(output)) {
			output.getFileSystem(conf).delete(output, true);
		}
		FileOutputFormat.setOutputPath(job, output);
		
		// MapperClass
		job.setMapperClass(TQMapper.class);
		job.setMapOutputKeyClass(TQWritableComparable.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		
		
		// ReducerClass
		job.setReducerClass(TQReducer.class);
		
		
		// 其他
		// Reduce数量
		job.setNumReduceTasks(2);
		// 分区器
		job.setPartitionerClass(TQPartitioner.class);
		// 排序比较器
		job.setSortComparatorClass(TQSortComparator.class);
		// 分组比较器
		job.setGroupingComparatorClass(TQGroupingComparator.class);
		
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
	}
	
	public static class TQMapper extends Mapper<LongWritable, Text, TQWritableComparable, IntWritable>{

		TQWritableComparable mapOutputKey = new TQWritableComparable();
		IntWritable mapOutputValue = new IntWritable();
		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, TQWritableComparable, IntWritable>.Context context)
				throws IOException, InterruptedException {

			// 1949-10-01 14:21:02	34c
			// String[] strs = StringUtils.split(value.toString(), "\t");
			String[] strs = value.toString().split("\t");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			Date date = null;
			try {
				date = sdf.parse(strs[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cal.setTime(date);
			
			mapOutputKey.setYear(cal.get(Calendar.YEAR));
			mapOutputKey.setMonth(cal.get(Calendar.MONTH)+1);
			mapOutputKey.setDay(cal.get(Calendar.DAY_OF_MONTH));
			
			int temperature = Integer.parseInt(strs[1].substring(0, strs[1].lastIndexOf("c")));
			mapOutputKey.setTemperature(temperature);
			
			mapOutputValue.set(temperature);
			
			context.write(mapOutputKey, mapOutputValue);
		}
		
	}
	
	public static class TQReducer extends Reducer<TQWritableComparable, IntWritable, Text, IntWritable> {

		Text outputkey = new Text();
		IntWritable outputValue = new IntWritable();
		
		@Override
		protected void reduce(TQWritableComparable key, Iterable<IntWritable> values, Reducer<TQWritableComparable, IntWritable, Text, IntWritable>.Context context) 
				throws IOException, InterruptedException {

			//年月相同，为一组
			//温度是倒序
			//1949-10  1000条
			//前3条已经决定了第一高和第二高的温度
			int f = 0;
			int day = 0;
			for (IntWritable value : values) {
				if(f == 0){
					outputkey.set(key.getYear() + "-" + key.getMonth() + "-" + key.getDay());
					outputValue.set(key.getTemperature());
					context.write(outputkey, outputValue);
					day = key.getDay();
					f++;
				}
				if(f != 0 && day != key.getDay()){
					
					outputkey.set(key.getYear()+"-"+key.getMonth()+"-"+key.getDay());
					outputValue.set(key.getTemperature());
					context.write(outputkey, outputValue);
					break;
				}
				
			}
		}

	}
	
	
	
	public static class TQWritableComparable implements WritableComparable<TQWritableComparable>{

		private int year;
		private int month;
		private int day;
		private int temperature;
		
		
		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public int getMonth() {
			return month;
		}

		public void setMonth(int month) {
			this.month = month;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public int getTemperature() {
			return temperature;
		}

		public void setTemperature(int temperature) {
			this.temperature = temperature;
		}

		
		@Override
		public void write(DataOutput out) throws IOException {
			out.writeInt(year);
			out.writeInt(month);
			out.writeInt(day);
			out.writeInt(temperature);
		}

		@Override
		public void readFields(DataInput in) throws IOException {
			this.year = in.readInt();
			this.month = in.readInt();
			this.day = in.readInt();
			this.temperature = in.readInt();
		}

		@Override
		public int compareTo(TQWritableComparable that) {
			
			int yearCompare = Integer.compare(this.year, that.year);
			if(yearCompare == 0){
				int monthCompare = Integer.compare(this.month, that.month);
				if(monthCompare == 0){
					return Integer.compare(this.day, that.day);
				}
				return monthCompare;
			}		
			return yearCompare;
		}
		
	}
	
	public static class TQPartitioner extends Partitioner<TQWritableComparable, IntWritable>{

		@Override
		public int getPartition(TQWritableComparable key, IntWritable value, int numPartitions) {
			return key.getYear() % numPartitions;
		}
		
	}
	
	public static class TQSortComparator extends WritableComparator {
		 
		public TQSortComparator() {
			super(TQWritableComparable.class, true);
		}
		
		@SuppressWarnings("rawtypes")
		@Override
		public int compare(WritableComparable a, WritableComparable b) {
			
			TQWritableComparable t1 = (TQWritableComparable)a;
			TQWritableComparable t2 = (TQWritableComparable)b;
			
			//按  年  月  温度
			int c1 = Integer.compare(t1.getYear(), t2.getYear());
			if(c1 == 0){
				int c2 = Integer.compare(t1.getMonth(), t2.getMonth());
				if(c2 == 0){
					return  -Integer.compare(t1.getTemperature(), t2.getTemperature());
				}
				return c2;
			}
			return c1;
		}
	}
	
	public static class TQGroupingComparator extends WritableComparator {
		
		public TQGroupingComparator() {
			super(TQWritableComparable.class, true);
		}
		
		@SuppressWarnings("rawtypes")
		@Override
		public int compare(WritableComparable a, WritableComparable b) {
			
			TQWritableComparable t1 = (TQWritableComparable)a;
			TQWritableComparable t2 = (TQWritableComparable)b;
			
			//按  年  月 
			int c1 = Integer.compare(t1.getYear(), t2.getYear());
			if(c1 == 0){
				return  Integer.compare(t1.getMonth(), t2.getMonth());
			}
			return c1;
		}
		
	}
}
