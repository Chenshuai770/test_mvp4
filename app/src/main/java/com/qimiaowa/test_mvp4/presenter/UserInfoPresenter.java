package com.qimiaowa.test_mvp4.presenter;

import android.os.Handler;

import com.qimiaowa.test_mvp4.contract.UserInfoContract;
import com.qimiaowa.test_mvp4.model.UserInfoModel;

/**
 * Created by Administrator on 2018/2/28/028.
 */

public class UserInfoPresenter implements UserInfoContract.Presenter{
    private  UserInfoContract.View view;

    //1：UserInfoPresenter 构造函数中传入UserInfoContract.View，并且调用view的setPresenter()方法；
    public UserInfoPresenter(UserInfoContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    //2：将所有的初始化操作都放在start()方法中（这里demo只有一个：网络请求获取用户信息），
    // 这样只要进入界面的时候调用start()方法就可以执行一系列初始化的操作，这就相当于一种约定好的开发。

    @Override
    public void start() {
        loadUserInfo();
    }

    @Override
    public void loadUserInfo() {
        final String userId = view.loadUserId();
        view.showLoading();//接口请求前显示loading
        //这里模拟接口请求回调-
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (userId.equals("1000")){
                    //模拟接口返回的json，并转换为javaBean
                    UserInfoModel userInfoModel = new UserInfoModel("小宝", 1, "杭州");
                    view.showUserInfo(userInfoModel);
                    view.dismissLoading();
                }else {
                    view.dismissLoading();
                }

            }
        }, 2000);
    }
}
