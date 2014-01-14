package com.example.jhodgson_acounter;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	private customeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
             
        //----------------------------------------------------------------------------------------------------------------------
        //"New" button functionality
        Button newButton = (Button) findViewById(R.id.new_counter);
        newButton.setOnClickListener(new OnClickListener() {
        	
        	@Override
        	public void onClick(View arg0){
        		
        		EditText counterName = (EditText) findViewById(R.id.counter_Name);
        		String name = counterName.getText().toString();
        		
        		//Make sure name is not empty
        		if(!name.isEmpty() && name != null){
        			counter.addNewCounter(name);
        			counterName.setText(""); //Clear the text after use
        			adapter.notifyDataSetChanged();
        		}
        	}
        }); 
        
        //----------------------------------------------------------------------------------------------------------------------
        //Spinner functionality (Sort Options)
        
        Spinner spinner = (Spinner) findViewById(R.id.sort_spinner);
        ArrayAdapter<CharSequence> sortAdapter = ArrayAdapter.createFromResource(this, R.array.sort_array, android.R.layout.simple_spinner_item);
        
        sortAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(sortAdapter);
        
        //----------------------------------------------------------------------------------------------------------------------
        //author Java Experience; https://www.youtube.com/watch?v=tNoeFkXCZ6w
        //The list functionality was adapted from Java Experience
        //----------------------------------------------------------------------------------------------------------------------
        //List functionality
        
        ListView countersListView = (ListView) findViewById(R.id.listView1);
        
        //Setting up the counters list
        adapter = new customeAdapter(getApplicationContext(), R.layout.list, counter.getArray());
        countersListView.setAdapter(adapter);
        
        countersListView.setOnItemClickListener(new OnItemClickListener() {
        	
        	@Override
        	public void onItemClick(AdapterView<?> parent, final View view, int position, long id){
        		
        		Intent intent = new Intent(MainActivity.this, CounterActivity.class);
        		intent.putExtra("Index", position);
        		startActivity(intent);
        	}
		});
        //---------------------------------------------------------------------------------------------------------------------- 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
