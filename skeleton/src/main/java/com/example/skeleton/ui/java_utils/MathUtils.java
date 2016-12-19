package com.example.skeleton.ui.java_utils;

/**
 * Created by Dominik (b00sti) Pawlik on 2016-11-15
 */

public class MathUtils {
    private static final String TAG = "MathUtils";

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // haversine great circle distance approximation, returns meters
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60; // 60 nautical miles per degree of seperation
        dist = dist * 1852; // 1852 meters per nautical mile
        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public static String computeDistanceUnit(double m) {
        if (m > 1000) {
            return Math.round(m / 1000) + "km";
        } else {
            return Math.round(m) + "m";
        }
    }
}
