package com.hello.mapreduce.demo.tq;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class MyTQ {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(MyTQ.class);
		
		//输入
		Path input = new Path("/tq/input");
		FileInputFormat.addInputPath(job, input);
		//输出
		Path output = new Path("/tq/output"); ;
		if(output.getFileSystem(conf).exists(output)) {
			output.getFileSystem(conf).removeAcl(output);
		}
		FileOutputFormat.setOutputPath(job, output);
		
		// map
		job.setMapperClass(TQMapper.class);
		job.setMapOutputKeyClass(TQ.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		// reduce
		job.setReducerClass(TQReducer.class);
		
		
		// 其他
		// reduce数量
		job.setNumReduceTasks(2);
		// 分区
		job.setPartitionerClass(TQPartitioner.class);
		// 排序比较器
		job.setSortComparatorClass(TQSortComparator.class);
		// 分组比较器
		job.setGroupingComparatorClass(TQGroupingComparator.class);
		
		// 提交
		job.waitForCompletion(true);
		
	}
}
