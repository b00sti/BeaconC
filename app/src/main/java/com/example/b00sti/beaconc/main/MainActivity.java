package com.example.b00sti.beaconc.main;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.example.b00sti.beaconc.R;
import com.example.b00sti.beaconc.navigation.NavigationManager;
import com.example.skeleton.android_utils.util.CLog;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import lombok.Getter;

@EActivity(R.layout.activity_home)
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Getter
    @ViewById(R.id.view_pager) public AHBottomNavigationViewPager viewPager;

    @Getter
    @ViewById(R.id.bottom_navigation) public AHBottomNavigation bottomNavigation;

    @Getter
    @ViewById(R.id.floating_action_button) public FloatingActionButton floatingActionButton;

    @Bean
    NavigationManager navigationManager;

    @AfterViews
    void logafterViews() {
        CLog.d(TAG, "logafterViews: ", viewPager);
    }

    @AfterInject
    void logafterInjects() {
        CLog.d(TAG, "logafterInjects: ", viewPager);
    }

    private Handler handler = new Handler();

    @AfterViews
    void init() {
        boolean enabledTranslucentNavigation = getSharedPreferences("shared", Context.MODE_PRIVATE)
                .getBoolean("translucentNavigation", false);
        setTheme(enabledTranslucentNavigation ? R.style.AppTheme_TranslucentNavigation : R.style.AppTheme);
        navigationManager.initUI(new NavigationManager.AHonTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    /**
     * Reload activity
     */
    public void reload() {
        startActivity(new Intent(this, MainActivity_.class));
        finish();
    }

    /**
     * Update the bottom navigation colored param
     */
    public void updateBottomNavigationColor(boolean isColored) {
        navigationManager.updateBottomNavigationColor(isColored);
    }

    /**
     * Return if the bottom navigation is colored
     */
    public boolean isBottomNavigationColored() {
        return navigationManager.isBottomNavigationColored();
    }

    /**
     * Add or remove items of the bottom navigation
     */
    public void updateBottomNavigationItems(boolean addItems) {
        navigationManager.updateBottomNavigationItems(addItems);
    }

    /**
     * Show or hide the bottom navigation with animation
     */
    public void showOrHideBottomNavigation(boolean show) {
        navigationManager.showOrHideBottomNavigation(show);
    }

    /**
     * Show or hide selected item background
     */
    public void updateSelectedBackgroundVisibility(boolean isVisible) {
        navigationManager.updateSelectedBackgroundVisibility(isVisible);
    }

    /**
     * Show or hide selected item background
     */
    public void setForceTitleHide(boolean forceTitleHide) {
        navigationManager.setForceTitleHide(forceTitleHide);
    }

    /**
     * Return the number of items in the bottom navigation
     */
    public int getBottomNavigationNbItems() {
        return navigationManager.getBottomNavigationNbItems();
    }

}
