package com.blogspot.yourfavoritekaisar.footballmvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.yourfavoritekaisar.footballmvp.R;
import com.blogspot.yourfavoritekaisar.footballmvp.model.FootBall.FootballData;
import com.blogspot.yourfavoritekaisar.footballmvp.utils.constant;
import com.blogspot.yourfavoritekaisar.footballmvp.view.DetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {
    private final Context context;
    private final List<FootballData> footballDataList;

    public AdapterMain(Context context, List<FootballData> footballDataList) {
        this.context = context;
        this.footballDataList = footballDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_football, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final FootballData footballData = footballDataList.get(i);


        viewHolder.txtClub.setText(footballData.getStrTeam());

        RequestOptions options = new RequestOptions().error(R.drawable.ic_broken_image_black_24dp).placeholder(R.drawable.ic_error_black_24dp);

        Glide.with(context).load(footballData.getStrTeamBadge()).apply(options).into(viewHolder.imgClub);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(constant.id, String.valueOf(footballData.getIdTeam()));

                context.startActivity(new Intent(context, DetailActivity.class).putExtras(bundle));
            }
        });
    }

    @Override
    public int getItemCount() {
        return footballDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgClub)
        ImageView imgClub;
        @BindView(R.id.txtClub)
        TextView txtClub;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
