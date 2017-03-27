package com.xinglie.exam;

public enum ApplicationConfig {
	Version1("1"), Version2("2");
	
	String id;
	ApplicationConfig(String id){
		this.id= id;
	}
	
	public ApplicationConfig findById(String id){
		return ApplicationConfig.valueOf(id);
	}
}
