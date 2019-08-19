package com.hello.test.spark.java.macOS;


import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


public class HelloSparkSession {

	public static void main(String[] args) {

		String inputPath = "file:///Users/hiahia/develop/hello/";
		String inputFilePathHello = inputPath +"hello.txt";
		String inputFilePathHelloWithHeader = inputPath +"hello-with-header.txt";

		String inputFilePathHelloCSV = inputPath +"hello.CSV";
		String inputFilePathHelloWithHeaderCSV = inputPath +"hello-with-header.CSV";


		String outputPath = "file:///Users/hiahia/develop/hello/output/spark/java/wordcount/macos";

		SparkSession spark = SparkSession.builder().master("local").appName("local").getOrCreate();


		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* hello.txt */
		/*
hello java
hello scala
hello hadoop
hello spark
world is good
		*/
		System.out.println("textFile");

		Dataset<String> textFile = spark.read().textFile(inputFilePathHello);
		textFile.show();

		/*
+-------------+
|        value|
+-------------+
|   hello java|
|  hello scala|
| hello hadoop|
|  hello spark|
|world is good|
+-------------+
		*/

		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		/* hello-with-header.txt */
		/*
c1 c2
hello java
hello scala
hello hadoop
hello spark
		*/
		/* --------------------------------------------------------------------------------------------------------- */

		System.out.println("textFile header \"true\"");

		Dataset<String> textFile1 = spark.read().option("header","true").textFile(inputFilePathHelloWithHeader);
		textFile1.show();

		/*
+------------+
|       value|
+------------+
|       c1 c2|
|  hello java|
| hello scala|
|hello hadoop|
| hello spark|
+------------+
		*/
		/* --------------------------------------------------------------------------------------------------------- */
		System.out.println("textFile header true");

		Dataset<String> textFile2 = spark.read().option("header", true).textFile(inputFilePathHelloWithHeader);
		textFile2.show();

		/*
+------------+
|       value|
+------------+
|       c1 c2|
|  hello java|
| hello scala|
|hello hadoop|
| hello spark|
+------------+
		*/
		/* --------------------------------------------------------------------------------------------------------- */
		System.out.println("textFile header \"false\"");

		Dataset<String> textFile3 = spark.read().option("header","false").textFile(inputFilePathHelloWithHeader);
		textFile3.show();

		/*
+------------+
|       value|
+------------+
|       c1 c2|
|  hello java|
| hello scala|
|hello hadoop|
| hello spark|
+------------+
		*/

		/* --------------------------------------------------------------------------------------------------------- */
		System.out.println("textFile header false");

		Dataset<String> textFile4 = spark.read().option("header", false).textFile(inputFilePathHelloWithHeader);
		textFile4.show();

		/*
+------------+
|       value|
+------------+
|       c1 c2|
|  hello java|
| hello scala|
|hello hadoop|
| hello spark|
+------------+
		*/

		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */
		System.out.println("csv");
		/* hello.csv */
		/*
1, 1, 0
2, 2, 1
3, 4, 1
4, 1, 0
5, 3, 1
6, 6, 1
		*/
		/* --------------------------------------------------------------------------------------------------------- */

		Dataset<Row> csv = spark.read().csv(inputFilePathHelloCSV);
		csv.show();

		/*
+---+---+---+
|_c0|_c1|_c2|
+---+---+---+
|  1|  1|  0|
|  2|  2|  1|
|  3|  4|  1|
|  4|  1|  0|
|  5|  3|  1|
|  6|  6|  1|
+---+---+---+
		*/

		/* --------------------------------------------------------------------------------------------------------- */

		/* hello-with-header.csv */
		/*
id, c1, c2
1, 1, 0
2, 2, 1
3, 4, 1
4, 1, 0
5, 3, 1
6, 6, 1
		*/
		/* --------------------------------------------------------------------------------------------------------- */

		Dataset<Row> csv1 = spark.read().option("header", "false").csv(inputFilePathHelloWithHeaderCSV);
		csv1.show();

		/*
+---+---+---+
|_c0|_c1|_c2|
+---+---+---+
| id| c1| c2|
|  1|  1|  0|
|  2|  2|  1|
|  3|  4|  1|
|  4|  1|  0|
|  5|  3|  1|
|  6|  6|  1|
+---+---+---+
		*/

		/* --------------------------------------------------------------------------------------------------------- */

		Dataset<Row> csv2 = spark.read().option("header", false).csv(inputFilePathHelloWithHeaderCSV);
		csv2.show();

		/*
+---+---+---+
|_c0|_c1|_c2|
+---+---+---+
| id| c1| c2|
|  1|  1|  0|
|  2|  2|  1|
|  3|  4|  1|
|  4|  1|  0|
|  5|  3|  1|
|  6|  6|  1|
+---+---+---+
		*/

		/* --------------------------------------------------------------------------------------------------------- */

		Dataset<Row> csv3 = spark.read().option("header", "true").csv(inputFilePathHelloWithHeaderCSV);
		csv3.show();

		/*
+---+---+---+
| id| c1| c2|
+---+---+---+
|  1|  1|  0|
|  2|  2|  1|
|  3|  4|  1|
|  4|  1|  0|
|  5|  3|  1|
|  6|  6|  1|
+---+---+---+
		*/

		/* --------------------------------------------------------------------------------------------------------- */

		Dataset<Row> csv4 = spark.read().option("header", true).csv(inputFilePathHelloWithHeaderCSV);
		csv4.show();

		/*
+---+---+---+
| id| c1| c2|
+---+---+---+
|  1|  1|  0|
|  2|  2|  1|
|  3|  4|  1|
|  4|  1|  0|
|  5|  3|  1|
|  6|  6|  1|
+---+---+---+
		*/




		/* ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| */






		spark.stop();


	}
}

