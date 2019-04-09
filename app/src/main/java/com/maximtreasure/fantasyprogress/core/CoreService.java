package com.maximtreasure.fantasyprogress.core;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by maxim on 19-4-9.
 */

public class CoreService extends IntentService {

    public CoreService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
