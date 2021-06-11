/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply.  
 * 
 * 
 */
package com.citi.membership.enrollment.controller;

import com.citi.membership.enrollment.model.ClientInfo;
import com.citi.membership.enrollment.model.CustomerInfo;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author    ::asus
 * @Date      ::Apr 30, 2021
 * Description::
 */
public class EnrollmentToJsonObject {
	public static void main(String[] args)  {

		EnrollmentRequest enrollmentRequest=new EnrollmentRequest();


		ClientInfo clientInfo=new ClientInfo();
		clientInfo.setRequestId("web");
		clientInfo.setChannelId("online");
		clientInfo.setClientInfo("safhalfaf");
		clientInfo.setMessageTs("27-4-21");

		
		CustomerInfo customerInfo =new CustomerInfo();
		customerInfo.setCardNum("54542455224");
		customerInfo.setClientId("456");
		customerInfo.setCvv("55");
		customerInfo.setDob("23/2/21");
		customerInfo.setEmailId("saurabh23patre@gmail.com");
		customerInfo.setEnrollmentDate("12/5/20");
		customerInfo.setExpDate("22/5/21");
		customerInfo.setFirstName("saurabh");
		customerInfo.setLastName("patre");
		customerInfo.setMobNum("9527766635");
		customerInfo.setMsgts("safa");;
		customerInfo.setNameOnCard("safafa");
		
		enrollmentRequest.setClientInfo(clientInfo);
		enrollmentRequest.setCustomerInfo(customerInfo );


		ObjectMapper mapper=new ObjectMapper();

		try {
			String 	resp = mapper.writeValueAsString(mapper);
			System.out.println(resp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
