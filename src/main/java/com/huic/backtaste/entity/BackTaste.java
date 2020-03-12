package com.huic.backtaste.entity;

public class BackTaste {
    private Integer tasteId;

    private String tasteVal;

    public Integer getTasteId() {
        return tasteId;
    }

    public void setTasteId(Integer tasteId) {
        this.tasteId = tasteId;
    }

    public String getTasteVal() {
        return tasteVal;
    }

    public void setTasteVal(String tasteVal) {
        this.tasteVal = tasteVal == null ? null : tasteVal.trim();
    }

	@Override
	public String toString() {
		return "BackTaste [tasteId=" + tasteId + ", tasteVal=" + tasteVal + "]";
	}
    
    
}