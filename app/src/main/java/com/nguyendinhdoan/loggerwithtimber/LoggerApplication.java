package com.nguyendinhdoan.loggerwithtimber;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.nguyendinhdoan.loggerwithtimber.logger.DebugTree;
import com.nguyendinhdoan.loggerwithtimber.logger.ReleaseTree;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

public class LoggerApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());
       /* // disable on debug mode
        CrashlyticsCore core = new CrashlyticsCore.Builder()
                .disabled(BuildConfig.DEBUG)
                .build();

        Fabric.with(this, new Crashlytics.Builder().core(core).build());*/

        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        } else {
            Timber.plant(new ReleaseTree());
        }
    }
}
