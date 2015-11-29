package me.ryanmiles.salesfreechampionsforlol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.robrua.orianna.api.core.AsyncRiotAPI;
import com.robrua.orianna.type.api.Action;
import com.robrua.orianna.type.core.summoner.Summoner;
import com.robrua.orianna.type.exception.APIException;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AsyncRiotAPI.getSummonerByName(new Action<Summoner>() {
            @Override
            public void handle(APIException exception) {

            }

            @Override
            public void perform(Summoner responseData) {
                Timber.d(responseData.getRevisionDate() + "");
            }
        }, "OJjuiceman");



    }
}
