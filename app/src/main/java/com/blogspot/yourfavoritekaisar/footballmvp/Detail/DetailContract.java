package com.blogspot.yourfavoritekaisar.footballmvp.Detail;

import android.os.Bundle;

import com.blogspot.yourfavoritekaisar.footballmvp.model.FootBall.FootballData;

import java.util.List;

public interface DetailContract {
    interface View{
        void showProgress();
        void hideProgress();
        void showDataFootball(List<FootballData> footballData);
        void showFailureMessage(String msg);
    }

    interface Presenter{
        void getDataFootball(Bundle bundle);
    }
}
