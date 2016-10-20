package com.example.xur.myapplication;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * Created by xur on 16-10-18.
 */

public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent){
        AlertDialog.Builder dialogBuider=new AlertDialog.Builder(context);
        dialogBuider.setTitle("Warning");
        dialogBuider.setMessage("You are forced to be offline.Please try to login again.");
        dialogBuider.setCancelable(false);
        dialogBuider.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCollector.finishAll();//销毁所有活动
                Intent intent=new Intent(context,SecondActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);//重新启动SecondActivity
            }
        });
        AlertDialog alertDialog=dialogBuider.create();
        //需要设置AlertDialog的类型，保证在广播接收器中可以正常弹出
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
