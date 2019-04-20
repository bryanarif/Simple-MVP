package com.example.jean.retrofitexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.Player;
import com.example.jean.retrofitexample.model.PlayerData;

import java.util.List;
import java.util.zip.Inflater;



public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.FootBallViewHolder> {


    List<PlayerData> playerDataList;
    Context mContext;

    public FootballAdapter(List<PlayerData> playerDataList, Context mContext){
        this.playerDataList = playerDataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FootBallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_gambar, parent , false);
        return new FootBallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootBallViewHolder holder, int position) {


        PlayerData data = playerDataList.get(position);


        Glide.with(mContext)
                .load(data.getGambar())
                .into(holder.img_gambar);

        holder.txt_nama.setText(data.getNama());
        holder.txt_age.setText(data.getAge());


    }

    @Override
    public int getItemCount() {
        return playerDataList.size();
    }


    public class FootBallViewHolder extends RecyclerView.ViewHolder{


        private TextView txt_nama;
        private TextView txt_age;
        private ImageView img_gambar;

        public FootBallViewHolder (View itemView){
            super(itemView);

            txt_nama= (TextView) itemView.findViewById(R.id.nama);
            txt_age = (TextView) itemView.findViewById(R.id.age);
            img_gambar = (ImageView) itemView.findViewById(R.id.img_gambar);

        }

   }
}
