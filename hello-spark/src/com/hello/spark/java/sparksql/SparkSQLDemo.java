package com.hello.spark.java.sparksql;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import com.hello.spark.java.bean.Student;


public class SparkSQLDemo {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf();
		sparkConf.setMaster("local").setAppName("CreateDataFrameFromRDDWithStruct-Java");
		
		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
			
	
		JavaRDD<String> lineRDD = sparkContext.textFile("./student");
		
		SQLContext sqlContext = new SQLContext(sparkContext);
	
		
		/**
		 * 将String类型的RDD  转换成  Row类型的RDD
		 */
		JavaRDD<Row> rowRDD = lineRDD.map(new Function<String, Row>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Row call(String line) throws Exception {
				Row row = RowFactory.create(line.split(",")[0], line.split(",")[1], Integer.valueOf(line.split(",")[2]));
				return row;
			}
		});
		
		
		/**
		 * 动态构建DataFrame中的元数据，一般来说这里的字段可以来源自字符串，也可以来源于外部数据库
		 */
		List<StructField> fields = Arrays.asList(
					DataTypes.createStructField("id", DataTypes.StringType, true),
					DataTypes.createStructField("name", DataTypes.StringType, true),
					DataTypes.createStructField("age", DataTypes.IntegerType, true)
				);
		
		StructType structType = DataTypes.createStructType(fields);
		
		
		DataFrame dataFrame = sqlContext.createDataFrame(rowRDD, structType);
		
		dataFrame.show();
		/**
		 * 
		 	+---+--------+---+
			| id|    name|age|
			+---+--------+---+
			|  1|zhangsan| 18|
			|  2|    lisi| 19|
			|  3|  wangwu| 20|
			+---+--------+---+
		 * 
		 */
		// TODO
		System.out.println("1----------------------------------------------------------------------------------------------------------------");
		
		dataFrame.printSchema();
		/**
		 * 
		 	root
			 |-- id: string (nullable = true)
			 |-- name: string (nullable = true)
			 |-- age: integer (nullable = true)
		 * 
		 */
		// TODO
		System.out.println("2----------------------------------------------------------------------------------------------------------------");
		
		// 注册表
		dataFrame.registerTempTable("student_table");
		// TODO
		System.out.println("3----------------------------------------------------------------------------------------------------------------");
		
		
		// 读取注册表中的数据
		DataFrame selectResult = sqlContext.sql("select * from student_table where id = '1'");
		
		selectResult.show();
		/**
		 * 
		 	+---+--------+---+
			| id|    name|age|
			+---+--------+---+
			|  1|zhangsan| 18|
			+---+--------+---+
		 * 
		 */
		
		// 关闭资源
		sparkContext.close();
	}
}
