package com.hello.mapreduce.demo.tq;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TQReducer extends Reducer<TQ, IntWritable, Text, IntWritable>{

	@Override
	protected void reduce(TQ key, Iterable<IntWritable> values, Reducer<TQ, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// 年月相同为一组
		// 温度倒序
		
		for (IntWritable intWritable : values) {
			
		}
		
	}

}
