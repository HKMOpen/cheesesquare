package com.support.android.designlibdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by hesk on 2016/9/18.
 */

public class CHomedFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sub_fragment, container, false);
    }

    private void loadBackdrop(View view) {
        final ImageView imageView = (ImageView) view.findViewById(R.id.backdrop);
        Glide.with(this).load(Cheeses.getRandomCheeseDrawable()).centerCrop().into(imageView);
    }

    protected AppCompatActivity getSupportActivity() {
        return (AppCompatActivity) getActivity();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadBackdrop(view);
        final Toolbar toolbar = (Toolbar) view.findViewById(R.id.the_toolbar);
        getSupportActivity().setSupportActionBar(toolbar);
        getSupportActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initActivityTransitions();
    }

    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            //  getWindow().setEnterTransition(transition);
            //  getWindow().setReturnTransition(transition);
        }
    }
}
