package com.blogspot.yourfavoritekaisar.footballmvp.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.yourfavoritekaisar.footballmvp.Detail.DetailContract;
import com.blogspot.yourfavoritekaisar.footballmvp.Detail.DetailPresenter;
import com.blogspot.yourfavoritekaisar.footballmvp.R;
import com.blogspot.yourfavoritekaisar.footballmvp.model.FootBall.FootballData;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailContract.View{

    @BindView(R.id.imgLogoClub)
    ImageView imgLogoClub;
    @BindView(R.id.txtNamaClub)
    TextView txtNamaClub;
    @BindView(R.id.txtDetail)
    TextView txtDetail;

    private ProgressDialog progressDialog;
    private final DetailPresenter detailPresenter = new DetailPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        detailPresenter.getDataFootball(bundle);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(DetailActivity.this);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Getting Yourself sum data");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void showDataFootball(List<FootballData> footballData) {
        txtDetail.setText(footballData.get(0).getStrTeam());
        txtDetail.setText(footballData.get(0).getStrDescriptionEN());

        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image_black_24dp).placeholder(R.drawable.ic_error_black_24dp);

        Glide.with(this).load(footballData.get(0).getStrTeamBadge()).apply(options).into(imgLogoClub);
    }


    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
