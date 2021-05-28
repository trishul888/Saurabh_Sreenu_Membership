/**@Copyright 2021. All rights are reserved,you should disclose the infromation,
 * otherwise terms and conditions will apply.
 */
package com.citi.membership.enrollment.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.client.RestTemplate;

import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.EnrollmentDaoRequest;
import com.citi.membership.enrollment.model.EnrollmentDaoResponse;

/**
 * @author     :: asus
 * @Date       ::May 28, 2021	
 * @Description::EnrollmentDaoImplTest.java
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(EnrollmentDaoImpl.class)
public class EnrollmentDaoImplTest {

	@InjectMocks
	EnrollmentDaoImpl enrollmentDaoImpl;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.citi.membership.enrollment.dao.EnrollmentDaoImpl#createEnrollment(com.citi.membership.enrollment.model.EnrollmentDaoRequest)}.
	 * @throws SystemException 
	 * @throws BusinessException 
	 */
	@Test
	public void testCreateEnrollment() throws BusinessException, SystemException {
		
		EnrollmentDaoImpl enrollmentDaoImpl=new EnrollmentDaoImpl();
		EnrollmentDaoRequest enrollmentDaoRequest=new EnrollmentDaoRequest();
		EnrollmentDaoResponse enrollmentDaoResponse=enrollmentDaoImpl.createEnrollment(enrollmentDaoRequest);
		
		assertNotNull(enrollmentDaoResponse);
	}

}
