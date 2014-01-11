package com.example.jhodgson_acounter;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ArrayList<String> strings = new ArrayList<String>();
	private ArrayAdapter<String> adapter;
	private ListView countersListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countersListView = (ListView) findViewById(R.id.listView1);
        
        //Setting up the counters list
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, strings);
        countersListView.setAdapter(adapter);
        
        strings.add("test");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    /** Called when the user clicks the New button */
    public void newCounter(View view) {
        // Do something in response to button
    }
    
}
