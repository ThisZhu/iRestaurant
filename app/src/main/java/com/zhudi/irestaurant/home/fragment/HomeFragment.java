package com.zhudi.irestaurant.home.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.home.view.IhomeView;

/**
 * Created by zhudi on 2017/4/3.
 */
public class HomeFragment extends Fragment implements IhomeView{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }
    @Override
    public void RestaurantTitle() {

    }

    @Override
    public void HotRecommend() {

    }

    @Override
    public void Announcement() {

    }

    @Override
    public void Operation() {

    }

    @Override
    public void AboutRestaurant() {

    }

    @Override
    public void GuessYouLike() {

    }
}
