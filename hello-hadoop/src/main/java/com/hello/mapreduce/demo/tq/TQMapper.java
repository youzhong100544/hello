package com.hello.mapreduce.demo.tq;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TQMapper extends Mapper<LongWritable, Text, TQ, IntWritable>{

	TQ t = new TQ();
	IntWritable iw = new IntWritable();
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, TQ, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		//1949-10-01 14:21:02	34c
		String[] split = StringUtils.split(value.toString(), "\t");
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.parse(split[0],format);
		
		t.setYear(localDateTime.getYear());
		t.setMonth(localDateTime.getMonthValue());
		t.setDay(localDateTime.getDayOfMonth());
		
		int parseInt = Integer.parseInt(split[1].substring(0, split[1].lastIndexOf("c")));
		
		t.setTemperature(parseInt);
		
		iw.set(parseInt);
		
		context.write(t, iw);
		
	}

}
