package com.example.jhodgson_acounter;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

//author Java Experience; https://www.youtube.com/watch?v=tNoeFkXCZ6w
//The list functionality was adapted from Java Experience
public class MainActivity extends Activity {
	
	public final static String EXTRA_MESSAGE = "com.example.jhodgson-acounter.MESSAGE";
	private ArrayList<counter> counters = new ArrayList<counter>();
	private ArrayAdapter<counter> adapter;
	private ListView countersListView;
	private Button button;
	private EditText counterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        countersListView = (ListView) findViewById(R.id.listView1);
        button = (Button) findViewById(R.id.new_counter);
        counterName = (EditText) findViewById(R.id.counter_Name);
        
        //Setting up the counters list
        adapter = new ArrayAdapter<counter>(getApplicationContext(), android.R.layout.simple_list_item_1, counters);
        countersListView.setAdapter(adapter);
        
        //"New" button functionality
        button.setOnClickListener(new OnClickListener() {
        	
        	//On Click functionality
        	@Override
        	public void onClick(View arg0){
        		counters.add(new counter(counterName.getText().toString()));
        		counterName.setText(""); //Clear the text after use
        		adapter.notifyDataSetChanged();
        	}
        }); 
        
        //List functionality
        countersListView.setOnItemClickListener(new OnItemClickListener() {
        	
        	@Override
        	public void onItemClick(AdapterView<?> parent, final View view, int position, long id){
        		
        		setContentView(R.layout.counter);
        		TextView counterName = (TextView) findViewById(R.id.counter_name);
        		counterName.setText(counters.get(position).toString());
        	}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
