package me.ryanmiles.salesfreechampionsforlol.events;

import com.robrua.orianna.type.dto.staticdata.Champion;

import java.util.List;

/**
 * Created by Ryan on 12/1/2015.
 */
public class FreeChampions {
    private List<Champion> mChampions;

    public FreeChampions(List<Champion> champions) {
        mChampions = champions;
    }

    public List<Champion> getChampions() {
        return mChampions;
    }
}
