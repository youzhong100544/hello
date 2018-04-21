package com.hello.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class HBaseDemo {

	Configuration conf = null;
	Connection connection = null;

	TableName tableName = TableName.valueOf("t_table");
	String familyName1 = "cf1";
	String familyName2 = "cf2";

	@Before
	public void begin(){
		conf = HBaseConfiguration.create();

		// 如果是伪分布式  zk指定hbase的服务器
		conf.set("hbase.zookeeper.quorum", "node2,node3,node4");

		try {
			connection = ConnectionFactory.createConnection(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 创建表
	 */
	@Test
	public void createTable() throws IOException {
		Admin admin = connection.getAdmin();

		if (admin.tableExists(tableName)) {// 如果存在要创建的表，那么先删除，再创建
			admin.disableTable(tableName);
			admin.deleteTable(tableName);
			System.out.println(tableName + " is exist,detele....");
		}

		HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);

		HColumnDescriptor family1 = new HColumnDescriptor(familyName1.toString());
		HColumnDescriptor family2 = new HColumnDescriptor(familyName2.toString());
		hTableDescriptor.addFamily(family1);
		hTableDescriptor.addFamily(family2);

		admin.createTable(hTableDescriptor);

		System.out.println("create table ......");

	}

	/**
	 * 添加数据
	 * @throws IOException
	 */
	@Test
	public void insertData1() throws IOException {
		Table table = connection.getTable(tableName);

		// 一个PUT代表一行数据，再NEW一个PUT表示第二行数据,每行一个唯一的ROWKEY，此处rowkey为put构造方法中传入的值
		Put put = new Put("Row-Key-001".getBytes());
		// 本行数据的第一列
		put.addColumn("cf1".getBytes(),"age".getBytes(),"1".getBytes());
		table.put(put);

		System.out.println("end insert data ......");
	}

	/**
	 * 添加数据
	 * @throws IOException
	 */
	@Test
	public void insertData2() throws IOException {
		Table table = connection.getTable(tableName);

		// 一个PUT代表一行数据，再NEW一个PUT表示第二行数据,每行一个唯一的ROWKEY，此处rowkey为put构造方法中传入的值
		Put put = new Put("Row-Key-001".getBytes());
		// 本行数据的第一列
		put.addColumn("cf2".getBytes(),"name".getBytes(),"zhangsan".getBytes());
		table.put(put);

		System.out.println("end insert data ......");
	}

	@Test
	public void queryAll() throws IOException {

		Table table = connection.getTable(tableName);
		ResultScanner rs = table.getScanner(new Scan());
		for (Result r : rs) {
			System.out.println("获得到rowkey:" + new String(r.getRow()));
			for (Cell keyValue : r.rawCells()) {
				System.out.println("列：" + new String(CellUtil.cloneFamily(keyValue))+":"+new String(CellUtil.cloneQualifier(keyValue)) + "====值:" + new String(CellUtil.cloneValue(keyValue)));
			}
		}
		rs.close();

	}

	@Test
	public void queryByRowId() throws IOException {

		Table table = connection.getTable(tableName);
		Get scan = new Get("Row-Key-001".getBytes());// 根据rowkey查询
		Result r = table.get(scan);
		System.out.println("获得到rowkey:" + new String(r.getRow()));
		for (Cell keyValue : r.rawCells()) {
			System.out.println("列：" + new String(CellUtil.cloneFamily(keyValue))+":"+new String(CellUtil.cloneQualifier(keyValue)) + "====值:" + new String(CellUtil.cloneValue(keyValue)));
		}

	}

	@Test
	public void queryByCondition() throws IOException {
		Table table = connection.getTable(tableName);
		Filter filter = new SingleColumnValueFilter(Bytes.toBytes("Row-Key-001"), Bytes.toBytes("cf1"), CompareFilter.CompareOp.EQUAL, Bytes.toBytes("name")); // 当列familyName的值为value时进行查询
		Scan s = new Scan();
		s.setFilter(filter);
		ResultScanner rs = table.getScanner(s);
		for (Result r : rs) {
			System.out.println("获得到rowkey:" + new String(r.getRow()));
			for (Cell keyValue : r.rawCells()) {
				System.out.println("列：" + new String(CellUtil.cloneFamily(keyValue))+":"+new String(CellUtil.cloneQualifier(keyValue)) + "====值:" + new String(CellUtil.cloneValue(keyValue)));
			}
		}
		rs.close();
	}

	@Test
	public void queryByConditions() throws IOException {

	}

	@Test
	public void dropTable() throws IOException {
		Admin admin = connection.getAdmin();
		admin.disableTable(tableName);
		admin.deleteTable(tableName);
		admin.close();
	}

	@After
	public void end(){

		if (connection != null) {
			try {
				connection.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


}
