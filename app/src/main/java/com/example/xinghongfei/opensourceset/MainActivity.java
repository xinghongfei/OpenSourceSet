package com.example.xinghongfei.opensourceset;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;

import com.example.xinghongfei.opensourceset.main.AnimFragment;
import com.example.xinghongfei.opensourceset.main.BottomView;
import com.example.xinghongfei.opensourceset.main.OtherFragment;
import com.example.xinghongfei.opensourceset.main.ToolFragment;
import com.example.xinghongfei.opensourceset.main.ViewFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.mainactivity_viewpager)
    ViewPager mainactivityViewpager;
    @InjectView(R.id.mainactivity_view)
    BottomView mainactivityView;
    @InjectView(R.id.mainactivity_animation)
    BottomView mainactivityAnimation;
    @InjectView(R.id.mainactivity_tool)
    BottomView mainactivityTool;
    @InjectView(R.id.mainactivity_other)
    BottomView mainactivityOther;

    List<BottomView> bottomViews = new ArrayList<BottomView>();

    List<Fragment> fragmentList = new ArrayList<Fragment>();

    ViewFragment viewFragment;
    AnimFragment animFragment;
    ToolFragment toolFragment;
    OtherFragment otherFragment;

    FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setMyPictureInActionBar();

        initial();


    }

    private void initial() {
        mainactivityView.setSomethingAlpha(1.0f);

        mainactivityAnimation.setOnClickListener(this);
        mainactivityOther.setOnClickListener(this);
        mainactivityTool.setOnClickListener(this);
        mainactivityView.setOnClickListener(this);


        bottomViews.add(mainactivityView);
        bottomViews.add(mainactivityAnimation);
        bottomViews.add(mainactivityTool);
        bottomViews.add(mainactivityOther);

        viewFragment = new ViewFragment();
        animFragment = new AnimFragment();
        toolFragment = new ToolFragment();
        otherFragment = new OtherFragment();

        fragmentList.add(viewFragment);
        fragmentList.add(animFragment);
        fragmentList.add(toolFragment);
        fragmentList.add(otherFragment);

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return (Fragment) fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };

        mainactivityViewpager.setAdapter(fragmentPagerAdapter);


        setLisenerToViewPager();

    }

    private void setLisenerToViewPager() {
        mainactivityViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    mainactivityView.setSomethingAlpha(1 - positionOffset);
                    mainactivityAnimation.setSomethingAlpha(positionOffset);

                } else if (position == 1) {


                    mainactivityAnimation.setSomethingAlpha(1 - positionOffset);
                    mainactivityTool.setSomethingAlpha(positionOffset);
                } else if (position == 2) {


                    mainactivityTool.setSomethingAlpha(1 - positionOffset);
                    mainactivityOther.setSomethingAlpha(positionOffset);
                }


            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        reset();
        switch (id) {
            case R.id.mainactivity_view:
                bottomViews.get(0).setSomethingAlpha(1.0f);
                mainactivityViewpager.setCurrentItem(0, false);

                break;
            case R.id.mainactivity_animation:
                bottomViews.get(1).setSomethingAlpha(1.0f);
                mainactivityViewpager.setCurrentItem(1, false);

                break;
            case R.id.mainactivity_tool:
                bottomViews.get(2).setSomethingAlpha(1.0f);
                mainactivityViewpager.setCurrentItem(2, false);

                break;
            case R.id.mainactivity_other:
                bottomViews.get(3).setSomethingAlpha(1.0f);
                mainactivityViewpager.setCurrentItem(3, false);

                break;


        }


    }

    private void reset() {
        for (int i = 0; i < bottomViews.size(); i++) {
            ((BottomView) bottomViews.get(i)).setSomethingAlpha(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }



    public void setMyPictureInActionBar() {

        ViewConfiguration configuration = ViewConfiguration.get(this);

        try {
            Field menuKey = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            menuKey.setAccessible(true);
            menuKey.setBoolean(configuration, false);


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
