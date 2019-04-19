package com.nguyendinhdoan.loggerwithtimber.logger;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

import timber.log.Timber;

public class DebugTree extends Timber.DebugTree{

    /*
    * create custom tag for timber with add line number
    * */
    @Override
    protected @Nullable String createStackElementTag(@NotNull StackTraceElement element) {
        return String.format(Locale.getDefault(), "C:%s:%s", super.createStackElementTag(element),
                element.getLineNumber());
    }
}
