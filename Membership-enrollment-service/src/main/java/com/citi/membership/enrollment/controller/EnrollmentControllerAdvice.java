/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply.  
 * 
 * 
 */
package com.citi.membership.enrollment.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.EnrollmentRequestValidationException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.model.StatusBlock;
import com.citi.membership.enrollment.util.EnrollmentConstant;

/**
 * @author    ::asus
 * @Date      ::May 1, 2021
 * Description::
 */
@ControllerAdvice
public class EnrollmentControllerAdvice {

	@ExceptionHandler(value=EnrollmentRequestValidationException.class)
	@ResponseBody
	public EnrollmentResponse handleRequstInvalidException(EnrollmentRequestValidationException exception) {
		//TODO::need to implement error logs
		EnrollmentResponse enrollmentResponse = buildStatusBlock(exception.getResponseCode(),exception.getResponseMsg());
		return enrollmentResponse;
	}
	
	
	@ExceptionHandler(value=SystemException.class)
	@ResponseBody
	public EnrollmentResponse handleSystemError(SystemException exception) {
		//TODO::need to implement error logs
		EnrollmentResponse enrollmentResponse = buildStatusBlock(exception.getResponseCode(),exception.getResponseMsg());
		return enrollmentResponse;
	}

	@ExceptionHandler(value=BusinessException.class)
	@ResponseBody
	public EnrollmentResponse handleBusinessError(BusinessException exception) {
		//TODO::need to implement error logs
		EnrollmentResponse enrollmentResponse = buildStatusBlock(exception.getResponseCode(),exception.getResponseMsg());
		return enrollmentResponse;
	}
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public EnrollmentResponse handleDataError(Exception exception) {
		//TODO::need to implement error logs
		EnrollmentResponse enrollmentResponse = buildStatusBlock(EnrollmentConstant.GENERIC_ERROR_CODE,EnrollmentConstant.GENERIC_ERROR_MSG);
		return enrollmentResponse;
	}
	
	/**
	 * @param exception
	 * @return
	 */
	private EnrollmentResponse buildStatusBlock(String responseCode,String responseMsg) {
		EnrollmentResponse enrollmentResponse=new EnrollmentResponse();
		StatusBlock statusBlock=new StatusBlock();
		statusBlock.setResponseCode(responseCode);
		statusBlock.setResponseMsg(responseMsg);
		enrollmentResponse.setStatusBlock(statusBlock);
		return enrollmentResponse;
	}

	
}
