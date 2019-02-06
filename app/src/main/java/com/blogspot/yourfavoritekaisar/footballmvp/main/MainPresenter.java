package com.blogspot.yourfavoritekaisar.footballmvp.main;

import com.blogspot.yourfavoritekaisar.footballmvp.model.FootBall.FootballResponse;
import com.blogspot.yourfavoritekaisar.footballmvp.model.network.ApiClient;
import com.blogspot.yourfavoritekaisar.footballmvp.model.network.ApiInterface;
import com.blogspot.yourfavoritekaisar.footballmvp.utils.constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter{

    private final MainContract.View view;
    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }


    @Override
    public void getDataListUser() {
        view.showProgress();

        Call<FootballResponse> call = apiInterface.getFootballList(constant.l);
        call.enqueue(new Callback<FootballResponse>() {
            @Override
            public void onResponse(Call<FootballResponse> call, Response<FootballResponse> response) {
                view.hideProgress();

                if (response.body() !=null){
                    FootballResponse footballResponse = response.body();

                    if (footballResponse.getTeams() !=null){
                        view.showDataListUser(footballResponse.getTeams());
                    }
                }
            }

            @Override
            public void onFailure(Call<FootballResponse> call, Throwable t) {
                view.hideProgress();
                view.showFailureMessage(t.getMessage());

            }
        });

    }
}
