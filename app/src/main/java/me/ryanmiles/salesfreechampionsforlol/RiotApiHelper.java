package me.ryanmiles.salesfreechampionsforlol;

import com.robrua.orianna.api.dto.BaseRiotAPI;
import com.robrua.orianna.type.dto.champion.Champion;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import me.ryanmiles.salesfreechampionsforlol.events.FreeChampions;
import timber.log.Timber;

/**
 * Created by Ryan on 12/1/2015.
 */
public class RiotApiHelper {

    public static void getFreeChampions() {
        Timber.d("GetFreeChampions Called");
        Thread thread = new Thread() {
            @Override
            public void run() {
                List<com.robrua.orianna.type.dto.staticdata.Champion> freeChampionList = new ArrayList<>();
                List<Champion> mFreeChampions = BaseRiotAPI.getChampionStatuses(true).getChampions();
                Timber.d("GetChampionStatuses()");
                for (Champion mFreeChampion : mFreeChampions) {
                    freeChampionList.add(BaseRiotAPI.getChampion(mFreeChampion.getId()));
                }
                Timber.d("Post Event for FreeChampions" + freeChampionList);
                EventBus.getDefault().post(new FreeChampions(freeChampionList));
            }
        };
        thread.start();
    }
}
