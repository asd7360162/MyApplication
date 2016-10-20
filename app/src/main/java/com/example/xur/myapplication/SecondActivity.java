package com.example.xur.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by xur on 16-9-3.
 */
public class SecondActivity extends Activity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
                setContentView(R.layout.login);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit=(EditText)findViewById(R.id.account);
        passwordEdit=(EditText)findViewById(R.id.password);
        rememberPass=(CheckBox)findViewById(R.id.remember_pass);
        //引入second_layout布局
        Button button5=(Button)findViewById(R.id.button5);
        boolean isRemenber=preferences.getBoolean("记住密码",false);
        if (isRemenber){
            //将账号和密码都设置到文本框中
            String account=preferences.getString("account","");
            String password=preferences.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                //如果账号是admin且密码是111111.就认为登录成功
                if (account.equals("admin") && password.equals("111111")) {
                    editor=preferences.edit();
                    if(rememberPass.isChecked()){//检查复选框是否被选中
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.commit();
                    Intent intent = new Intent(SecondActivity.this, MainActivity4.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SecondActivity.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();

                }
            }
        });
        Button button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                //如果账号是admin且密码是111111.就认为登录成功
                if (account.equals("admin") && password.equals("111111")) {
                Intent intent=new Intent(SecondActivity.this,LiaoTian.class);
                startActivity(intent);
                } else {
                    Toast.makeText(SecondActivity.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

}
