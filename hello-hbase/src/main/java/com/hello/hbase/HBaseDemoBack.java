package com.hello.hbase;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HBaseDemoBack {
	
	HBaseAdmin admin;
	HTable htable;
	
	String TN = "phone";
	
	byte[] family = "cf".getBytes();
	
	@Before
	public void begin() throws Exception {
		Configuration conf = new Configuration();
		// 如果是伪分布式  zk指定hbase
		conf.set("hbase.zookeeper.quorum", "node2,node3,node4");
		
		admin = new HBaseAdmin(conf);
		htable = new HTable(conf, TN);
	}
	
	@After
	public void end() {
		if(admin != null) {
			try {
				admin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(htable != null) {
			try {
				htable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void createTable() throws Exception{
		if(admin.tableExists(TN)) {
			admin.disableTable(TN);
			admin.deleteTable(TN);
		}
		
		HTableDescriptor desc = new HTableDescriptor(TableName.valueOf(TN));
		
		HColumnDescriptor cf = new HColumnDescriptor("cf");
		cf.setInMemory(true);
		cf.setMaxVersions(1);
		desc.addFamily(cf);
		
		admin.createTable(desc);
	}
	
	@Test
	public void insertDB1() throws Exception {
		String rowkey = "111111";
		Put put = new Put(rowkey.getBytes());
		put.add(family, "name".getBytes(), "xiaoming".getBytes());
		put.add(family, "sex".getBytes(), "weizhi".getBytes());
		
		htable.put(put);
	}
	
	@Test
	public void getDB1() throws Exception {
		Get get = new Get("111111".getBytes());
		get.addColumn(family, "name".getBytes());
		
		Result rs = htable.get(get);
		Cell cell = rs.getColumnLatestCell(family, "name".getBytes());
		
		System.out.println(new String(CellUtil.cloneValue(cell)));
	}
	
	HTools htool = new HTools();
	Random r = new Random();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 随机生成10个用户 100条通话记录
	 * rowkey：手机号-（MAX-时间戳）
	 * @throws Exception
	 */
	@Test
	public void insertDB2() throws Exception {
		
		List<Put> puts = new ArrayList<Put>();
		
		for (int i = 0; i < 10; i++) {
			//手机号
			String pNum = htool.getPhoneNum("186");
			
			for (int j = 0; j < 100; j++) {
				
				//通话时间
				String dateStr = htool.getDate("2017");
				//通话时长
				String dateLong = r.nextInt(100) + "";
				//主叫被叫类型 0  1
				String type = r.nextInt(2) + "";
				// 对方手机号
				String dNum = htool.getPhoneNum("177");
				
				String rowkey = pNum + "-" + (Long.MAX_VALUE-sdf.parse(dateStr).getTime());
				
				Put put = new Put(rowkey.getBytes());
				put.add(family, "date".getBytes(), dateStr.getBytes());
				put.add(family, "dateLong".getBytes(), dateLong.getBytes());
				put.add(family, "type".getBytes(), type.getBytes());
				put.add(family, "dNum".getBytes(), dNum.getBytes());
				
				puts.add(put);
			}
		}
		
		htable.put(puts);
	}
	
	
	/**
	 * 通话详单
	 * 		手机号  对方手机号  时间  通话时长  主叫、被叫
	 * 查询某个手机号某月 产生的所有通话记录
	 * 		rowkey：手机号-（MAX-时间戳）
	 * @throws Exception
	 */
	@Test
	public void scanDB1() throws Exception {
		
		// 手机号：18667148115 6月份的所有通话记录
		Scan scan = new Scan();

		String startRow = "18667148115-" + (Long.MAX_VALUE-sdf.parse("20170701000000").getTime());
		String stopRow = "18667148115-" + (Long.MAX_VALUE-sdf.parse("20170601000000").getTime());
		
		scan.setStartRow(startRow.getBytes());
		scan.setStopRow(stopRow.getBytes());
		
		ResultScanner rss = htable.getScanner(scan);
		for (Result rs : rss) {
			System.out.print(new String(CellUtil.cloneValue(rs.getColumnLatestCell(family, "dNum".getBytes()))));
			System.out.print(" - " + new String(CellUtil.cloneValue(rs.getColumnLatestCell(family, "date".getBytes()))));
			System.out.print(" - " + new String(CellUtil.cloneValue(rs.getColumnLatestCell(family, "type".getBytes()))));
			System.out.println(" - " + new String(CellUtil.cloneValue(rs.getColumnLatestCell(family, "dateLong".getBytes()))));
		}
	}
	
	//删除某个cell??
	
	/**
	 * 查询某个手机号  所有的主叫类型type=1的数据
	 * 过滤器
	 * @throws Exception 
	 */
	@Test
	public void scanDB2() throws Exception {
		// 手机号：18667148115
		
		FilterList list = new FilterList(FilterList.Operator.MUST_PASS_ALL);
		
		PrefixFilter filter1 = new PrefixFilter("18667148115".getBytes());
		list.addFilter(filter1);
		
		SingleColumnValueFilter filter2 = new SingleColumnValueFilter(family,
				"type".getBytes(), CompareOp.EQUAL, "1".getBytes());
		list.addFilter(filter2);
		
		Scan scan = new Scan();
		scan.setFilter(list);

		ResultScanner rss = htable.getScanner(scan);
		for (Result rs : rss) {
			System.out.print(new String(CellUtil.cloneValue(rs.getColumnLatestCell(family, "dNum".getBytes()))));
			System.out.print(" - " + new String(CellUtil.cloneValue(rs.getColumnLatestCell(family, "date".getBytes()))));
			System.out.print(" - " + new String(CellUtil.cloneValue(rs.getColumnLatestCell(family, "type".getBytes()))));
			System.out.println(" - " + new String(CellUtil.cloneValue(rs.getColumnLatestCell(family, "dateLong".getBytes()))));
		}
	}
}