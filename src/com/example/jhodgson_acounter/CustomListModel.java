package com.example.jhodgson_acounter;

import java.util.ArrayList;

//A basic interface for custom list of objects
public interface CustomListModel<T> {

	public ArrayList<T> getList();

	public void setList(ArrayList<T> list);

}
