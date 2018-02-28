package com.qimiaowa.test_mvp4.contract;

import com.qimiaowa.test_mvp4.model.UserInfoModel;
import com.qimiaowa.test_mvp4.presenter.BasePresenter;

/**
 * Created by Administrator on 2018/2/28/028.
 * 契约内部有2个接口，分别继承了BaseView和BasePresenter，View和Presenter中实现的方法分别是UI操作，和数据业务逻辑操作，此时是不是看的异常的清晰。
 */

public interface UserInfoContract {
     interface View extends Baseview<Presenter>{
        void showLoading();//展示加载框
        void dismissLoading();//取消加载框展示
        void showUserInfo(UserInfoModel userInfoModel);//将网络请求得到的用户信息回调
        String loadUserId();//假设接口请求需要一个userId

    }

     interface Presenter extends BasePresenter {
        void loadUserInfo();
    }

}
