package com.biwe.rxjava.net;

import com.biwe.rxjava.bean.Bean;

import retrofit2.http.GET;
import rx.Observable;

public interface BaseRetrofit {
    @GET("nba/?key=71e58b5b2f930eaf1f937407acde08fe&num=10")
    Observable<Bean> getCall();
}