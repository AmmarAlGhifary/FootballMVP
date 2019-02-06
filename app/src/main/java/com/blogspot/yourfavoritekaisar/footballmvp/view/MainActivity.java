package com.blogspot.yourfavoritekaisar.footballmvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.blogspot.yourfavoritekaisar.footballmvp.Detail.DetailContract;
import com.blogspot.yourfavoritekaisar.footballmvp.Detail.DetailPresenter;
import com.blogspot.yourfavoritekaisar.footballmvp.R;
import com.blogspot.yourfavoritekaisar.footballmvp.adapter.AdapterMain;
import com.blogspot.yourfavoritekaisar.footballmvp.main.MainContract;
import com.blogspot.yourfavoritekaisar.footballmvp.main.MainPresenter;
import com.blogspot.yourfavoritekaisar.footballmvp.model.FootBall.FootballData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    @BindView(R.id.rv_user)
    RecyclerView rvUser;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;


    private ProgressDialog progressDialog;
    private final MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter.getDataListUser();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.getDataListUser();

            }
        });
    }


    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading..");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
        swipeRefresh.setRefreshing(false);

    }


    @Override
    public void showDataListUser(List<FootballData> footballDataList) {
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        rvUser.setAdapter(new AdapterMain(this, footballDataList));

    }


    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
