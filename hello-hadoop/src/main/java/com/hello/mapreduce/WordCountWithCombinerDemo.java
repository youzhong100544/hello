package com.hello.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountWithCombinerDemo {

	public static void main(String[] args) {
		
		
	}
	
	public static class WordCountMapper extends Mapper<Object, Text, Text, IntWritable>{
		
	}
	
	public static class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
		
	}
}
