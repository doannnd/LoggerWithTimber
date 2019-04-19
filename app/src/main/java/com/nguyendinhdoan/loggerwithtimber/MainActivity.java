package com.nguyendinhdoan.loggerwithtimber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // boolean
        boolean isWeekend = false;
        Timber.d("This prints the boolean value. Is weekend: %b", isWeekend);

        // integer
        int a = 100;
        Timber.d("Integer a value is: %d", a);

        // float
        float pi = 3.14159f;
        Timber.d("Pi value is: %f", pi);

        int e = 10 / 0;
        Timber.d("Value of a: %d", e);
    }
}
