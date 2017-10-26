package com.hello.mapreduce.demo.tq;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class TQPartitioner extends Partitioner<TQ,IntWritable>{

	
	@Override
	public int getPartition(TQ key, IntWritable value, int numPartitions) {
		
		// 数据倾斜
		
		return key.getYear() % numPartitions;
	}

}
