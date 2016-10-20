package com.example.xur.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xur on 16-9-30.
 */

public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView newsTitleListView;
    private List<News> newsList;
    private NewsAdapter adapter;
    private boolean isTwoPane;
    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        newsList=getNews();//初始化新闻数据
        adapter=new NewsAdapter(activity,R.layout.news_item,newsList);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        View view=inflater.inflate(R.layout.news_title_frag,container,false);
        newsTitleListView=(ListView)view.findViewById(R.id.news_title_list_view);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(this);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content_layout)!=null){
            isTwoPane=true;//可以找到news_content_layout布局时，为双页模式
        }else{
            isTwoPane=false;//不可以找到news_content_layout布局时，为单页模式
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news=newsList.get(position);
        if(isTwoPane){
            //如果是双页模式，则刷新NewsContentFragment内容
            NewsContentFragment newsContentFragment=(NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(),news.getContent());
        }else {
            //如果是单页模式，则直接启动NewsContentActivity
            NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
        }
    }
    private List<News> getNews(){
        List<News> newsList=new ArrayList<>();
        News news1=new News();
        news1.setTitle("XXXXXXXXX");
        news1.setContent("XXXXXXXXXXXXXXXXX");
        newsList.add(news1);
        News news2=new News();
        news2.setTitle("YYYYYYYYYYYYY");
        news2.setContent("YYYYYYYYYYYYY");
        newsList.add(news2);
        return newsList;
    }
}
