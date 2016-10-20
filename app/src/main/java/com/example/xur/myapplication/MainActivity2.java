package com.example.xur.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by xur on 16-9-29.
 */

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        Button button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
    }
    @Override


    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button3:
                //创建碎片
                AnotherRightFragment fragment=new AnotherRightFragment();
                //获得布局管理器
                FragmentManager fragmentManager=getFragmentManager();
                //获得碎片的事物
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                //替换id为R.id.right_layout里面的内容
                transaction.replace(R.id.right_layout,fragment);
                //将事务添加到返回栈
                transaction.addToBackStack(null);
                //提交事务
                transaction.commit();
                break;
            default:
                break;
        }
    }
}
