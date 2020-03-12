package com.huic.backcategory.entity;

public class Backcategory {
    private Integer cateId;

    private String cateName;

    private Integer cparentId;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName == null ? null : cateName.trim();
    }

    public Integer getCparentId() {
        return cparentId;
    }

    public void setCparentId(Integer cparentId) {
        this.cparentId = cparentId;
    }

	@Override
	public String toString() {
		return "Backcategory [cateId=" + cateId + ", cateName=" + cateName + ", cparentId=" + cparentId + "]";
	}
    
}