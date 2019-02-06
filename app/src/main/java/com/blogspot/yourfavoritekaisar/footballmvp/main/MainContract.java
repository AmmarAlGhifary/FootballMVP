package com.blogspot.yourfavoritekaisar.footballmvp.main;

import com.blogspot.yourfavoritekaisar.footballmvp.model.FootBall.FootballData;

import java.util.List;

public interface MainContract {
    interface View{
        void showProgress();
        void hideProgress();

        void showDataListUser(List<FootballData> footballDataList);

        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataListUser();
    }
}
