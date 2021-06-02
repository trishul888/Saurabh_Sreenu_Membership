/**@Copyright 2021. All rights are reserved,you should disclose the infromation,
 * otherwise terms and conditions will apply.
 */
package com.citi.membership.enrollment.builder;

import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.model.EnrollmentDaoRequest;
import com.citi.membership.enrollment.model.EnrollmentRequest;

/**
 * @author     :: asus
 * @Date       ::Jun 2, 2021	
 * @Description::EnrollmentDaoRequest.java
 */
@Component
public class EnrollmentServiceRequestBuilder {
	public EnrollmentDaoRequest buildDaoRequest(EnrollmentRequest enrollmentRequest) {
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
		return daoRequest;
	}
}
