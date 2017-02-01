package com.example.b00sti.beaconc.navigation;

import android.support.v4.app.Fragment;

/**
 * Created by Dominik (b00sti) Pawlik on 2017-02-01
 */

public abstract class BaseRefreshableFragment extends Fragment {
    public abstract void refresh();

    public abstract void willBeHidden();

    public abstract void willBeDisplayed();
}
