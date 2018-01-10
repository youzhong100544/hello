package com.hello;

import com.hello.common.GlobalConstants;
import com.hello.util.TimeUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.mapreduce.Job;
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
		Configuration conf = this.getConf();
		this.processArgs(conf, args);

		Job job = Job.getInstance(conf, "analyser_logdata");

		return 0;
	}

	@Override
	public void setConf(Configuration conf) {

		conf.set("hbase.zookeeper.quorum", "node2,node3,node4");
		conf.set("fs.defaultFS", "hdfs://node1:8020");
//		conf.set("yarn.resourcemanager.hostname", "node3");

		this.conf = HBaseConfiguration.create(conf);
	}

	@Override
	public Configuration getConf() {
		return this.conf;
	}


	/**
	 * 处理参数
	 *
	 * @param conf
	 * @param args
	 */
	private void processArgs(Configuration conf, String[] args) {
		String date = null;
		for (int i = 0; i < args.length; i++) {
			if ("-d".equals(args[i])) {
				if (i + 1 < args.length) {
					date = args[++i];
					break;
				}
			}
		}

		System.out.println("-----" + date);

		// 要求date格式为: yyyy-MM-dd
		if (StringUtils.isBlank(date) || !TimeUtil.isValidateRunningDate(date)) {
			// date是一个无效时间数据
			date = TimeUtil.getYesterday(); // 默认时间是昨天
			System.out.println(date);
		}
		conf.set(GlobalConstants.RUNNING_DATE_PARAMES, date);
	}
}
