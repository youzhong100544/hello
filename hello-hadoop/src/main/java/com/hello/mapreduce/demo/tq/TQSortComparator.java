package com.hello.mapreduce.demo.tq;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class TQSortComparator extends WritableComparator{

	public TQSortComparator() {
		super(TQ.class, true);
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {

		TQ t1 = (TQ)a;
		TQ t2 = (TQ)b;
		
		// 按 年 月 温度
		int year = Integer.compare(t1.getYear(), t2.getYear());
		if(year == 0) {
			int month = Integer.compare(t1.getMonth(), t2.getMonth());
			if(month == 0) {
				// 倒序
				return - Integer.compare(t1.getDay(), t2.getDay());
			}
			return month;
		}
		return year;
		
	}
	
	
}
