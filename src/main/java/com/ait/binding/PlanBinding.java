package com.ait.binding;

import java.util.Date;

import lombok.Data;
@Data
public class PlanBinding {

	private Integer planId;
	private String planName;
	private String planDescription;
	private String startDate;
	private String endDate;
	private Date createdDate;
	private Date updatedDate;
	private String deleteStatus;
	
}
