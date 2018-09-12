package com.hello.mysql;

import java.sql.*;

public class HelloMysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user="root";
		String password="123456";
		String url="jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC";//mydb为Mysql数据库中创建的数据库实例名
		String driver="com.mysql.cj.jdbc.Driver";

		String tableName="studinfo";//studinfo为数据库mydb中的表名
		String sqlstr;
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;

		try{
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
			stmt=con.createStatement();

			sqlstr="insert into "+tableName+ " value('1111','honey',21)";//into的后面和value前面一定要添加一个空格；value后面与左括号之间有无空格无所谓。
			stmt.executeUpdate(sqlstr);

			sqlstr="select * from "+ tableName;
			rs=stmt.executeQuery(sqlstr);

			ResultSetMetaData rsmd=rs.getMetaData();
			int j=0;
			j=rsmd.getColumnCount();
			for(int k=0;k<j;k++){
				System.out.print(rsmd.getColumnName(k+1));
				System.out.print("\t");
			}

			System.out.println();

			while(rs.next()){
				for(int i=0;i<j;i++){
					System.out.print(rs.getString(i+1));
					System.out.print("\t");
				}
				System.out.println();
			}
		} catch(ClassNotFoundException e1){
			System.out.print("数据库驱动不存在！");
			System.out.print(e1.toString());
		} catch(SQLException e2){
			System.out.print("数据库存在异常！");
			System.out.print(e2.toString());
		} finally{
			try{
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			} catch(SQLException e){
				System.out.print(e.toString());
			}
		}
	}
}