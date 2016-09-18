package com.support.android.designlibdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by hesk on 2016/9/18.
 */

public class ViewPagerTest extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vp_test);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // collapsingToolbar.setTitle("test");
        // loadBackdrop();
        // toolbar.addView(new View(getApplicationContext()));
        // toolbar.setBackgroundResource(R.drawable.ic_forum);
        viewpagersetup();
    }

    private class ScreenAdapter extends FragmentStatePagerAdapter {
        public ScreenAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return page1;
            } else if (position == 1) {
                return page2;
            } else {
                return page1;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    /* private void loadBackdrop() {
         final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
         Glide.with(this).load(Cheeses.getRandomCheeseDrawable()).centerCrop().into(imageView);
     }*/

    private ViewPager pager;
    private ScreenAdapter pageradapter;
    private CheeseListFragment page1;
    private CheeseListFragment page2;

    private void viewpagersetup() {
        page1 = new CheeseListFragment();
        page2 = new CheeseListFragment();
        pageradapter = new ScreenAdapter(getSupportFragmentManager());
        pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(pageradapter);
    }
}
