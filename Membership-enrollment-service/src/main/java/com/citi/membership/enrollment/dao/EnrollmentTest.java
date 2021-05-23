/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply. 
 *
 * 
 * 
 */
package com.citi.membership.enrollment.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author     ::asus
 * @Date       ::@May 17, 2021
 * @Description::EnrollmentTest.java
 * @Tags       ::
 */
public class EnrollmentTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","java","saurabh");
		String sql="{call MRP_ENROLLMENT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		CallableStatement cs=connection.prepareCall(sql);

		cs.registerOutParameter(13, Types.VARCHAR);
		cs.registerOutParameter(14, Types.VARCHAR);
		cs.registerOutParameter(15, Types.VARCHAR);

		cs.setString(1, "web");
		cs.setString(2, "online");
		cs.setString(3, "44444444444");
		cs.setString(4, "123");
		cs.setString(5, "12-2018");
		cs.setString(6, "sunny");
		cs.setString(7, "sreeenu");
		cs.setString(8, "tech");
		cs.setString(9, "24-03-2018");
		cs.setString(10, "sreenu.sreenutech@gmail.com");
		cs.setString(11, "987878978");
		cs.setString(12, "30-12-2018");
		boolean  b = cs.execute();

		System.out.println(" boolean value is :"+b);

		System.out.println(cs.getString(13));
		System.out.println(cs.getString(14));
		System.out.println(cs.getString(15));	
		}

}
