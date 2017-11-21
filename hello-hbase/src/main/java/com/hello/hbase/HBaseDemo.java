package com.hello.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class HBaseDemo {

	Configuration conf = null;
	Connection connection = null;

	// 声明静态配置，配置zookeeper
	@Before
	public void begin(){
		conf = HBaseConfiguration.create();

		// 如果是伪分布式  zk指定hbase
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

		TableName tableName = TableName.valueOf("t_table");

		if (admin.tableExists(tableName)) {// 如果存在要创建的表，那么先删除，再创建
			admin.disableTable(tableName);
			admin.deleteTable(tableName);
			System.out.println(tableName + " is exist,detele....");
		}

		HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);

		String[] familyNames = new String[]{"cf"};
		HColumnDescriptor family = new HColumnDescriptor(familyNames.toString());
		hTableDescriptor.addFamily(family);

		admin.createTable(hTableDescriptor);

		System.out.println("create table ......");

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
