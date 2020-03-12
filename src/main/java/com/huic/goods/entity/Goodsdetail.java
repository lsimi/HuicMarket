package com.huic.goods.entity;

import java.math.BigDecimal;
import java.util.List;

public class Goodsdetail {
    private Integer gdId;

	private Integer tasteId;

	private Integer packId;

	private Integer stock;

	private BigDecimal gdOldprice;

	private BigDecimal gdPrice;

	private Integer gId;

	private String gdUnit;
	
	//关联口味，
	private Taste taste;
	
	//关联包装表
	private Pack pack;
	
	//关联商品表
	private Goods goods;
	
	
	public Taste getTaste() {
		return taste;
	}

	public void setTaste(Taste taste) {
		this.taste = taste;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

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

	@Override
	public String toString() {
		return "Goodsdetail [gdId=" + gdId + ", tasteId=" + tasteId + ", packId=" + packId + ", stock=" + stock
				+ ", gdOldprice=" + gdOldprice + ", gdPrice=" + gdPrice + ", gId=" + gId + ", gdUnit=" + gdUnit + "]";
	}
	
	
	}