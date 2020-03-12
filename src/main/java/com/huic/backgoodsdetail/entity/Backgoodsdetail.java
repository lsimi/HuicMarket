package com.huic.backgoodsdetail.entity;

import java.math.BigDecimal;

import com.huic.backgoods.entity.Backgoods;
import com.huic.backpack.entity.BackPack;
import com.huic.backtaste.entity.BackTaste;

public class Backgoodsdetail {
	
    private Integer gdId;

    private Integer tasteId;

    private Integer packId;

    private Integer stock;

    private BigDecimal gdOldprice;

    private BigDecimal gdPrice;

    private Integer gId;

    private String gdUnit;

    private BackPack backpack;

    private BackTaste backtaste;
    
    
    public Integer getGdId() {
        return gdId;
    }

    public void setGdId(Integer gdId) {
        this.gdId = gdId;
    }

    public Integer getTasteId() {
        return tasteId;
    }

    public void setTasteId(Integer tasteId) {
        this.tasteId = tasteId;
    }

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getGdOldprice() {
        return gdOldprice;
    }

    public void setGdOldprice(BigDecimal gdOldprice) {
        this.gdOldprice = gdOldprice;
    }

    public BigDecimal getGdPrice() {
        return gdPrice;
    }

    public void setGdPrice(BigDecimal gdPrice) {
        this.gdPrice = gdPrice;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getGdUnit() {
        return gdUnit;
    }

    public void setGdUnit(String gdUnit) {
        this.gdUnit = gdUnit == null ? null : gdUnit.trim();
    }

	public BackPack getBackpack() {
		return backpack;
	}

	public void setBackpack(BackPack backpack) {
		this.backpack = backpack;
	}

	public BackTaste getBacktaste() {
		return backtaste;
	}

	public void setBacktaste(BackTaste backtaste) {
		this.backtaste = backtaste;
	}

	@Override
	public String toString() {
		return "Backgoodsdetail [gdId=" + gdId + ", tasteId=" + tasteId + ", packId=" + packId + ", stock=" + stock
				+ ", gdOldprice=" + gdOldprice + ", gdPrice=" + gdPrice + ", gId=" + gId + ", gdUnit=" + gdUnit
				+ ", backpack=" + backpack + ", backtaste=" + backtaste + "]";
	}
    
    

    
}