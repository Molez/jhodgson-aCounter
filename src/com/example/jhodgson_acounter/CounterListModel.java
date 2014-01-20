package com.example.jhodgson_acounter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.content.Context;

public class CounterListModel implements CustomListModel<CounterModel> {

	private ArrayList<CounterModel> list;

	public CounterListModel() {
		super();
		list = new ArrayList<CounterModel>();
	}

	public ArrayList<CounterModel> getList() {
		return list;
	}

	public void setList(ArrayList<CounterModel> list) {
		this.list = list;
	}
	
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
