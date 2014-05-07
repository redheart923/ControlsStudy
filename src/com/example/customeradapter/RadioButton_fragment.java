package com.example.customeradapter;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.fragment.FragmentFactory;
import com.example.fragment.GridViewMenu_fragment;
import com.example.fragment.HomepageFragment;

@SuppressLint("NewApi")
public class RadioButton_fragment extends Fragment {
    
    private FragmentManager fragmentManager;
    private RadioGroup radioGroup;
    
    
    /**
     * 绘制Fragment的视图，即加载layout布局文件
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub       
        return inflater.inflate(R.layout.radiobutton_fragment, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
      
        //Tab Fragment
        fragmentManager = getFragmentManager();
        radioGroup = (RadioGroup) this.getView().findViewById(R.id.rg_tab);
        //启动时选中第一个radiobutton，并启动对应的fragment
        RadioButton homeRadioButton = (RadioButton) radioGroup.getChildAt(0);
        homeRadioButton.setChecked(true);
        fragmentManager.beginTransaction().replace(R.id.content, new GridViewMenu_fragment()).commit();
        
        //监听RadioButton
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                Fragment fragment = FragmentFactory.getInstanceByIndex(checkedId);
                transaction.replace(R.id.content, fragment);
                transaction.commit();
            }
        });
        
    }

    

}
