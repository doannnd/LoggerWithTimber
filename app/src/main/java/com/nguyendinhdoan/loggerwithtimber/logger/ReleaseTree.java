package com.nguyendinhdoan.loggerwithtimber.logger;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import timber.log.Timber;

public class ReleaseTree extends Timber.Tree {

    private static final String PRIORITY_KEY = "PRIORITY_KEY";
    private static final String TAG_KEY = "TAG_KEY";
    private static final String MESSAGE_KEY = "MESSAGE_KEY";

    @Override
    protected void log(int priority, @Nullable String tag, @NotNull String message, @Nullable Throwable t) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO) {
            return;
        }

        Crashlytics.setInt(PRIORITY_KEY, priority);
        Crashlytics.setString(TAG_KEY, tag);
        Crashlytics.setString(MESSAGE_KEY, message);

        if (t == null) {
            Crashlytics.logException(new Exception(message));
        } else {
            Crashlytics.logException(t);
        }

    }
}
