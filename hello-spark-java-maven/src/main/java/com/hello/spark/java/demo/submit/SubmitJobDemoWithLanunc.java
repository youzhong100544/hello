package com.hello.spark.java.demo.submit;

import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SubmitJobDemoWithLanunc {
	public static void main(String[] args) throws IOException, InterruptedException {

		HashMap env = new HashMap();
		//这两个属性必须设置
		env.put("HADOOP_CONF_DIR","/usr/local/hadoop/etc/overriterHaoopConf");
		env.put("JAVA_HOME","/usr/local/java/jdk1.8.0_151");
		//env.put("YARN_CONF_DIR","");

		SparkLauncher handle = new SparkLauncher(env)
				.setSparkHome("/usr/local/spark")
				.setAppResource("/usr/local/spark/spark-demo.jar")
				.setMainClass("com.learn.spark.SimpleApp")
				.setMaster("yarn")
				.setDeployMode("cluster")
				.setConf("spark.app.id", "11222")
				.setConf("spark.driver.memory", "2g")
				.setConf("spark.akka.frameSize", "200")
				.setConf("spark.executor.memory", "1g")
				.setConf("spark.executor.instances", "32")
				.setConf("spark.executor.cores", "3")
				.setConf("spark.default.parallelism", "10")
				.setConf("spark.driver.allowMultipleContexts","true")
				.setVerbose(true);


		Process process =handle.launch();
		InputStreamReaderRunnable inputStreamReaderRunnable = new InputStreamReaderRunnable(process.getInputStream(), "input");
		Thread inputThread = new Thread(inputStreamReaderRunnable, "LogStreamReader input");
		inputThread.start();

		InputStreamReaderRunnable errorStreamReaderRunnable = new InputStreamReaderRunnable(process.getErrorStream(), "error");
		Thread errorThread = new Thread(errorStreamReaderRunnable, "LogStreamReader error");
		errorThread.start();

		System.out.println("Waiting for finish...");
		int exitCode = process.waitFor();
		System.out.println("Finished! Exit code:" + exitCode);

	}


	public static class InputStreamReaderRunnable implements Runnable {

		private BufferedReader reader;

		private String name;

		public InputStreamReaderRunnable(InputStream is, String name) {
			this.reader = new BufferedReader(new InputStreamReader(is));
			this.name = name;
		}

		public void run() {
			System.out.println("InputStream " + name + ":");
			try {
				String line = reader.readLine();
				while (line != null) {
					System.out.println(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
