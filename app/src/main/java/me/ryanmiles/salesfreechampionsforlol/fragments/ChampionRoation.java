package me.ryanmiles.salesfreechampionsforlol.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robrua.orianna.type.dto.staticdata.Champion;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.ryanmiles.salesfreechampionsforlol.R;
import me.ryanmiles.salesfreechampionsforlol.RiotApiHelper;
import timber.log.Timber;


public class ChampionRoation extends Fragment {

    @Bind(R.id.fragment_champion_rotation_text_view)
    TextView tv;

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

    public void updateChampions(ArrayList<Champion> champions) {
        for (Champion champion : champions) {
            tv.append(champion.getName() + "\n");
        }
        Timber.d("Updated TextView with free champions");
    }
}