package com.example.xinghongfei.opensourceset.view.button;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.xinghongfei.opensourceset.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by xinghongfei on 16/7/21.
 */
public class ButtonActivity extends AppCompatActivity {


    ArrayList<Fragment> fragments = new ArrayList<>();

    ArrayList<String> tabs=new ArrayList<>();

    Button1Fragment buttonFragment;
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

        buttonFragment = new Button1Fragment();
        fragments.add(buttonFragment);
        tabs.add("Button1");


        button2Fragment = new Button2Fragment();
        fragments.add(button2Fragment);
        tabs.add("Button2");

        acToolbarToolbar.setTitle("Button");
        acToolbarToolbar.setTitleTextColor(getResources().getColor(R.color.white));

        acToolbarToolbar.setNavigationIcon(R.drawable.goback);
        acToolbarToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });




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

            @Override
            public CharSequence getPageTitle(int position) {
                return tabs.get(position);
            }
        };


        viewButtonViewpager.setAdapter(fragmentPagerAdapter);


        viewButtonTablayou.setupWithViewPager(viewButtonViewpager);


    }
}
