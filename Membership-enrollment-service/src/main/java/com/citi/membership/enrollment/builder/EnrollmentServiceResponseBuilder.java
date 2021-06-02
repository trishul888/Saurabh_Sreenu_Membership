/**@Copyright 2021. All rights are reserved,you should disclose the infromation,
 * otherwise terms and conditions will apply.
 */
package com.citi.membership.enrollment.builder;

import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.model.EnrollmentDaoResponse;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.model.StatusBlock;

/**
 * @author     :: asus
 * @Date       ::Jun 2, 2021	
 * @Description::EnrollmentServiceResponseBuilder.java
 */
@Component
public class EnrollmentServiceResponseBuilder {

	public EnrollmentResponse buildEnrollmentResponse(EnrollmentDaoResponse enrollmentDaoResponse) {
		EnrollmentResponse enrollmentResponse=new EnrollmentResponse(); 
		StatusBlock statusBlock=new StatusBlock();
		statusBlock.setResponseCode(enrollmentDaoResponse.getResponseCode());
		statusBlock.setResponseMsg(enrollmentDaoResponse.getResponseMsg());
		enrollmentResponse.setStatusBlock(statusBlock);
		enrollmentResponse.setStatusBlock(statusBlock);
		enrollmentResponse.setEnrollmentStatus(enrollmentDaoResponse.getEnrollmentStatus());
		enrollmentResponse.setAckNum(enrollmentDaoResponse.getAckNum());
		enrollmentResponse.setDescription(enrollmentDaoResponse.getDiscription());
		return enrollmentResponse;
	}
}
