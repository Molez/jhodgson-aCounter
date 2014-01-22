package com.example.jhodgson_acounter;

/*This class implements the stats model. A stats model is intended to 
be a bucket where a certain type of state is held. The name is the 
display name for that specific stat and the count is how many 
counts fall under that stat title. The report generator builds
these objects when it is parsing stats. A list view can then
display stats models, one per line. 
*/
public class StatsModel {

	private String name;
	private Integer count;

	public StatsModel(String name) {
		this.name = name;
		this.count = 0;
	}

	//Increment the stats model
	public void increment() {
		this.count++;
	}
	
	//Return the count as a string
	public String getCountString() {
		return Integer.toString(this.count);
	}

	@Override
	public String toString() {
		return this.name;
	}

}
