package com.hello.spark.java.sparksql.dataframe;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;

import com.hello.spark.java.bean.Student;


public class CreateDataFrameFromRDDWithReflect {

	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf();
		sparkConf.setMaster("local").setAppName("SparkSQLDemo");
		JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
		
		SQLContext sqlContext = new SQLContext(sparkContext);
		
		/**
		 * 读取普通格式文件
		 * 把普通格式的RDD创建DataFrame
		 * 
		 * 1,zhangsan,18
		 * 2,lisi,19
		 * 3,wangwu,20
		 */
		JavaRDD<String> lineRDD = sparkContext.textFile("student");

		JavaRDD<Student> studentRDD = lineRDD.map(new Function<String, Student>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Student call(String line) throws Exception {

				Student student = new Student();
				
				student.setId(line.split(",")[0]);
				student.setName(line.split(",")[1]);
				student.setAge(Integer.valueOf(line.split(",")[2]));
				
				return student;
			}
		});
		
		/**
		 * 传入进去Student.class的时候，sqlContext是通过反射的方式创建DataFrame
		 * 在底层通过反射的方式获得Student的所有field，结合RDD本身，就生成了DataFrame
		 */
		DataFrame dataFrame = sqlContext.createDataFrame(studentRDD, Student.class);
		dataFrame.show();
		// TODO
		System.out.println("1----------------------------------------------------------------------------------------------------------------");
		/**
		 *
		 	+---+---+--------+
			|age| id|    name|
			+---+---+--------+
			| 18|  1|zhangsan|
			| 19|  2|    lisi|
			| 20|  3|  wangwu|
			+---+---+--------+
		 *
		 * */
		dataFrame.printSchema();
		// TODO
		System.out.println("2----------------------------------------------------------------------------------------------------------------");
		/**
		 *
			root
			 |-- age: integer (nullable = true)
			 |-- id: string (nullable = true)
			 |-- name: string (nullable = true)
		 *
		 * */
		
		// 注册表
		dataFrame.registerTempTable("student_table");
		// TODO
		System.out.println("3----------------------------------------------------------------------------------------------------------------");
		
		// 读取注册表中的数据
		DataFrame selectResult = sqlContext.sql("select * from student_table where id = '1'");
		
		selectResult.show();
		/**
		 * 
			+---+---+--------+
			|age| id|    name|
			+---+---+--------+
			| 18|  1|zhangsan|
			+---+---+--------+
		 * 
		 */
		// TODO
		System.out.println("4----------------------------------------------------------------------------------------------------------------");
		
		
		selectResult = sqlContext.sql("select id, name, age from student_table where name = 'lisi'");
		
		selectResult.show();
		/**
		 * 
		 	+---+----+---+
			| id|name|age|
			+---+----+---+
			|  2|lisi| 19|
			+---+----+---+	
		  
		 *  
		 * */
		// TODO
		System.out.println("5----------------------------------------------------------------------------------------------------------------");
		
		selectResult = sqlContext.sql("select name, age from student_table where age > 18");
		
		selectResult.show();
		/**
		 *
		 	+------+---+
			|  name|age|
			+------+---+
			|  lisi| 19|
			|wangwu| 20|
			+------+---+
		 *  
		 * */
		// TODO
		System.out.println("6----------------------------------------------------------------------------------------------------------------");
		
		
		// 关闭资源
		sparkContext.close();
	}
}
