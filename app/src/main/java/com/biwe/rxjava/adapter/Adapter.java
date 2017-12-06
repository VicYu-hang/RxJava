package com.biwe.rxjava.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.biwe.rxjava.R;
import com.biwe.rxjava.bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

public class Adapter extends XRecyclerView.Adapter<Adapter.MyViewHolder>{
    Context context;
    private TextView tv;
//    private List<Bean.NewslistBean> data;
    private Bean bean;
//    private ImageView sim;
    private SimpleDraweeView sim;

    public Adapter(Context context,  Bean bean) {
        this.context=context;
        this.bean=bean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item,null);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        tv.setText(bean.getNewslist().get(position).getTitle());
        sim.setImageURI(bean.getNewslist().get(position).getPicUrl());
//        sim.setImageURI(bean.getNewslist().get(position).getPicUrl());
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setUri(bean.getNewslist().get(position).getPicUrl())
//                .setAutoPlayAnimations(true)
//                .build();
//        sim.setController(controller);
//        Glide.with(context).load(bean.getNewslist().get(position).getPicUrl()).into(sim);
    }



    @Override
    public int getItemCount() {
        return bean.getNewslist().size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
            sim=itemView.findViewById(R.id.sim);
        }
    }

}