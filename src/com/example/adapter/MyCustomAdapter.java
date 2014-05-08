package com.example.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customeradapter.R;

import java.util.List;

public class MyCustomAdapter extends BaseAdapter {
    
    private static final String TAG = "MyCustomAdapter";
    private static final Boolean DEBUG = false;
    private LayoutInflater mInflater;
    
    private int[] mPicus;
    private int[] mTxt;
    

    /** 2.1 ViewHolder中缓存了View中显示数据的子控件，这样不用
     * 每次刷新ListView或GridView都调用findViewById(...)方法，
     * 大大提高了控件的响应速度
     */    
    static class ViewHolder {
        ImageView TestImage;
        TextView  ImageName;
    }

    /**
     *  2.2构造函数，从给定的context中获取Activity的布局
     */
    public MyCustomAdapter(Context context,int[] mPic,int[] mText)
    {
        Log.v(TAG, "MyCustomAdapter Constructors");
        this.mInflater = LayoutInflater.from(context);
        this.mPicus = mPic;
        this.mTxt = mText;
        
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        Log.v(TAG, "in getCount()");
        return mPicus.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        Log.v(TAG, "in getItem() for position " + position);
        return mPicus[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        Log.v(TAG, "in getItemId() for position " + position);
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder;
        
        if(DEBUG)
            Log.v(TAG, "in getView for position " + position + 
                    ", convertView is " +
                    ((convertView == null)?"null":"being recycled"));

        if(convertView == null){
            // 找到GridView的布局文件Ĳ����ļ�
            convertView = mInflater.inflate(R.layout.grid_item, null);
            holder = new ViewHolder();
            holder.TestImage = (ImageView) convertView.findViewById(R.id.image);
            holder.ImageName = (TextView) convertView.findViewById(R.id.text);
            // 给View设置一个Tag，方便下次取的时候通过Tag去查，而不是View的视图结构去查，提高查询效率
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        //设置ImageView/TextView的内容������
        holder.ImageName.setText(mTxt[position]); 
        holder.TestImage.setImageResource(mPicus[position]);
        return convertView;
    }

}
