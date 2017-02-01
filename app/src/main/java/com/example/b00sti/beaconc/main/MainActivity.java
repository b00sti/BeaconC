package com.example.b00sti.beaconc.main;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.b00sti.beaconc.R;
import com.example.b00sti.beaconc.navigation.NavigationManager;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_home)
public class MainActivity extends AppCompatActivity {

    @Bean
    NavigationManager navigationManager;
    private Handler handler = new Handler();

    @AfterInject
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
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
