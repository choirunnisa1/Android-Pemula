package com.example.submixone;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.audiofx.DynamicsProcessing;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Config;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class IdolAdapter extends RecyclerView.Adapter<IdolAdapter.ListViewHolder> {
    private ArrayList<IdolName> listIdol;
     private Context context;

    public IdolAdapter(ArrayList<IdolName> list) {
        this.context = context;
        this.listIdol = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listdata, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, final int position) {
        final IdolName idol = listIdol.get(position);
        Glide.with(holder.itemView.getContext())
                .load(idol.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(idol.getName());
        holder.tvTtl.setText(idol.getTtl());

        holder.cv_det.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindg = new Intent(view.getContext(), DetailActivity.class);
                pindg.putExtra("IMAGE",idol.getPhoto());
                pindg.putExtra("NAME",holder.tvName.getText().toString().trim());
                pindg.putExtra("TTL",idol.getTtl());
                view.getContext().startActivity(pindg);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listIdol.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvTtl;
        CardView cv_det;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvTtl = itemView.findViewById(R.id.tv_item_ttl);
            cv_det= itemView.findViewById(R.id.cv_detail);
        }
    }
}
