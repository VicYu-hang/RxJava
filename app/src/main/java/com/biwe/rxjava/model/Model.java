package com.biwe.rxjava.model;

import com.biwe.rxjava.bean.Bean;
import com.biwe.rxjava.net.BaseRetrofit;
import com.biwe.rxjava.net.BaseUrl;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Model {
    public void getData(Observer<Bean> observer){
//        OkHttpClient okHttpClient=new OkHttpClient.Builder()
//                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BaseUrl.url)
//                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BaseRetrofit baseRetrofit=retrofit.create(BaseRetrofit.class);
        Observable<Bean> observable=baseRetrofit.getCall();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}