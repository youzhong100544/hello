package com.hello.mapreduce;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * WordCountDemo
 *
 * @author
 * @date
 */
public class WordCountDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		
		Configuration conf = new Configuration(true);
		
		Job job = Job.getInstance(conf);
		
		job.setJobName("WordCountDemo");
		
		job.setJarByClass(WordCountDemo.class);
		
		
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
		job.setMapperClass(WordCountMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		// Reducer
		job.setReducerClass(WordCountReducer.class);
		
		job.waitForCompletion(true);
		
	}
}
