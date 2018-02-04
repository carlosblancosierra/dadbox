package com.mottodigitalsolutions.dadbox;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by carlosblanco on 2/3/18.
 */

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.AreaViewHolder>{

    private int mNumberItems;
    private ArrayList<AreaObject> mAreasArray;

    @Override
    public AreaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.area_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        AreaViewHolder viewHolder = new AreaViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AreaViewHolder holder, int position) {

        final AreaObject currentArea = mAreasArray.get(position);
        final Context context = holder.itemView.getContext();
        final int geniusId = currentArea.getGeniusId();
        final ChallengeObject main_challenge = currentArea.getMainChallenge();
        final ChallengeObject secondary_challenge = currentArea.getSecondaryChallenge();
        final ChallengeObject bonus_challenge = currentArea.getBonusChallenge();


        holder.areaGeniusListItem.setText(
                context.getResources().getStringArray(R.array.geniuses)[geniusId]);
        holder.areaIntelligenceListItem.setText(
                context.getResources().getStringArray(R.array.geniuses_intelligences)[geniusId]);



        holder.itemView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(context, AreaDetailActivity.class);
                intent.putExtra(
                        context.getResources().getString(R.string.genius_id_key), geniusId);
                intent.putExtra(
                        context.getResources().getString(R.string.challenge_main_key), main_challenge);
                intent.putExtra(
                        context.getResources().getString(R.string.challenge_secondary_key), secondary_challenge);
                intent.putExtra(
                        context.getResources().getString(R.string.challenge_bonus_key), bonus_challenge);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mAreasArray == null) return 0;
        return mAreasArray.size();
    }


    public class AreaViewHolder extends RecyclerView.ViewHolder {

        TextView areaGeniusListItem;
        TextView areaIntelligenceListItem;

        private AreaViewHolder(View itemView) {
            super(itemView);

            areaGeniusListItem = (TextView) itemView.findViewById(R.id.area_genius);
            areaIntelligenceListItem = (TextView) itemView.findViewById(R.id.area_intelligence);
        }

    }

    public void setAreas(ArrayList<AreaObject> areas) {
        mAreasArray = areas;
        notifyDataSetChanged();
    }

}
