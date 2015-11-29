package me.ryanmiles.salesfreechampionsforlol.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.robrua.orianna.api.dto.BaseRiotAPI;
import com.robrua.orianna.type.dto.champion.Champion;

import java.util.ArrayList;
import java.util.List;

import me.ryanmiles.salesfreechampionsforlol.R;


public class ChampionRoation extends Fragment {
    private ArrayList<com.robrua.orianna.type.dto.staticdata.Champion> mFreeChampionList = new ArrayList<>();
    private GridView mGridView;

    public ChampionRoation() {

    }

    public static ChampionRoation newInstance() {
        ChampionRoation fragment = new ChampionRoation();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Thread thread = new Thread() {
            @Override
            public void run() {
                List<Champion> mFreeChampions = BaseRiotAPI.getChampionStatuses(true).getChampions();
                for (Champion mFreeChampion : mFreeChampions) {
                    mFreeChampionList.add(BaseRiotAPI.getChampion(mFreeChampion.getId()));
                }

            }
        };
        thread.start();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_champion_roation, container, false);
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onDetach() {
        super.onDetach();
    }

}