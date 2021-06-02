/**@Copyright 2021. All rights are reserved,you should disclose the infromation,  
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.builder.EnrollmentServiceRequestBuilder;
import com.citi.membership.enrollment.builder.EnrollmentServiceResponseBuilder;
import com.citi.membership.enrollment.dao.EnrollmentDao;
import com.citi.membership.enrollment.dao.EnrollmentDaoImpl;
import com.citi.membership.enrollment.dao.EnrollmentHibernateDaoImpl;
import com.citi.membership.enrollment.dao.EnrollmentSpringDaoImpl;
import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentDaoRequest;
import com.citi.membership.enrollment.model.EnrollmentDaoResponse;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.model.StatusBlock;
import com.citi.membership.enrollment.svcclient.CardsServiceClient;
import com.citi.membership.enrollment.svcclient.CardsServiceClientImpl;

/**
 * @author    ::asus
 * @Date      ::Apr 29, 2021
 * Description::
 */
@Component
public class EnrollmentServiceImpl implements EnrollmentService {
	private Logger logger=Logger.getLogger(EnrollmentServiceImpl.class);
	
	@Autowired
	CardsServiceClient cardsServiceClient;
	
	//@Autowired
	//@Qualifier("enrollmentSpringDaoImpl")
	EnrollmentDao enrollmentDao=new EnrollmentDaoImpl();
	@Autowired
	EnrollmentServiceRequestBuilder enrollmentServiceRequestBuilder;
	@Autowired
	EnrollmentServiceResponseBuilder enrollmentServiceResponseBuilder;
	
	public EnrollmentResponse createEnrollment(EnrollmentRequest enrollmentRequest) throws BusinessException, SystemException {
		logger.debug("Enter into service--start");
		//1.Get the enrollment Request from controller.
		//2.Prepare the request for Sevice client
		//3.Call the service client
		//4.Prepare the request for dao with the help of controller request
		EnrollmentDaoRequest daoRequest=enrollmentServiceRequestBuilder.buildDaoRequest(enrollmentRequest);
		
		//5.call dao and get the dao response
		enrollmentDao.createEnrollment(daoRequest);
		EnrollmentDaoResponse daoResponse=enrollmentDao.createEnrollment(daoRequest);

		//6.Prepare the service response with the help of dao.
		EnrollmentResponse enrollmentResponse=enrollmentServiceResponseBuilder.buildEnrollmentResponse(daoResponse);
			
		logger.info("Exit from service--end"+enrollmentResponse);
		return enrollmentResponse;
	}

}
