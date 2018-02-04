package com.mottodigitalsolutions.dadbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mottodigitalsolutions.dadbox.Utils.AreaJsonUtil;

import java.util.ArrayList;

/**
 * Created by carlosblanco on 2/3/18.
 */

public class AreaActivity extends AppCompatActivity {

    private AreaAdapter mAdapter;
    private RecyclerView mAreaList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_areas);

        mAreaList = (RecyclerView) findViewById(R.id.rv_areas);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mAreaList.setLayoutManager(layoutManager);

        mAreaList.setHasFixedSize(true);
        mAdapter = new AreaAdapter();

        ArrayList<AreaObject> areasArrayList =
                AreaJsonUtil.getAreaObjects(getResources().getString(R.string.jsonExample));

        mAdapter.setAreas(areasArrayList);

        mAreaList.setAdapter(mAdapter);
    }
}
