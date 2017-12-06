package com.biwe.rxjava.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.biwe.rxjava.R;
import com.biwe.rxjava.adapter.Adapter;
import com.biwe.rxjava.bean.Bean;
import com.biwe.rxjava.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements IView {
    private RecyclerView xrecy;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xrecy = (RecyclerView) findViewById(R.id.xrecy);
        presenter = new Presenter(this);
        presenter.GetUrl();
    }
    @Override
    public void show(Bean bean) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        xrecy.setLayoutManager(manager);
        xrecy.setAdapter(new Adapter(this, bean));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.delete();
    }
}
