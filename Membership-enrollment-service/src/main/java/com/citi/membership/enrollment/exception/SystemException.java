/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply.  
 * 
 * 
 */
package com.citi.membership.enrollment.exception;

/**
 * @author    ::asus
 * @Date      ::May 1, 2021
 * Description::
 */
public class SystemException extends Exception {
	
	private String responseCode;
	private String responseMsg;
	/**
	 * Construcotors::@param responseCode
	 * Construcotors::@param responseMsg
	 */
	public SystemException(String responseCode, String responseMsg) {

		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
	}
	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}
	/**
	 * @return the responseMsg
	 */
	public String getResponseMsg() {
		return responseMsg;
	}
	@Override
	public String toString() {
		return "SystemException [responseCode=" + responseCode + ", responseMsg=" + responseMsg + "]";
	}


}
