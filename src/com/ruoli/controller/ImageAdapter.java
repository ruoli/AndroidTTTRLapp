//package com.ruoli.controller;
//
//import android.content.Context;
//import android.database.DataSetObserver;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.*;
//import com.ruoli.main.GameActivity;
//import com.ruoli.main.R;
//
///**
// * Created with IntelliJ IDEA.
// * User: apple
// * Date: 09/02/2013
// * Time: 22:46
// * To change this template use File | Settings | File Templates.
// */
//public class ImageAdapter extends BaseAdapter {
//    private Context myContext;
//    private Integer[] pigFood = {
//            R.drawable.bean, R.drawable.cheese, R.drawable.bean,
//            R.drawable.bean, R.drawable.cheese, R.drawable.bean,
//            R.drawable.bean, R.drawable.cheese, R.drawable.bean
//    };
//
//    public ImageAdapter(Context context) {
//        myContext = context;
//    }
//
//    @Override
//    public int getCount() {
//        return pigFood.length;
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup viewGroup) {
//        ImageView imageView;
//        if(convertView == null){
//            imageView = new ImageView(myContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//            imageView.setPadding(8,8,8,8);
//        }  else {
//            imageView = (ImageView) convertView;
//        }
//        imageView.setImageResource(pigFood[position]);
//        return imageView;
//    }
//
//}