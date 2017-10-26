package com.hello.mapreduce.demo.tq;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TQReducer extends Reducer<TQ, IntWritable, Text, IntWritable>{

	@Override
	protected void reduce(TQ key, Iterable<IntWritable> values, Reducer<TQ, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {


		Text rkey = new Text();
		IntWritable rval = new IntWritable();
		// 年月相同为一组
		// 温度倒序
		int f = 0;

		int day = 0;
		for (IntWritable v : values) {

			if ( f == 0) {

				rkey.set(key.getYear()+ "-" + key.getMonth() + "-" +key.getDay());
				rval.set(key.getTemperature());

				context.write(rkey,rval);

				day = key.getDay();
				f++;
			}

			if ( f != 0 && day != key.getDay() ) {

				rkey.set(key.getYear()+ "-" + key.getMonth() + "-" +key.getDay());
				rval.set(key.getTemperature());

				context.write(rkey,rval);
				break;
			}

		}
		
	}

}
