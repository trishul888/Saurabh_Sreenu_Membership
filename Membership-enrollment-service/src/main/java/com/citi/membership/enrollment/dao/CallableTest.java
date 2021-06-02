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

import org.apache.log4j.Logger;

/**
 * @author     ::asus
 * @Date       ::@May 18, 2021
 * @Description::CallableTest.java
 * @Tags       ::
 */
public class CallableTest {
	private final static Logger logger=Logger.getLogger(CallableTest.class);
	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(final String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		final Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","java","saurabh");
		final String sql = "{call GET_TRANSACTIONS(?,?,?,?,?,?,?,?)}";
		final CallableStatement cs=connection.prepareCall(sql);

		cs.registerOutParameter(7, Types.VARCHAR);
		cs.registerOutParameter(8, Types.VARCHAR);

		cs.setString(1, "web");
		cs.setString(2, "online");
		cs.setString(3, "44444444444");
		cs.setLong(4, 123);
		cs.setString(5, "12-2018");
		cs.setString(6, "sunny");

		final boolean  b = cs.execute();
		
		logger.info(" boolean value is :"+b);
		/*ResultSet rs = cs.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString(1) + "--" + rs.getString(2) + "--" + rs.getString(3));
		}*/

		logger.debug(cs.getString(7));
		logger.debug(cs.getString(8));
		cs.close();
		connection.close();
	}

}
