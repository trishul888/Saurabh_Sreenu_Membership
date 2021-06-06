/**@Copyright 2021. All rights are reserved,you should disclose the infromation,
 * otherwise terms and conditions will apply.
 */
package com.citi.membership.enrollment.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentDaoRequest;
import com.citi.membership.enrollment.model.EnrollmentDaoResponse;

/**
 * @author     :: asus
 * @Date       ::May 24, 2021	
 * @Description::EnrollmentHibernateDaoImpl.java
 */
@Component
//@Qualifier("EnrollmentHibernateDaoImpl")
public class EnrollmentSpringHibernateTemplateDaoImpl implements EnrollmentDao{

	private Logger logger=Logger.getLogger(EnrollmentSpringHibernateTemplateDaoImpl.class);
	
	/**
	 * 
	 */
	public EnrollmentDaoResponse createEnrollment(EnrollmentDaoRequest enrollmentDaoRequest) throws BusinessException, SystemException  {
		logger.debug("Enter into EnrollmentHibernateDaoImpl--start");
		EnrollmentDaoResponse daoResponse=null;
		String dbResponseCode="000";
		String dbResponseMsg=null;
		String ACK_NUMBER=null;
		try {
			
			//1.Get the request from service
			//2.Prepare the request for db i.e. prepare the db queries
			
			//3.Call db and get the db response i.e. Resultset

			//4.Prepare the dao response
			//logger.info("Hibernate Template " +hibernateTemplate);
			logger.info("Response code :"+dbResponseCode+" Response msg "+dbResponseMsg);
			if ("000".equals(dbResponseCode)) {
				//TODO : replace the hard code values with database response
				daoResponse = new EnrollmentDaoResponse();
				//daoResponse.setAckNum((String) responseMap.get("ACK_NUM_OUT"));
				daoResponse.setAckNum(ACK_NUMBER);
				daoResponse.setEnrollmentStatus("Enrollment Successfull");
				daoResponse.setResponseCode(dbResponseCode);
				daoResponse.setResponseMsg(dbResponseMsg);
//				daoResponse.setResponseCode("0");
//				daoResponse.setResponseMsg("Success");
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
			throw new SystemException("8888","Unknown Error from database form class EnrollemntSpringDaoImpl "+e.getMessage());
		}
		logger.info("Exit from EnrollmentHibernateDaoImpl--end "+daoResponse);
		return daoResponse;
	}

}
