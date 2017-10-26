package com.hello.mapreduce.demo.tq;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class TQGroupingComparator extends WritableComparator{
	
	public TQGroupingComparator() {
		super(TQ.class, true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {

		TQ t1 = (TQ)a;
		TQ t2 = (TQ)b;
		
		// 按 年 月 
		int year = Integer.compare(t1.getYear(), t2.getYear());
		if(year == 0) {
			return Integer.compare(t1.getMonth(), t2.getMonth());
		}
		return year;
		
	}

}
