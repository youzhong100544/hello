package com.hello.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * WordCountWithCombinerDemo
 *
 * @author
 * @date
 */
public class WordCountWithCombinerDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		
		// 本地运行
		// conf.set("fs.defaultFS", "hdfs://node:8020");
		
		Job job = Job.getInstance(conf, "WordCountWithCombinerDemo");
		job.setJarByClass(WordCountWithCombinerDemo.class);
		
		// 输入
		Path input = new Path("/user/root/wc.txt");
		FileInputFormat.addInputPath(job, input);
		
		// 输出
		Path output = new Path("/output");
		if (output.getFileSystem(conf).exists(output)) {
			output.getFileSystem(conf).delete(output,true);
		}
		FileOutputFormat.setOutputPath(job, output);
		
		// Mapper
		job.setMapperClass(WordCountWithCombinerMapper.class);
		
		/*
		当mapper与reducer 的输出类型一致时可以用　job.setOutputKeyClass与job.setOutputValueClass这两个进行配置就行，
		但是当mapper用于reducer两个的输出类型不一致的时候就需要分别进行配置了。
		
		如果加了job.setMapOutputKeyClass(**.class); job.setMapOutputValueClass(**.class);
		
		那job.setOutputKeyClass(**.class);job.setOutputValueClass(**.class);
		设置为reducer的输出格式，如果没有设前者，那后者应该设置为mapper的输出格式
		*/
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
//		job.setOutputKeyClass(Text.class);
//		job.setOutputValueClass(IntWritable.class);
		
		// Combiner
		job.setCombinerClass(WordCountWithCombinerReducer.class);
		// Reducer
		job.setReducerClass(WordCountWithCombinerReducer.class);
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
	}
	
	public static class WordCountWithCombinerMapper extends Mapper<Object, Text, Text, IntWritable>{
			   
		private final static IntWritable one = new IntWritable(1);
		private Text word = new Text();
		
		@Override
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
			StringTokenizer itr = new StringTokenizer(value.toString());
			while (itr.hasMoreTokens()) {
				word.set(itr.nextToken());
				context.write(word, one);
			}
		}
	}
	
	public static class WordCountWithCombinerReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		
		private IntWritable result = new IntWritable();
		
		@Override
		public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable value : values) {
				sum += value.get();
			}
			result.set(sum);
			context.write(key, result);
	   }
		
	}

}