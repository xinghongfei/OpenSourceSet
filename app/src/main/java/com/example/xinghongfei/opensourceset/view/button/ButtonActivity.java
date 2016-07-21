package com.example.xinghongfei.opensourceset.view.button;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.system.StructStatVfs;

import com.example.xinghongfei.opensourceset.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by xinghongfei on 16/7/21.
 */
public class ButtonActivity extends AppCompatActivity {


    ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    ButtonFragment buttonFragment;
    Button2Fragment button2Fragment;


    FragmentPagerAdapter fragmentPagerAdapter;
    @InjectView(R.id.ac_toolbar_toolbar)
    Toolbar acToolbarToolbar;
    @InjectView(R.id.view_button_tablayou)
    TabLayout viewButtonTablayou;
    @InjectView(R.id.view_button_viewpager)
    ViewPager viewButtonViewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_layout);
        ButterKnife.inject(this);

        initialFragmentAndTab();


        initial();

    }

    private void initialFragmentAndTab() {

        buttonFragment = new ButtonFragment();
        fragments.add(buttonFragment);


        button2Fragment =new Button2Fragment();
        fragments.add(button2Fragment);


        viewButtonTablayou.addTab(viewButtonTablayou.newTab().setText("tton1"));
        viewButtonTablayou.addTab(viewButtonTablayou.newTab().setText("Button2"));

    }

    private void initial() {


        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return (Fragment) fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };


        viewButtonViewpager.setAdapter(fragmentPagerAdapter);


        viewButtonTablayou.setupWithViewPager(viewButtonViewpager);
    }
}
