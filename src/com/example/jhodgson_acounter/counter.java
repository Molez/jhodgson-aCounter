package com.example.jhodgson_acounter;

public class counter {
	private String name;
	private int count;
	
	public counter(){
		this.name = "No name";
		this.count = 0;
	}
	
	public counter(String users_name){
		this.name = users_name;
		this.count = 0;
	}

	@Override
	public String toString(){
		return this.name;
	}
	
	public void incrementCounter(){
		count++;
	}
}
