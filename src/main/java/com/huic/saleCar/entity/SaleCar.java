package com.huic.saleCar.entity;

import com.huic.goods.entity.Goodsdetail;

public class SaleCar {
    private Integer carId;

    private Integer userId;

    private Integer gdId;

    private Integer salNum;
    
    //关联商品详细信息表
    private Goodsdetail goodsdetail;
    
    

    public Goodsdetail getGoodsdetail() {
		return goodsdetail;
	}

	public void setGoodsdetail(Goodsdetail goodsdetail) {
		this.goodsdetail = goodsdetail;
	}

	public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGdId() {
        return gdId;
    }

    public void setGdId(Integer gdId) {
        this.gdId = gdId;
    }

    public Integer getSalNum() {
        return salNum;
    }

    public void setSalNum(Integer salNum) {
        this.salNum = salNum;
    }

	@Override
	public String toString() {
		return "SaleCar [carId=" + carId + ", userId=" + userId + ", gdId=" + gdId + ", salNum=" + salNum
				+ ", goodsdetail=" + goodsdetail + "]";
	}
    
    
}