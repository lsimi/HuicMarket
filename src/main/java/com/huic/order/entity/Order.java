package com.huic.order.entity;

import java.util.Date;

public class Order {
    private Integer orId;

    private Double orSumprice;
    

    private String userMessage;

    private Date createtime;

    private Date delivertime;

    private Date confirmtime;

    private Integer addrId;

    private Integer orStatus;

    private Integer expressId;

    private Integer userId;
   
    private Integer payStatus;
    

    
    public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getOrId() {
        return orId;
    }

    public void setOrId(Integer orId) {
        this.orId = orId;
    }


    public Double getOrSumprice() {
		return orSumprice;
	}

	public void setOrSumprice(Double orSumprice) {
		this.orSumprice = orSumprice;
	}

	public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage == null ? null : userMessage.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getDelivertime() {
        return delivertime;
    }

    public void setDelivertime(Date delivertime) {
        this.delivertime = delivertime;
    }

    public Date getConfirmtime() {
        return confirmtime;
    }

    public void setConfirmtime(Date confirmtime) {
        this.confirmtime = confirmtime;
    }

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public Integer getOrStatus() {
        return orStatus;
    }

    public void setOrStatus(Integer orStatus) {
        this.orStatus = orStatus;
    }

    public Integer getExpressId() {
        return expressId;
    }

    public void setExpressId(Integer expressId) {
        this.expressId = expressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

	@Override
	public String toString() {
		return "Order [orId=" + orId + ", orSumprice=" + orSumprice + ", userMessage=" + userMessage + ", createtime="
				+ createtime + ", delivertime=" + delivertime + ", confirmtime=" + confirmtime + ", addrId=" + addrId
				+ ", orStatus=" + orStatus + ", expressId=" + expressId + ", userId=" + userId + ", payStatus="
				+ payStatus + "]";
	}
    
    
}