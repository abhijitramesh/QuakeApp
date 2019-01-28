package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class   EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }
    private static final String LOCATION_SEPARATOR = "of";

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Earthquake currentEarthQuake = getItem(position);
        String orginalLocation = currentEarthQuake.getPlace();
        String primaryLocation;
        String locationOffset;
        String magnitude;


        if(orginalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts = orginalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        }
        else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = orginalLocation;
        }
        DecimalFormat formatter = new DecimalFormat("0.0");
        magnitude = formatter.format(currentEarthQuake.getMagnitude());



        TextView MagnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        MagnitudeTextView.setText(magnitude);
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) MagnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthQuake.getMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        TextView PlaceTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        PlaceTextView.setText(locationOffset);
        TextView PlaceTextView_1 = (TextView) listItemView.findViewById(R.id.primary_location);
        PlaceTextView_1.setText(primaryLocation);
        Date dateObject = new Date(currentEarthQuake.getmTimeInMilliseconds());
        TextView DateTextView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        DateTextView.setText(formattedDate);
        TextView TimeTextView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        TimeTextView.setText(formattedTime);



        return listItemView;

    }
    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:m a");
        return timeFormat.format(dateObject);
    }
    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
