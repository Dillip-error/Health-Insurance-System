package com.ait.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PLAN_TABLE1")
@SQLDelete(sql = "UPDATE PLAN_TABLE1 set DELETE_STATUS='ACTIVE' where PLAN_ID=?"  )
@Entity
public class PlanEntity {

	@Id
	@Column(name = "PLAN_ID")
	@SequenceGenerator(name = "SEQUENCE_ID", sequenceName = "REG_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "SEQUENCE_ID", strategy = GenerationType.SEQUENCE)
	private Integer planId;
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_DESCRIPTION")
	private String planDescription;
	@Column(name = "START_DATE")
	private String startDate;
	@Column(name = "END_DATE")
	private String endDate;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE",updatable = false)
	private Date createdDate;
	@UpdateTimestamp  
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE",insertable = false)
	private Date updatedDate;
	@Column(name = "DELETE_STATUS")
	private String deleteStatus;
	
}
