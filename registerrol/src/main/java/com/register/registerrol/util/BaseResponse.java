package com.register.registerrol.util;

import java.io.Serializable;
import java.util.List;

import com.register.registerrol.entities.Agent;
import com.register.registerrol.entities.Roles;

public class BaseResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String status;
	private String reasonCode;
	private String reasonText;
	private T responseObject;
	private String totalRecords;
	private List<T> responseListObject;

	public BaseResponse() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getReasonText() {
		return reasonText;
	}

	public void setReasonText(String reasonText) {
		this.reasonText = reasonText;
	}

	public T getResponseObject() {
		return responseObject;
	}

	@SuppressWarnings("unchecked")
	public void setResponseObject(Roles roles) {
		this.responseObject = (T) roles;
	}

	public String getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(String totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<T> getResponseListObject() {
		return responseListObject;
	}

	public void setResponseListObject(List<T> responseListObject) {
		this.responseListObject = responseListObject;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(" Status : " + this.getStatus());
		buffer.append(" Reason Code : " + this.getReasonCode());
		buffer.append(" Reason Text : " + this.getReasonText());
		return buffer.toString();
	}

	public void setResponseObject(Agent agent) {
		this.responseObject = (T) agent;
		
	}

}
