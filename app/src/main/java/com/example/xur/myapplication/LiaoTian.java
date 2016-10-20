package com.example.xur.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xur on 16-9-4.
 */
public class LiaoTian extends Activity {
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private List<Msg> msgList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third_layout);
        initMsgs();
        //初始化几条数据用于在ListView中显示
        adapter=new MsgAdapter(LiaoTian.this,R.layout.msg_item,msgList);
        inputText=(EditText)findViewById(R.id.input_text);
        send=(Button)findViewById(R.id.send);
        msgListView=(ListView)findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString();
                //获取EditText中的内容
                if(!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    //如果内容不为空，则创建出一个新的Msg对象，并把它添加到msgList列表中
                    adapter.notifyDataSetChanged();
                    //调用了适配器notifyDataSetChanged()方法，用于通知列表的的数据发生变化，这样新增的一条消息才能在ListView中显示
                    msgListView.setSelection(msgList.size());
                    //调用ListView的setSelection()方法，将显示的数据定位到最后一行，以保证一定可以看到最后一条发出的信息
                    inputText.setText("");
                    //调用EditText的setText()方法将输入的内容清空
                }
            }
        });
    }
    private void initMsgs() {
        Msg msg1=new Msg("你好！",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
    }
}
