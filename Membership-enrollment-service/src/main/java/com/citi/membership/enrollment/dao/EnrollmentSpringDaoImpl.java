/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply. 
 *
 * 
 * 
 */
package com.citi.membership.enrollment.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentDaoRequest;
import com.citi.membership.enrollment.model.EnrollmentDaoResponse;

/**
 * @author     ::asus
 * @Date       ::@May 18, 2021
 * @Description::EnrollmentSpringDaoImpl.java
 * @Tags       ::
 */
@Component
@Qualifier("enrollmentSpringDaoImpl")
public class EnrollmentSpringDaoImpl extends StoredProcedure implements EnrollmentDao {

	private Logger logger=Logger.getLogger(EnrollmentDaoImpl.class);
	@Autowired
	public EnrollmentSpringDaoImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate,"MRP_ENROLLMENT");
		logger.debug("*******EnrollmentSpringDaoImpl******");
		registerInputOutputParam();
	}
	/**
	 * 
	 */
	private void registerInputOutputParam() {
		declareParameter(new SqlParameter("CLIENT_ID_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("CHANNEL_ID_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("CARD_NUM_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("CVV_IN", Types.INTEGER));
		declareParameter(new SqlParameter("EXPIRY_DATE_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("NAME_ON_CARD_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("FIRST_NAME_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("LAST_NAME_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("DOB_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("EMAIL_ID_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("MOBILE_NUM_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("ENROLLMENT_DATE_IN", Types.VARCHAR));

		declareParameter(new SqlOutParameter("RESP_CODE_OUT", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESP_MESSAGE_OUT", Types.VARCHAR));
		declareParameter(new SqlOutParameter("ACK_NUM_OUT", Types.VARCHAR));

		compile();
	}
	
	public EnrollmentDaoResponse createEnrollment(EnrollmentDaoRequest enrollmentDaoRequest) throws BusinessException, SystemException  {
		logger.debug("Enter into EnrollmentSpringDaoImpl--start");
		EnrollmentDaoResponse daoResponse=null;
		try {
			//1.Get the request from service
			//2.Prepare the request for db i.e. prepare the db queries
			Map<String, Object> requestMap = new HashMap<String, Object>();

			requestMap.put("CLIENT_ID_IN", enrollmentDaoRequest.getClientId());
			requestMap.put("CHANNEL_ID_IN", enrollmentDaoRequest.getChannelId());
			requestMap.put("CARD_NUM_IN", enrollmentDaoRequest.getCardNum());
			requestMap.put("CVV_IN", enrollmentDaoRequest.getCvv());
			requestMap.put("EXPIRY_DATE_IN", enrollmentDaoRequest.getExpDate());
			requestMap.put("NAME_ON_CARD_IN", enrollmentDaoRequest.getNameOnCard());
			requestMap.put("FIRST_NAME_IN", enrollmentDaoRequest.getFirstName());
			requestMap.put("LAST_NAME_IN", enrollmentDaoRequest.getLastName());
			requestMap.put("DOB_IN", enrollmentDaoRequest.getDob());
			requestMap.put("EMAIL_ID_IN", enrollmentDaoRequest.getEmailId());
			requestMap.put("MOBILE_NUM_IN", enrollmentDaoRequest.getMobNum());
			requestMap.put("ENROLLMENT_DATE_IN", enrollmentDaoRequest.getEnrollmentDate());

			//3.Call db and get the db response i.e. Resultset
			Map<String, Object> responseMap = super.execute(requestMap);

			String dbResponseCode = (String) responseMap.get("RESP_CODE_OUT");
			String dbResponseMsg =(String) responseMap.get("RESP_MESSAGE_OUT");
			
			//4.Prepare the dao response
		/*
			String dbResponseCode="000";
			String dbResponseMsg=null;
		*/	logger.info("Response code :"+dbResponseCode+" Response msg "+dbResponseMsg);
			if ("000".equals(dbResponseCode)) {
				//TODO : replace the hard code values with database response
				daoResponse = new EnrollmentDaoResponse();
				daoResponse.setAckNum((String) responseMap.get("ACK_NUM_OUT"));
				daoResponse.setAckNum("1212abc");
				daoResponse.setEnrollmentStatus("Enrollment Successfull");
				daoResponse.setResponseCode(dbResponseCode);
				daoResponse.setResponseMsg(dbResponseMsg);
		/*		daoResponse.setResponseCode("0");
				daoResponse.setResponseMsg("Success");
		*/		daoResponse.setDiscription("It is enrollment object call");
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
			throw new SystemException("8888","Unknown Error from database form class EnrollemntSpringDaoImpl "+e.getMessage());
		}
		logger.info("Exit from EnrollmentSpringdao--end "+daoResponse);
		return daoResponse;
	}


}
