package com.hello.mapreduce.demo.tq;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

public class MyTQ {
	
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		
	}
}
