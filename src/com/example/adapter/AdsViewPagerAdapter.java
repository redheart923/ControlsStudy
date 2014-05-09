
package com.example.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AdsViewPagerAdapter extends PagerAdapter {

    private List<View> viewsList;

    public AdsViewPagerAdapter(List<View> mView) {
        // TODO Auto-generated constructor stub
        this.viewsList = mView;
    }

    /**
     * ViewPage页面个数
     */
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if (viewsList != null) {
            return viewsList.size();
        }

        return 0;
    }

    /**
     * 删除指定位置的页面
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        container.removeView(viewsList.get(position));
        super.destroyItem(container, position, object);

    }

    /**
     * 判断ViewPage对象
     */
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return (arg0 == arg1);
    }

    /**
     * 实例化页面
     */
    @Override
    public Object instantiateItem(View container, int position) {
        // TODO Auto-generated method stub
        ((ViewPager) container).addView(viewsList.get(position), 0);
        return viewsList.get(position);
    }

}
