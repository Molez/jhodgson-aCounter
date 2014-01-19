package com.example.jhodgson_acounter;

public class StatsModel {

	private String name;
	private Integer count;

	public StatsModel(String name) {
		this.name = name;
		this.count = 0;
	}

	public void increment() {
		this.count++;
	}

	public String getCountString() {
		return Integer.toString(this.count);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
