package com.example.android.discoverourense;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cristina on 23/06/2017.
 * {@link LocationAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link Location} objects.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    /**
     * Custom constructor.
     * @param context         The current context. Used to inflate the layout file.
     * @param locations           A List of Location objects to display in a list
     */
    public LocationAdapter(Activity context, ArrayList<Location> locations) {
        // Here, we initialize the ArrayAdapter. The second argument is used when the ArrayAdapter
        // is populating a single TextView. Because this is a custom adapter, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, locations);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the {@link Location} object located at this position in the list
        Location currentLocation = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            // Create different lists whether the location is a business or not
            if (getItem(position).hasType() | getItem(position).hasStars()) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.business_list_item, parent, false);
            } else {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.location_list_item, parent, false);
            }
        }

        // Link the Location information with the layout
        // Set the location image
        ImageView locationImageView = (ImageView) listItemView.findViewById(R.id.location_image);
        locationImageView.setImageResource(currentLocation.getImageResourceId());
        // Set the location name
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.location_title);
        titleTextView.setText(currentLocation.getTitle());
        // Create and assign Roboto-Bold typeface
        String fontPathRobotoBold = "fonts/Roboto-Bold.ttf";
        Typeface typeFaceRobotoBold = Typeface.createFromAsset(getContext().getAssets(),
                fontPathRobotoBold);
        titleTextView.setTypeface(typeFaceRobotoBold);
        // Create Roboto-Regular typeface
        String fontPathRobotoRegular = "fonts/Roboto-Regular.ttf";
        Typeface typeFaceRobotoRegular = Typeface.createFromAsset(getContext().getAssets(),
                fontPathRobotoRegular);
        if (getItem(position).hasType()) {
            // Location is a restaurant
            // Set the location address and assign typeface
            TextView addressTextView = (TextView) listItemView.findViewById(R.id.location_address);
            addressTextView.setText(currentLocation.getAddress());
            addressTextView.setTypeface(typeFaceRobotoRegular);
            // Set the type of restaurant
            String typeOfRestaurant = currentLocation.getType();
            ArrayList<String> types= new ArrayList<>();
            types.add(getContext().getString(R.string.bar_type));
            types.add(getContext().getString(R.string.restaurant_type));
            types.add(getContext().getString(R.string.tapas_type));
            types.add(getContext().getString(R.string.galician_type));
            types.add(getContext().getString(R.string.japanese_type));
            types.add(getContext().getString(R.string.grill_type));
            types.add(getContext().getString(R.string.mexican_type));
            types.add(getContext().getString(R.string.wine_type));
            types.add(getContext().getString(R.string.fast_food_type));
            types.add(getContext().getString(R.string.italian_type));
            types.add(getContext().getString(R.string.turkish_type));
            types.add(getContext().getString(R.string.american_type));
            ArrayList<Integer> typeIcons= new ArrayList<>();
            typeIcons.add(R.id.type_bar);
            typeIcons.add(R.id.type_restaurant);
            typeIcons.add(R.id.type_tapas);
            typeIcons.add(R.id.type_galician);
            typeIcons.add(R.id.type_japanese);
            typeIcons.add(R.id.type_grill);
            typeIcons.add(R.id.type_mexican);
            typeIcons.add(R.id.type_wine);
            typeIcons.add(R.id.type_fast_food);
            typeIcons.add(R.id.type_italian);
            typeIcons.add(R.id.type_turkish);
            typeIcons.add(R.id.type_american);
            for (int i = 0; i<types.size(); i++) {
                // Icons visibility is gone by default
                listItemView.findViewById(typeIcons.get(i)).setVisibility(View.GONE);
                if (typeOfRestaurant.toLowerCase().contains(types.get(i).toLowerCase())) {
                    listItemView.findViewById(typeIcons.get(i)).setVisibility(View.VISIBLE);
                }
            }
        } else if (getItem(position).hasStars()) {
            // Location is a hotel
            // Set the location address and assign typeface
            TextView addressTextView = (TextView) listItemView.findViewById(R.id.location_address);
            addressTextView.setText(currentLocation.getAddress());
            addressTextView.setTypeface(typeFaceRobotoRegular);
            // Set the number of stars
            int numberOfStars = Integer.parseInt(currentLocation.getStars());
            ArrayList<Integer> starIcons= new ArrayList<>();
            starIcons.add(R.id.star_one);
            starIcons.add(R.id.star_two);
            starIcons.add(R.id.star_three);
            starIcons.add(R.id.star_four);
            starIcons.add(R.id.star_five);
            for (int i = 1; i < starIcons.size() + 1; i++) {
                // Icons visibility is gone by default
                listItemView.findViewById(starIcons.get(i - 1)).setVisibility(View.GONE);
                if (i <= numberOfStars) {
                    listItemView.findViewById(starIcons.get(i - 1)).setVisibility(View.VISIBLE);
                }
            }
        } else {
            // Location is neither a hotel neither a restaurant
            TextView descriptionTextView =
                    (TextView) listItemView.findViewById(R.id.location_short_description);
            descriptionTextView.setText(currentLocation.getShortDescription());
            descriptionTextView.setTypeface(typeFaceRobotoRegular);
        }

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }
}
