package me.ryanmiles.salesfreechampionsforlol.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.robrua.orianna.type.dto.staticdata.Champion;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.ryanmiles.salesfreechampionsforlol.LoLApp;
import me.ryanmiles.salesfreechampionsforlol.R;
import me.ryanmiles.salesfreechampionsforlol.RiotApiHelper;
import me.ryanmiles.salesfreechampionsforlol.adapter.ImageGridAdapter;
import timber.log.Timber;


public class ChampionRoation extends Fragment {

    @Bind(R.id.fragment_champion_rotation_grid_view)
    GridView champIconsGridView;

    public ChampionRoation() {

    }

    public static ChampionRoation newInstance() {
        return new ChampionRoation();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Timber.d("Called getFreechampions()");
        RiotApiHelper.getFreeChampions();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_champion_roation, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    public void updateChampions(List<Champion> champions) {
        ArrayList<String> championLinks = new ArrayList<>();
        for (Champion champion : champions) {
            championLinks.add("http://ddragon.leagueoflegends.com/cdn/img/champion/loading/"
                    + champion.getName().replace(" ", "")
                    + "_0.jpg");
        }
        // Timber.i(championLinks.toString());
        champIconsGridView.setAdapter(new ImageGridAdapter(getActivity(), championLinks));

        Timber.d("Updated TextView with free champions");
    }

    public void updateChampionsIcons(List<Champion> champions) {
        ArrayList<String> championLinks = new ArrayList<>();
        for (Champion champion : champions) {
            championLinks.add("http://ddragon.leagueoflegends.com/cdn/"
                    + LoLApp.LOLVERSION
                    + "/img/champion/" +
                    champion.getImage().getFull());
        }
        Timber.i(championLinks.toString());
        champIconsGridView.setAdapter(new ImageGridAdapter(getActivity(), championLinks));

        Timber.d("Updated TextView with free champions");
    }
}