package com.biwe.rxjava.presenter;

import com.biwe.rxjava.bean.Bean;
import com.biwe.rxjava.model.Model;
import com.biwe.rxjava.view.IView;

import rx.Observer;

public class Presenter {
    IView iView;
    private final Model model;

    public Presenter(IView iView) {
        this.iView = iView;
        model = new Model();
    }
    public void GetUrl(){
        model.getData(new Observer<Bean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Bean bean) {
                iView.show(bean);            }
        });
    }
    public void delete(){
        iView=null;
    }

}