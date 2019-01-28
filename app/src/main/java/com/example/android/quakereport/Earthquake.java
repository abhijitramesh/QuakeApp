package com.example.android.quakereport;


public class Earthquake {
    private double mMagnitude;

    private String mPlace;

    private  long mTimeInMilliseconds;

    private String mUrl;


    public Earthquake(double Magnitude, String Place, long TimeInMillisecond) {
        mMagnitude = Magnitude;
        mPlace = Place;
        mTimeInMilliseconds = TimeInMillisecond;


    }
    public Earthquake(double Magnitude,String place,long TimeInMilliseconds,String url) {
        mMagnitude = Magnitude;
        mPlace = place;
        mTimeInMilliseconds = TimeInMilliseconds;
        mUrl = url;

    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getPlace() {
        return mPlace;
    }

    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }



    @Override
    public String toString() {
        return "Earthquake{" + "mMagnitude" + mMagnitude + '\'' + "Place" + mPlace + '\'' + "Date" + mTimeInMilliseconds + "}";
    }

    public String getUrl() {return mUrl;
    }
}
