package com.example.jean.retrofitexample.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.adapter.FootballAdapter;
import com.example.jean.retrofitexample.model.HistoryData;
import com.example.jean.retrofitexample.model.PlayerData;
import com.example.jean.retrofitexample.presenter.FootballPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FootballView {

    public static final String ROOT_URL = "https://private-0e6b9-ganjarwidyatmansyah.apiary-mook.com/";


    RecyclerView mRecdata;

    LinearLayoutManager mLayoutManager;
    FootballAdapter footballAdapter;
    FootballPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecdata = findViewById(R.id.rv_data);
        mLayoutManager = new LinearLayoutManager(this);
        presenter = new FootballPresenter(this);
        mRecdata.setLayoutManager(mLayoutManager);

        presenter.getPlayerData();

    }

    @Override
    public void playerReady(List<PlayerData> data) {
        footballAdapter = new FootballAdapter(data, MainActivity.this);
        mRecdata.setAdapter(footballAdapter);
        footballAdapter.notifyDataSetChanged();

    }

    @Override
    public void historyReady(List<HistoryData> data) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
