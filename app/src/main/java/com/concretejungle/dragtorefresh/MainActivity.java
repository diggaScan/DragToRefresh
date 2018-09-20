package com.concretejungle.dragtorefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final String TAG = this.getClass().getSimpleName();
    private RecyclerView recyclerView;
    private DragToRefreshView dragToRefreshView;
    private TextView news_stats;
    private TextView news_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) getLayoutInflater().inflate(R.layout.recyclerview, null);
        List<String> dataSet=new ArrayList<>();
        for(int i=0;i<2;i++){
            dataSet.add("Test");
        }
        RvAdapter rvAdapter=new RvAdapter(this,dataSet,null);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.addItemDecoration(new My_Item_decoration(this));
        dragToRefreshView = findViewById(R.id.ok);

        DragToRefreshView.OnUpdateListener listener = new DragToRefreshView.OnUpdateListener() {

            @Override
            public void onRefreshing(DragToRefreshView view) {

            }

            @Override
            public void onFinished(DragToRefreshView view) {

            }
        };

        dragToRefreshView.addMainContent(recyclerView);
        dragToRefreshView.setUpdateListener(listener);
    }
}
