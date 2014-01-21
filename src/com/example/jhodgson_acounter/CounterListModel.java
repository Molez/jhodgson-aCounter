package com.example.jhodgson_acounter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.content.Context;

/*This class implements a list model for storing the Counter Models. Functionality is limited
as the controller should handle the majority of the manipulation of this list.*/

public class CounterListModel implements CustomListModel<CounterModel> {

	private ArrayList<CounterModel> list;
	
	//Contructs a new empty list
	public CounterListModel() {
		super();
		list = new ArrayList<CounterModel>();
	}

	//Returns the list
	public ArrayList<CounterModel> getList() {
		return list;
	}
	
	//Sets the list to another list of counters
	public void setList(ArrayList<CounterModel> list) {
		this.list = list;
	}
	
	//Writes the list to disk
	public void save(Context context){
		FileOutputStream fos;
		try {
			fos = context.openFileOutput("state.bin", Context.MODE_PRIVATE);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(this.list);
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	//Loads the list from disk into the program
	@SuppressWarnings("unchecked")
	public void restore(Context context){
		FileInputStream fis;
		try {
			fis = context.openFileInput("state.bin");
			ObjectInputStream is = new ObjectInputStream(fis);
			list = (ArrayList<CounterModel>) is.readObject();
			is.close();	
		} catch(FileNotFoundException fnfe){
			return;
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
