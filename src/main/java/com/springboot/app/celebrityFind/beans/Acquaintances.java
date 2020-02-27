package com.springboot.app.celebrityFind.beans;

public class Acquaintances {
	
	private long id;
	private long parentId;
	private long relatedId;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public long getRelatedId() {
		return relatedId;
	}

	public void setRelatedId(long relatedId) {
		this.relatedId = relatedId;
	}

	@Override
	public String toString() {
		return "Acquaintances [id=" + id + ", parentId=" + parentId + ", relatedId=" + relatedId + "]";
	}

	
}
