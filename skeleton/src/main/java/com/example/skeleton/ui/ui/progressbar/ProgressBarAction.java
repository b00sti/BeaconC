package com.example.skeleton.ui.ui.progressbar;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import io.reactivex.functions.Action;

/**
 * Created by Dominik (b00sti) Pawlik on 2016-11-15
 */

public class ProgressBarAction implements Action {

    @Nullable
    private View progressBar;

    private boolean show;
    private Activity ctx;
    private Runnable task;

    public ProgressBarAction(@NonNull Activity ctx, Runnable task) {
        this.ctx = ctx;
        this.task = task;
    }

    public ProgressBarAction(@NonNull Activity ctx, @Nullable View forExampleProgressBar, boolean show) {
        this.ctx = ctx;
        this.progressBar = forExampleProgressBar;
        this.show = show;
    }

    public void showProgressBar() {
        showProgressBar(show);
    }

    public void showProgressBar(final boolean _show) {

        if (progressBar != null) {
            ctx.runOnUiThread(() -> {
                progressBar.setVisibility(_show ? View.VISIBLE : View.GONE);
            });
        } else if (task != null) {
            ctx.runOnUiThread(task);
        }

    }

    @Override
    public void run() throws Exception {
        showProgressBar();
    }
}
