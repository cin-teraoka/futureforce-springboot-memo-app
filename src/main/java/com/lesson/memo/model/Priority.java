package com.lesson.memo.model;

public enum Priority {
	HIGH("高"),
	MEDIUM("中"),
	LOW("低");
	
	public final String displayName;
	
	Priority(String displayName){
		this.displayName = displayName;
	}
	
	
}
