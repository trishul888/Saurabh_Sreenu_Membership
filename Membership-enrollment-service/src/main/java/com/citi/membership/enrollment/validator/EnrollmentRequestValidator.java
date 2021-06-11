/**@Copyright 2021. All rights are reserved,you should disclose the infromation,
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.validator;

import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.exception.EnrollmentRequestValidationException;
import com.citi.membership.enrollment.model.ClientInfo;
import com.citi.membership.enrollment.model.CustomerInfo;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.util.EnrollmentConstant;

/**
 * @author    ::asus
 * @Date      ::Apr 29, 2021
 * Description::
 */
@Component
public class EnrollmentRequestValidator {

	/**
	 * @param enrollmentRequest
	 */
	public void validate(EnrollmentRequest enrollmentRequest)throws EnrollmentRequestValidationException {
		
		//TODO:: Validate the request.If any one of the element is invalid then send exception
		//Need to handle user defined exception.
		if(enrollmentRequest==null|| enrollmentRequest.getClientInfo()==null || enrollmentRequest.getCustomerInfo()==null) {
			throw new EnrollmentRequestValidationException(EnrollmentConstant.ENS001, EnrollmentConstant.ENS001_DESC);
		}
		
		final ClientInfo clientInfo  = enrollmentRequest.getClientInfo();
		//client id null or empty scenarios
		if( clientInfo.getClientInfo() == null || " ".equals(clientInfo.getClientInfo())) {
			throw new EnrollmentRequestValidationException("ens002", "Invalid Client Id");
		}
		
		//channel id null or empty scenarios
		if( clientInfo.getChannelId() == null || " ".equals(clientInfo.getChannelId())) {
			throw new EnrollmentRequestValidationException("ens003", "Invalid Client Id");
		}
		final CustomerInfo customerInfo = enrollmentRequest.getCustomerInfo();
		//card number is null or empty scenarios
		if( customerInfo.getCardNum() == null || " ".equals(customerInfo.getCardNum())) {
			throw new EnrollmentRequestValidationException("ens004", "Invalid Card number ");
		}
	}

}
