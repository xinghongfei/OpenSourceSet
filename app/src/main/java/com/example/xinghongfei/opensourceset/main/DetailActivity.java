package com.example.xinghongfei.opensourceset.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.xinghongfei.opensourceset.R;
import com.example.xinghongfei.opensourceset.bean.InfoBean;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by xinghongfei on 16/7/23.
 */
public class DetailActivity extends Activity {


    public  static final  String INFO=DetailActivity.class.getName();
    @InjectView(R.id.title_detail)
    TextView titleDetail;
    @InjectView(R.id.github_addrss)
    TextView githubAddrss;
    @InjectView(R.id.desctrib_detail)
    TextView desctribDetail;
    @InjectView(R.id.recommen_detail)
    TextView recommenDetail;

    private String name="";
    private String github="";
    private String describ="";
    private String index="";



    public static void show(Context context,Intent intent) {

        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        ButterKnife.inject(this);

        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra(DetailActivity.INFO);
        InfoBean infoBean= (InfoBean) bundle.getParcelable(DetailActivity.INFO);

        name=infoBean.getName();
        github=infoBean.getAddress();
        describ=infoBean.getDescribe();
        index=infoBean.getRecommentIndex();

        titleDetail.setText(name);
        githubAddrss.setText(github);
        desctribDetail.setText(describ);
        recommenDetail.setText(index);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);


    }
}
