package com.example.customeradapter;

import android.os.Bundle;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.adapter.MyCustomAdapter;


public class GridViewCustomerAdapter extends FragmentActivity {
    
    private static final String TAG = "GridViewCustomerAdapter";
    /**
     * 导航栏上一页按钮
     */
    private ImageView mImgBtnPrev = null;
    /**
     * 导航栏下一页按钮
     */
    private ImageView mImgBtnNext = null;
    /**
     * 滑动列表 
     */
    private HorizontalScrollView mScrollView;   
    /**
     * 菜单列表
     */
    private GridView mMenuGridView = null;
    
    /*
     * 1.Defined the content for data set  
     */
    private static int[] image = {
            R.drawable.fragment_homepage_navi_0, R.drawable.fragment_homepage_navi_1,R.drawable.fragment_homepage_navi_2,
            R.drawable.fragment_homepage_navi_3,R.drawable.fragment_homepage_navi_4, R.drawable.fragment_homepage_navi_5,
            R.drawable.fragment_homepage_navi_6, R.drawable.fragment_homepage_navi_7, R.drawable.fragment_homepage_navi_8
    };
    
    private static int[] text = {
            R.string.hpage_navis_0,R.string.hpage_navis_1,R.string.hpage_navis_2,
            R.string.hpage_navis_3,R.string.hpage_navis_4,R.string.hpage_navis_5,
            R.string.hpage_navis_6,R.string.hpage_navis_7,R.string.hpage_navis_8
            
    };
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate MyCustomAdapter");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_adapter);     
        
        mScrollView = (HorizontalScrollView)findViewById(R.id.HorScrollView);
        mImgBtnPrev = (ImageView) findViewById(R.id.preBtn);
        mImgBtnNext = (ImageView) findViewById(R.id.nextBtn);
        
        mMenuGridView = (GridView)findViewById(R.id.main_page_gridview);
        MyCustomAdapter adapter = new MyCustomAdapter(this,image,text);
        mMenuGridView.setAdapter(adapter);
        
        //设置GridView的总宽度和每个Item的宽度
        LayoutParams gridviewParams = (LinearLayout.LayoutParams) mMenuGridView
                .getLayoutParams();      
        int ColumnWidth = 180;
        gridviewParams.width = ColumnWidth * image.length; //计算GridView宽度
        mMenuGridView.setNumColumns(image.length);         //设置GridView列数
        mMenuGridView.setColumnWidth(ColumnWidth);         //设置GridView每列的宽度
        mMenuGridView.setStretchMode(GridView.NO_STRETCH);
        mMenuGridView.setLayoutParams(gridviewParams);
        
        mImgBtnPrev.setAlpha(0);
        mImgBtnNext.setAlpha(0);
     
        /**
         * Monitor GridView
         */
        mMenuGridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplication(),"你按下了"+text[position],Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0 :
                        break;
                        
                    case 1 :
                        break;


                }

            }

        });
        
        /**
         * ScrollView滑动事件
         */
        mScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                Log.i(TAG, "X " + event.getX());
                mImgBtnPrev.setAlpha(255);
                mImgBtnNext.setAlpha(255);

                return false;
            }
        });
       
    }
    


}
