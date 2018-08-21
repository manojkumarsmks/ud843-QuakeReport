package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<EarthQuake> {

    private Context context;
    private List<EarthQuake> earthQuakesList;

    public CustomAdapter(@NonNull Context context, List<EarthQuake> earthQuakes) {
        super(context,0, earthQuakes);
        this.context = context;
        this.earthQuakesList = earthQuakes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.layout_unit,parent,false);

        EarthQuake tempEarthQuake = earthQuakesList.get(position);

        RelativeLayout relativeLayout = (RelativeLayout)listItem.findViewById(R.id.magnitude_layout);

        GradientDrawable magnitudeCircle =  (GradientDrawable) relativeLayout.getBackground();

        TextView magnitude = (TextView)listItem.findViewById(R.id.magnitude);
        magnitude.setText(Double.toString(tempEarthQuake.magnitude));

        magnitudeCircle.setColor(getMagnitudeColor(tempEarthQuake.magnitude));

        TextView location = (TextView)listItem.findViewById(R.id.location);
        location.setText(tempEarthQuake.location);

        TextView locationOffset = (TextView)listItem.findViewById(R.id.location_offset);
        locationOffset.setText(tempEarthQuake.locationOffset);

        TextView date = (TextView)listItem.findViewById(R.id.date);
        date.setText(tempEarthQuake.date);

        TextView time = (TextView)listItem.findViewById(R.id.time);
        time.setText(tempEarthQuake.time);

        return listItem;

    }

    public int getMagnitudeColor(double magnitude) {
        int result;
        int magnitudeFloor = (int)Math.floor(magnitude);

        switch (magnitudeFloor) {
            case 0:
            case 1:
                result = R.color.magnitude1;
                break;
            case 2:
                result = R.color.magnitude2;
                break;
            case 3:
                result = R.color.magnitude3;
                break;
            case 4:
                result = R.color.magnitude4;
                break;
            case 5:
                result = R.color.magnitude5;
                break;
            case 6:
                result = R.color.magnitude6;
                break;
            case 7:
                result = R.color.magnitude7;
                break;
            case 8:
                result = R.color.magnitude8;
                break;
            case 9:
                result = R.color.magnitude9;
                break;
            default:
                result = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), result);


    }

}
