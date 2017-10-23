package com.hello.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;

public class WordCountDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		/*
		// Create a new Job
		Job job = Job.getInstance();
		job.setJarByClass(MyJob.class);
		
		// Specify various job-specific parameters
		job.setJobName("myjob");
		
		job.setInputPath(new Path("in"));
		job.setOutputPath(new Path("out"));
		
		job.setMapperClass(MyJob.MyMapper.class);
		job.setReducerClass(MyJob.MyReducer.class);
		
		// Submit the job, then poll for progress until the job is complete
		job.waitForCompletion(true);
		*/
		
		
		Configuration conf = new Configuration(true);
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(WordCountDemo.class);
		
		job.setJobName("myjob");
		
		job.setMapperClass(MyMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		job.setReducerClass(MyReducer.class);
		
		job.waitForCompletion(true);
		
	}
}
