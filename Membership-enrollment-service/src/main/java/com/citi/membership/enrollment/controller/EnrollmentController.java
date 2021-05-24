/**@Copyright 2021. All rights are reserved,you should disclose the infromation,
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.EnrollmentRequestValidationException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.model.StatusBlock;
import com.citi.membership.enrollment.service.EnrollmentService;
import com.citi.membership.enrollment.validator.EnrollmentRequestValidator;

/**
 * @author    ::asus
 * @Date      ::Apr 29, 2021
 * Description::
 */

@RestController
@RequestMapping(value = "/customer")
public class EnrollmentController {
	private Logger logger=Logger.getLogger(EnrollmentController.class);
	@Autowired
	EnrollmentRequestValidator validator;
	@Autowired
	EnrollmentService service;
	
	@RequestMapping(value = "/enrollment",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
	@ResponseBody
	public EnrollmentResponse createEnrollment(@RequestBody EnrollmentRequest enrollmentRequest)throws EnrollmentRequestValidationException,BusinessException,SystemException {
		logger.debug("Enter into Controller--start");
		EnrollmentResponse enrollmentResponse=null;
		try {
			//1.Get the request from consumers/clients.
			//2.Validate the request.
			validator.validate(enrollmentRequest);
			//3.Prepare the request for service.
			//4.Call service and get the response.
			enrollmentResponse = service.createEnrollment(enrollmentRequest);
			//5.Prepare the controller response.
		} catch (EnrollmentRequestValidationException e) {
			// TODO Auto-generated catch block
			enrollmentResponse=new EnrollmentResponse();
			StatusBlock statusBlock=new StatusBlock();
			statusBlock.setResponseCode(e.getResponseCode());
			statusBlock.setResponseMsg(e.getResponseMsg());
			enrollmentResponse.setStatusBlock(statusBlock);
		}
		logger.debug("Exit from Controller--end");
		return enrollmentResponse;
	}
	
	@RequestMapping(value = "/health",method = RequestMethod.GET)
	public String healthCheck() {
		logger.debug("EnrollmentController.healthCheck()");
		return "Service UP and Running.............s";
	}
	   
}
