package com.huic.goods.entity;

public class Pack {
    private Integer packId;

    private String packVal;

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    public String getPackVal() {
        return packVal;
    }

    public void setPackVal(String packVal) {
        this.packVal = packVal == null ? null : packVal.trim();
    }

	@Override
	public String toString() {
		return "Pack [packId=" + packId + ", packVal=" + packVal + "]";
	}
    
}