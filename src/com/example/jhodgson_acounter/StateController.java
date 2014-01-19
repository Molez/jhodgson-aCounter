package com.example.jhodgson_acounter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.app.Activity;

public class StateController extends Activity{
	
	public static void saveState(File f){
		
		CounterListController listController = new CounterListController();
		
		//File f = new File(Environment.getExternalStorageDirectory()+"/tempStorage.bin");

        try {
            if(listController.getList() != null && listController.getList().size() >= 1){

                FileOutputStream fout = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(listController.getList());
                oos.flush();
                oos.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
            f.delete();
        }
		
	}
	 
	@SuppressWarnings("unchecked")
	public static void loadState(File f){
		
		CounterListController listController = new CounterListController();
		
		//File f = new File(Environment.getExternalStorageDirectory()+"/tempStorage.bin");
		
        if(f.exists()){ 
                try {
                        FileInputStream fin = new FileInputStream(f);
                        ObjectInputStream ois = new ObjectInputStream(fin);
                        listController.reloadCounters((ArrayList<CounterModel>) ois.readObject());
                        ois.close();
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }
		
	}
}
