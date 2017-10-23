package com.hello.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.mapred.lib.InputSampler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HDFSDemo {
	
	Configuration conf = null;
	FileSystem fs = null;
	
	@Before
	public void conn() throws Exception{
		conf = new Configuration(true);
		fs = FileSystem.get(conf);
	}
	
	@After
	public void close() throws Exception{
		fs.close();
	}
	
	@Test
	public void testMkdir() throws Exception{
		Path path = new Path("/tmp");
		if (!fs.exists(path)) {
			fs.mkdirs(path );
		}
	}
	
	@Test
	public void uploadFile() throws Exception{
		
		String desktop = "C:\\Users\\dell\\Desktop";
		
		Path path = new Path("/tmp/haha.txt");
		
		FSDataOutputStream output = fs.create(path);
		
		InputStream is = new BufferedInputStream(new FileInputStream(new File(desktop + "\\sql语句.sql")));
		
		
		IOUtils.copyBytes(is, output, conf, true);
	}
	
	@Test
	public void blk() throws Exception{
		Path path = new Path("/user/root/test.txt");
		FileStatus file = fs.getFileStatus(path);
		BlockLocation[] fileBlockLocations = fs.getFileBlockLocations(file, 0, file.getLen());
		
		for (int i = 0; i < fileBlockLocations.length; i++) {
			System.out.println(fileBlockLocations[i]);
		}
		
		FSDataInputStream in = fs.open(path);
		byte readByte = in.readByte();
		System.out.println(readByte);
		System.out.println((char)readByte);
		
		// 1M = 1024KB = 1048576B(字节)
		// 1KB = 1024B
		// 1B = 8bit
		// 1B就是一个字节
		in.seek(1048576);
		
		System.out.println(readByte);
		System.out.println((char)readByte);
	}
}
