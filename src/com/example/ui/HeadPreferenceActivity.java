package com.example.ui;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.widget.Button;

import com.example.customeradapter.R;

import java.util.List;


public class HeadPreferenceActivity extends PreferenceActivity{
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        if(hasHeaders()){
            showInfo("hasHeaders() is true.");
            Button button = new Button(this);
            button.setText("Some Action");
            setListFooter(button);
        }else{
            showInfo("hasHeaders() is false."); 
        }
    }

    @Override
    public void onBuildHeaders(List<Header> target) {
        showInfo("onBuildHeaders() is called");
        loadHeadersFromResource(R.xml.preference_headers, target);
    }
    
    
    public static class Blood_Elf extends PreferenceFragment {
        public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            addPreferencesFromResource(R.xml.blood_elf);
        }

    }

    
    public static class Draenei extends PreferenceFragment {
        public void onCreate(Bundle icicle) {
            super.onCreate(icicle);
            addPreferencesFromResource(R.xml.draenei);
        }

    }
    
    
    private void showInfo(String s){
        Log.d("PRO " + getLocalClassName(),s);
    }
}
