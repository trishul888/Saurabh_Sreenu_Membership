/**@Copyright 2021. All rights are reserved,you should disclose the infromation,  
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentDaoRequest;
import com.citi.membership.enrollment.model.EnrollmentDaoResponse;

/**
 * @author    ::asus
 * @Date      ::Apr 29, 2021
 * Description::
 */
@Component
public class EnrollmentDaoImpl implements EnrollmentDao {
	private Logger logger=Logger.getLogger(EnrollmentDaoImpl.class);
	public EnrollmentDaoResponse createEnrollment(EnrollmentDaoRequest enrollmentDaoRequest) throws BusinessException, SystemException  {
		logger.debug("Enter into EnrollmentDaoImpl--start");
		EnrollmentDaoResponse daoResponse=null;
		try {
			
			//1.Get the request from service
			//2.Prepare the request for db i.e. prepare the db queries
		/*	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","java","saurabh");
			String sql = null;//"{call MRP_ENROLLMENT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			//3.Call db and get the db response i.e. Resultset
			CallableStatement cs=connection.prepareCall(sql);
			
			cs.registerOutParameter(13, Types.VARCHAR);
			cs.registerOutParameter(14, Types.VARCHAR);
			cs.registerOutParameter(15, Types.VARCHAR);

			cs.setString(1, enrollmentDaoRequest.getClientId());
			cs.setString(2, "online");
			cs.setString(3, enrollmentDaoRequest.getCardNum());
			cs.setString(4, enrollmentDaoRequest.getCvv());
			cs.setString(5, enrollmentDaoRequest.getExpDate());
			cs.setString(6, enrollmentDaoRequest.getNameOnCard());
			cs.setString(7, enrollmentDaoRequest.getFirstName());
			cs.setString(8, enrollmentDaoRequest.getLastName());
			cs.setString(9, enrollmentDaoRequest.getDob());
			cs.setString(10, enrollmentDaoRequest.getEmailId());
			cs.setString(11, enrollmentDaoRequest.getMobNum());
			cs.setString(12, enrollmentDaoRequest.getEnrollmentDate());

			boolean  b = cs.execute();
			System.out.println("b is:"+b);
			String dbRespCode = cs.getString(13);
			String dbRespMsg = cs.getString(14);
			*/
			//4.Prepare the dao response
			String dbResponseCode="000";
			String dbResponseMsg=null;
			logger.info("Response code :"+dbResponseCode+" Response message "+dbResponseMsg);
			if ("000".equals(dbResponseCode)) {
				//TODO : replace the hard code values with database response
				daoResponse = new EnrollmentDaoResponse();
				daoResponse.setAckNum("1212abc");
				daoResponse.setEnrollmentStatus("Enrollment Successfull");
				daoResponse.setResponseCode("0");
				daoResponse.setResponseMsg("Success");
				daoResponse.setDiscription("It is enrollment object call");
			}else if( "100".equals(dbResponseCode) || "101".equals(dbResponseCode) || "1002".equals(dbResponseCode)){
				
				throw new BusinessException(dbResponseCode, dbResponseMsg);
			} else {
				throw new SystemException(dbResponseCode, dbResponseMsg);
			}
		}catch (BusinessException be) {
			//error log - 
			//be.printStackTrace();
			//TODO : add error logs here
			logger.error("Business Exceptions ",be);
			throw be;
		} catch (SystemException se) {
			//error log - 
			//TODO : add error logs here
			logger.error("System Exceptions ",se);
			throw se;
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			logger.fatal("Unknown Error from database ",e);
			throw new SystemException("8888","Unknown Error from database "+e.getMessage());
		}
		logger.info("Exit from dao--end "+daoResponse);
		return daoResponse;
	}

}
