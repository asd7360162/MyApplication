package com.example.xur.myapplication;

/**
 * Created by xur on 16-9-4.
 */

public class Msg {
    //申明一个名字叫Msg的类，它是公共的，在其他的类中可以使用。
// 括号中的内容是这个类的定义，由属性和方法构成。
    public static final int TYPE_RECEIVED=0;
    //定义一个公共静态常量(TYPE_RECEIVED)并赋值0.
    //(java需要保证你的程序只能给TYPE_RECEIVED赋一次值,所以只能在静态的部分来做赋值操作)
    public static final int TYPE_SENT=1;
    //定义一个公共静态常量(TYPE_SENT)并赋值1.
    private String content;
    //在一个类中定义了一个字符串类型的私有变量content
    private int type;
    //在一个类中定义了一个整数类型的私有变量type
    public Msg(String content,int type){
        this.content=content;
        this.type=type;
        //定义了一个全局变量，叫做Msg。这个全局变量还是Variant（变体）类型的.
        // 变体类型，就是变量的类型根据它接收的数据而变化.赋值是字符串,那么变量就是字符串类型的
        //这个是构造函数，this.content=content;this.type=type是初始化String content;int type
    }
    public String getContent(){
        return content;
    }
    public int getType(){
        return type;
    }
}
