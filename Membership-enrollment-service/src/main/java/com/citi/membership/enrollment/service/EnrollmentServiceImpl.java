/**@Copyright 2021. All rights are reserved,you should disclose the infromation,  
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.dao.EnrollmentDao;
import com.citi.membership.enrollment.dao.EnrollmentDaoImpl;
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
	EnrollmentDao enrollmentDao;
	
	public EnrollmentResponse createEnrollment(EnrollmentRequest enrollmentRequest) throws BusinessException, SystemException {
		logger.debug("Enter into service--start");
		//1.Get the enrollment Request from controller.
		//2.Prepare the request for Sevice client
		CardsServiceClient cardsServiceClient=new CardsServiceClientImpl();
		
		//3.Call the service client
		//4.Prepare the request for dao with the help of controller request
		EnrollmentDaoRequest daoRequest=new EnrollmentDaoRequest();
		daoRequest.setFirstName(enrollmentRequest.getCustomerInfo().getFirstName());
		daoRequest.setLastName(enrollmentRequest.getCustomerInfo().getLastName());
		daoRequest.setCardNum(enrollmentRequest.getCustomerInfo().getCardNum());
		daoRequest.setCvv(enrollmentRequest.getCustomerInfo().getCvv());
		daoRequest.setDob(enrollmentRequest.getCustomerInfo().getDob());
		daoRequest.setEmailId(enrollmentRequest.getCustomerInfo().getEmailId());
		daoRequest.setEnrollmentDate(enrollmentRequest.getCustomerInfo().getEnrollmentDate());
		daoRequest.setExpDate(enrollmentRequest.getCustomerInfo().getExpDate());
		daoRequest.setMobNum(enrollmentRequest.getCustomerInfo().getMobNum());
		daoRequest.setNameOnCard(enrollmentRequest.getCustomerInfo().getNameOnCard());
		daoRequest.setClientId(enrollmentRequest.getCustomerInfo().getClientId());
		daoRequest.setMsgts(enrollmentRequest.getCustomerInfo().getMsgts());
		
		//5.call dao and get the dao response
		enrollmentDao.createEnrollment(daoRequest);
		EnrollmentDaoResponse daoResponse=enrollmentDao.createEnrollment(daoRequest);

		//6.Prepare the service response with the help of dao.
		EnrollmentResponse enrollmentResponse=new EnrollmentResponse(); 
		StatusBlock statusBlock=new StatusBlock();
		statusBlock.setResponseCode(daoResponse.getResponseCode());
		statusBlock.setResponseMsg(daoResponse.getResponseMsg());
		enrollmentResponse.setStatusBlock(statusBlock);
		enrollmentResponse.setStatusBlock(statusBlock);
		enrollmentResponse.setEnrollmentStatus(daoResponse.getEnrollmentStatus());
		enrollmentResponse.setAckNum(daoResponse.getAckNum());
		enrollmentResponse.setDescription(daoResponse.getDiscription());
			
		logger.info("Exit from service--end"+enrollmentResponse);
		return enrollmentResponse;
	}

}
