package com.huic.order.entity;

import java.math.BigDecimal;

public class OrderDetail {
    private Integer odeId;

    private Integer orId;

    private Integer gNum;
    
    private Double totalprice;

    private Integer gdId;
    
    

    public Integer getOdeId() {
        return odeId;
    }

    public void setOdeId(Integer odeId) {
        this.odeId = odeId;
    }

    public Integer getOrId() {
        return orId;
    }

    public void setOrId(Integer orId) {
        this.orId = orId;
    }

  

    public Integer getgNum() {
		return gNum;
	}

	public void setgNum(Integer gNum) {
		this.gNum = gNum;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Integer getGdId() {
        return gdId;
    }

    public void setGdId(Integer gdId) {
        this.gdId = gdId;
    }

	@Override
	public String toString() {
		return "OrderDetail [odeId=" + odeId + ", orId=" + orId + ", gNum=" + gNum + ", totalprice=" + totalprice
				+ ", gdId=" + gdId + "]";
	}
    
    
}