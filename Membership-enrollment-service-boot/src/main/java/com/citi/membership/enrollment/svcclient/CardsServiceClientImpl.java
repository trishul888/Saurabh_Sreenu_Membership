/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply.  
 * 
 * 
 */
package com.citi.membership.enrollment.svcclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.citi.membership.enrollment.model.CardDetailsRequest;
import com.citi.membership.enrollment.model.CardDetailsResponse;

/**
 * @author    ::asus
 * @Date      ::May 3, 2021
 * Description::
 */
@Component
public class CardsServiceClientImpl implements CardsServiceClient {

	private Logger logger=Logger.getLogger(CardsServiceClientImpl.class);
	@Autowired
	RestTemplate restTemplate;
	@Value("${service-url}")
	private String serviceUrl;
	@Value("${service-timeout}")
	private String serviceTimeout;

	public List<String> getCards(String cardNum) {
		// TODO ::Write rest client code to connect CardDetailsService and get the details
		return null;
	}

	public CardDetailsResponse getCardDetails(String cardNum) {
		logger.debug("Enter into CardDetails Service client");
		// TODO ::Write rest client code to connect CardDetailsService and get the details
		//String serviceUrl="http://localhost:8081/Card-details-service-war/v1/carddetails/056789123456789";
		CardDetailsResponse svcResponse=null;

		/*	Map<String,String> vars=new HashMap<>();
		vars.put("hotel","42");
		vars.put("room","21");
		 */
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept", "application/json");
			headers.set("clientId", "mrp");
			headers.set("requestId", UUID.randomUUID().toString().substring(0,16));
			headers.set("msgTs", "12-05-2021");

			logger.info("ServiceUrl: "+serviceUrl);
			logger.info("RestTemplate is::"+restTemplate);
	/*		HttpComponentsClientHttpRequestFactory httpRequestFactory=new HttpComponentsClientHttpRequestFactory();
			httpRequestFactory.setConnectionRequestTimeout(1000);
			httpRequestFactory.setConnectTimeout(1000);
			httpRequestFactory.setReadTimeout(2000);

			restTemplate.setRequestFactory(httpRequestFactory);
	*/
			HttpEntity entity=new HttpEntity<>(headers);

			ResponseEntity<CardDetailsResponse> response=restTemplate.exchange(serviceUrl,HttpMethod.GET,entity,CardDetailsResponse.class);
			if (response!=null && response.getStatusCode().is2xxSuccessful()) {
				svcResponse=response.getBody();
			}
			logger.info(response);
		} catch (RestClientException e) {
			// TODO: handle exception
			//e.printStackTrace();
			logger.error("Rest client exception occures",e);
		}catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			logger.fatal("Unknown exception occures ",e);
		}
		/*	HttpHeaders headers=new HttpHeaders();
		headers.set("Accept","application/json");
		headers.set("clientId", "456");
		headers.set("requstId",UUID.randomUUID().toString().substring(0,16));
		headers.set("messageTs","27-4-21");
		ResponseEntity<CardDetailsResponse> cardDetailsResponse=restTemplate.getForEntity(serviceUrl,CardDetailsResponse.class,vars);
		 */	
		logger.info(svcResponse);
		return svcResponse;
	}

	public CardDetailsResponse getAllCardDetails(CardDetailsRequest cardDetailsRequest) {
		// TODO ::Write rest client code to connect CardDetailsService and get the details
		return null;
	}
}
