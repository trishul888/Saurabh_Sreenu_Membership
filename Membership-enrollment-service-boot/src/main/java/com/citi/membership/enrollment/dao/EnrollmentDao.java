/**@Copyright 2021. All rights are reserved,you should disclose the infromation,  
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.dao;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentDaoRequest;
import com.citi.membership.enrollment.model.EnrollmentDaoResponse;

/**
 * @author    ::asus
 * @Date      ::Apr 29, 2021
 * Description::
 */
public interface EnrollmentDao {
	public EnrollmentDaoResponse createEnrollment(EnrollmentDaoRequest enrollmentDaoRequest) throws BusinessException, SystemException ;
} 