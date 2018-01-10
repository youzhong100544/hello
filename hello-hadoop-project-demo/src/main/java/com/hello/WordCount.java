package com.hello.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.logging.Logger;

public class WordCount implements Tool {

	private static final Logger LOGGER = Logger.getGlobal();

	private Configuration conf;

	public static void main(String[] args) {
		try {
			ToolRunner.run(new Configuration(), new WordCount(), args);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}

	@Override
	public int run(String[] args) throws Exception {
		return 0;
	}

	@Override
	public void setConf(Configuration conf) {
		conf = HBaseConfiguration.create();

		// 如果是伪分布式  zk指定hbase
		conf.set("hbase.zookeeper.quorum", "node2,node3,node4");
	}

	@Override
	public Configuration getConf() {
		return null;
	}
}
