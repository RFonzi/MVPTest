package io.github.rfonzi.mvptest.presenter;


import android.os.Handler;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.github.rfonzi.mvptest.model.StringDBInteractor;
import io.github.rfonzi.mvptest.view.IMainView;
import rx.Observable;
import rx.functions.Action1;


/**
 * Created by ryan on 11/25/16.
 */

public class MainPresenter {
    private IMainView view;
    private StringDBInteractor stringDBInteractor;

    public MainPresenter(IMainView mainView){
        this.view = mainView;
        stringDBInteractor = new StringDBInteractor();
    }

    public void doSomethingAndWait5Seconds(){
        view.unhideProgressBar();
        //do something

        //BAD BAD Don't use an android dependency in presenters! (android.os.Handler)
        //Possible alternatives: wrap android.os.Handler in an interface/use rxJava
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(stringDBInteractor.getNumStrings() > 0){
                    int i = new Random().nextInt(stringDBInteractor.getNumStrings());
                    success(stringDBInteractor.getString(i));

                }
                else{
                    error();
                }

                view.hideProgressBar();
            }
        }, 2000);


    }

    public void sendString(String string){
        stringDBInteractor.addString(string);
    }

    private void error() {
        view.loginFailed();
    }

    private void success(String string) {
        view.loginSuccess(string);
    }
}
