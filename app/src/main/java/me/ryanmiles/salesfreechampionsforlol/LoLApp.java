package me.ryanmiles.salesfreechampionsforlol;

import android.app.Application;
import android.os.StrictMode;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

/**
 * Created by Ryanm14 on 11/28/2015.
 */
public final class LoLApp extends Application {

    public static String LOLVERSION;
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());

            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .penaltyFlashScreen()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build());
            Picasso.with(this).setLoggingEnabled(true);
            Timber.d("Strict mode and Timber initialized");
        } else {
            // TODO Crashlytics.start(this);
            // TODO Timber.plant(new CrashlyticsTree());
        }
        // TODO: 11/28/2015 Change and save Regions and Strict Mode
        RiotAPI.setRegion(Region.NA);
        RiotAPI.setAPIKey(getString(R.string.api_key));
        LOLVERSION = RiotAPI.getVersions().get(0);

    }
}
