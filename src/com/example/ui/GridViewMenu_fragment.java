package com.example.ui;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

import com.example.adapter.AdsViewPagerAdapter;
import com.example.adapter.MyCustomAdapter;
import com.example.customeradapter.R;
import java.util.ArrayList;
import java.util.List;

@SuppressLint("NewApi")
public class GridViewMenu_fragment extends Fragment {
    
    protected static final String TAG = "GridViewMenu_fragment";
    protected static Boolean DEBUG = false;
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
    
    private ViewPager mPager;//广告内容
    private List<View> mlistAds; //图片列表
       
    
    /*
     * 1.Defined the content for data set  
     */
    private static int[] adsImages = {
            R.drawable.activity_select_guide_ad10,
            R.drawable.activity_select_guide_ad11,
            R.drawable.activity_select_guide_ad12,        
    };
    
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
    
    /**
     * 初始化ViewPager
     */
//    private void InitViewPager() {
//        mPager = (ViewPager) this.getView().findViewById(R.id.viewpager);
//        mlistAds = new ArrayList<View>();
//        
//        for (int i = 0; i < adsImages.length; i++) {
//            ImageView iv = new ImageView(this.getActivity());
//            iv.setBackgroundResource(adsImages[i]);
//            mlistAds.add(iv);
//        }
//        
//        mPager.setAdapter(new AdsViewPagerAdapter(mlistAds));
//        mPager.setCurrentItem(0);
//        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
//    }
//    
    
    /**
     * 页卡切换监听
*/
    public class MyOnPageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
           
            switch (arg0) {
            case 0:
               
                break;
            case 1:
               
                break;
            case 2:
                
                break;
            }

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }

    public View FragmentFindViewById(int id) {
             return this.getView().findViewById(id);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
      mScrollView = (HorizontalScrollView)FragmentFindViewById(R.id.HorScrollView);
      mImgBtnPrev = (ImageView) FragmentFindViewById(R.id.preBtn);
      mImgBtnNext = (ImageView) FragmentFindViewById(R.id.nextBtn);
      
      mMenuGridView = (GridView)FragmentFindViewById(R.id.main_page_gridview);
      MyCustomAdapter adapter = new MyCustomAdapter(getActivity(),image,text);
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
      
      //InitViewPager();
      
      /**
       * Monitor GridView
       */
      mMenuGridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(getActivity(),"你按下了"+text[position],Toast.LENGTH_SHORT).show();

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
              if(DEBUG)
                  Log.i(TAG, "X " + event.getX());
              mImgBtnPrev.setAlpha(255);
              mImgBtnNext.setAlpha(255);

              return false;
          }

      });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.activity_customer_adapter, container, false);
    }
    
    

}
