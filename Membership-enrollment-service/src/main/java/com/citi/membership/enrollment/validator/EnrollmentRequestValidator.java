/**@Copyright 2021. All rights are reserved,you should disclose the infromation,
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.validator;

import org.springframework.stereotype.Component;

import com.citi.membership.enrollment.exception.EnrollmentRequestValidationException;
import com.citi.membership.enrollment.model.EnrollmentRequest;

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
		
	}

}
