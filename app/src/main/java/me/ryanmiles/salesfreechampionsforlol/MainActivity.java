package me.ryanmiles.salesfreechampionsforlol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.robrua.orianna.type.dto.staticdata.Champion;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;
import me.ryanmiles.salesfreechampionsforlol.events.FreeChampions;
import me.ryanmiles.salesfreechampionsforlol.fragments.ChampionRoation;

public class MainActivity extends AppCompatActivity {

    protected EventBus mEventBus;
    ChampionRoation mChampionRoation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            mChampionRoation = new ChampionRoation();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, mChampionRoation)
                    .commit();
        }
    }

    @SuppressWarnings("unused")
    public void onEventMainThread(FreeChampions freeChampions) {
        ArrayList<Champion> test = (ArrayList<Champion>) freeChampions.getChampions();
        mChampionRoation.updateChampions(test);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }


    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
