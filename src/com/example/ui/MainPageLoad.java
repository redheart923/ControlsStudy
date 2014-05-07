package com.example.ui;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.customeradapter.R;


public class MainPageLoad extends FragmentActivity {
    
    private static final String TAG = "GridViewCustomerAdapter";
      
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate MyCustomAdapter");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);  
        getFragmentManager().beginTransaction().
                replace(R.id.maincontent, new RadioButton_fragment()).commit();
       
       
    }
    


}
