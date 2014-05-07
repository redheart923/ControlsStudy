package com.example.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.customeradapter.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewSimpleAdapter extends Activity {
    
    private GridView gridView;
    
    private int[] image = {
	        R.drawable.death_knight_large, R.drawable.draenei_large,
	        R.drawable.druid_large, R.drawable.dwarf_large, R.drawable.forsaken_large,
	        R.drawable.gnome_large, R.drawable.goblin_large, R.drawable.human_large
	    };
	private String[] imgText = {
	        "deakngt", "draenei", "druid", "dwarf", "forsaken", "gnome", "goblin", "human"
	    };
  
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_adapter);	    

		List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < image.length; i++) {
		        Map<String, Object> item = new HashMap<String, Object>();
		        item.put("image", image[i]);
		        item.put("text", imgText[i]);
		        items.add(item);
		}


		SimpleAdapter adapter = new SimpleAdapter(getApplication(), 
		        items, R.layout.grid_item, new String[]{"image", "text"},
		        new int[]{R.id.image, R.id.text});
		    
		gridView = (GridView)findViewById(R.id.main_page_gridview);
		gridView.setNumColumns(1);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener(){
			
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {            
		            Toast.makeText(getApplication(), "you are press "+imgText[position],    
		                Toast.LENGTH_SHORT).show();   
		        }
		              
		    });

	}
	
	
	
	
}
