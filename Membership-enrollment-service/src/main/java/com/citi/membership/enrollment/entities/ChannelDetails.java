/**@Copyright 2021. All rights are reserved,you should disclose the information,
 * otherwise terms and conditions will apply.
 */
package com.citi.membership.enrollment.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author     :: asus
 * @Date       ::May 23, 2021	
 * @Description::ChannelDetails.java
 */
@Data
@Entity
@Table(name = "channel_details")
public class ChannelDetails {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@Column(name = "channel_id")
	private String channelId;
	
	@Column(name = "description")
	private String channelDescription;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the channelId
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	/**
	 * @return the channelDescription
	 */
	public String getChannelDescription() {
		return channelDescription;
	}

	/**
	 * @param channelDescription the channelDescription to set
	 */
	public void setChannelDescription(String channelDescription) {
		this.channelDescription = channelDescription;
	}
	
}
