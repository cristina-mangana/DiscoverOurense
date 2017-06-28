package com.example.android.discoverourense;

import android.content.Intent;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DetailLocationActivity extends AppCompatActivity implements OnMapReadyCallback {
    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_location);
        // Get the location
        location = getIntent().getExtras().getParcelable("location");

        //Load typefaces
        String fontPathRobotoRegular = "fonts/Roboto-Regular.ttf";
        String fontPathRobotoBold = "fonts/Roboto-Bold.ttf";
        String fontPathRobotoItalic = "fonts/Roboto-Italic.ttf";
        Typeface typeFaceRobotoRegular = Typeface.createFromAsset(getAssets(),
                fontPathRobotoRegular);
        Typeface typeFaceRobotoBold = Typeface.createFromAsset(getAssets(), fontPathRobotoBold);
        Typeface typeFaceRobotoItalic = Typeface.createFromAsset(getAssets(),
                fontPathRobotoItalic);

        //Toolbar settings
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        //Set title
        getSupportActionBar().setTitle(location.getTitle());
        //Add back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Set the image
        ImageView locationImageView = (ImageView) findViewById(R.id.toolbar_image);
        locationImageView.setImageResource(location.getImageResourceId());

        //Set the short description
        TextView shortDescriptiontextView =
                (TextView) findViewById(R.id.location_short_description);
        shortDescriptiontextView.setText(location.getShortDescription());
        shortDescriptiontextView.setTypeface(typeFaceRobotoItalic);

        //Set long description if it's available. Otherwise the textView should remain gone
        if (location.getLongDescription() != null) {
            TextView longDescriptionTextView =
                    (TextView) findViewById(R.id.location_long_description);
            longDescriptionTextView.setVisibility(View.VISIBLE);
            longDescriptionTextView.setText(location.getLongDescription());
            longDescriptionTextView.setTypeface(typeFaceRobotoRegular);
        }

        //Set the contact information if the location is a business
        if (location.hasType() | location.hasStars()) {
            TextView phoneTextView = (TextView) findViewById(R.id.phone_text);
            if (location.getPhone() != null) {
                if (!location.getPhone().equals("null")) {
                    phoneTextView.setText(location.getPhone());
                    phoneTextView.setVisibility(View.VISIBLE);
                    phoneTextView.setTypeface(typeFaceRobotoRegular);
                }
            }
            TextView mailTextView = (TextView) findViewById(R.id.mail_text);
            if (location.getMail() != null) {
                if (!location.getMail().equals("null")) {
                    mailTextView.setText(location.getMail());
                    mailTextView.setVisibility(View.VISIBLE);
                    mailTextView.setTypeface(typeFaceRobotoRegular);
                }
            }
            TextView webTextView = (TextView) findViewById(R.id.web_text);
            if (location.getWeb() != null) {
                if (!location.getWeb().equals("null")) {
                    webTextView.setText(location.getWeb());
                    webTextView.setVisibility(View.VISIBLE);
                    webTextView.setTypeface(typeFaceRobotoRegular);
                }
            }
            TextView timetableTextView = (TextView) findViewById(R.id.timetable_text);
            if (location.getTimetable() != null) {
                if (!location.getTimetable().equals("null")) {
                    timetableTextView.setText(location.getTimetable());
                    timetableTextView.setVisibility(View.VISIBLE);
                    timetableTextView.setTypeface(typeFaceRobotoRegular);
                }
            }
        }

        //Set the stars/type information
        if (location.hasType()) {
            LinearLayout typeLinearLayout = (LinearLayout) findViewById(R.id.type_layout);
            typeLinearLayout.setVisibility(View.VISIBLE);
            TextView typeTitleTextView = (TextView) findViewById(R.id.type_title);
            typeTitleTextView.setTypeface(typeFaceRobotoBold);
            String typeOfRestaurant = location.getType();
            ArrayList<String> types= new ArrayList<>();
            types.add(getString(R.string.bar_type));
            types.add(getString(R.string.restaurant_type));
            types.add(getString(R.string.tapas_type));
            types.add(getString(R.string.galician_type));
            types.add(getString(R.string.japanese_type));
            types.add(getString(R.string.grill_type));
            types.add(getString(R.string.mexican_type));
            types.add(getString(R.string.wine_type));
            types.add(getString(R.string.fast_food_type));
            types.add(getString(R.string.italian_type));
            types.add(getString(R.string.turkish_type));
            types.add(getString(R.string.american_type));
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
                if (typeOfRestaurant.toLowerCase().contains(types.get(i).toLowerCase())) {
                    findViewById(typeIcons.get(i)).setVisibility(View.VISIBLE);
                }
            }
        }
        if (location.hasStars()) {
            LinearLayout starsLinearLayout = (LinearLayout) findViewById(R.id.stars_layout);
            starsLinearLayout.setVisibility(View.VISIBLE);
            TextView starsTitleTextView = (TextView) findViewById(R.id.stars_title);
            starsTitleTextView.setTypeface(typeFaceRobotoBold);
            int numberOfStars = Integer.parseInt(location.getStars());
            ArrayList<Integer> starIcons = new ArrayList<>();
            starIcons.add(R.id.star_one);
            starIcons.add(R.id.star_two);
            starIcons.add(R.id.star_three);
            starIcons.add(R.id.star_four);
            starIcons.add(R.id.star_five);
            for (int i = 1; i < starIcons.size() + 1; i++) {
                // Icons visibility is gone by default
                if (i <= numberOfStars) {
                    findViewById(starIcons.get(i - 1)).setVisibility(View.VISIBLE);
                }
            }
        }

        //Map View using the Google Maps API:
        // https://developers.google.com/maps/documentation/android-api/
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);

        //Map and address settings
        if (location.getAddress() == null) {
            //https://stackoverflow.com/questions/13833709/
            // programmatically-set-google-map-fragment-visibility-api2
            mapFragment.getView().setVisibility(View.GONE);
        } else {
            mapFragment.getMapAsync(this);
            TextView addressTextView = (TextView) findViewById(R.id.location_address);
            addressTextView.setVisibility(View.VISIBLE);
            final String address = location.getAddress();
            //Underline and add link color
            SpannableStringBuilder spannableAddress =
                    new SpannableStringBuilder(address);
            spannableAddress.setSpan(new UnderlineSpan(), 0, address.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            int linkColor = ResourcesCompat.getColor(getResources(), R.color.colorAccent, null);
            spannableAddress.setSpan(new ForegroundColorSpan(linkColor), 0, address.length(), 0);
            spannableAddress.setSpan(new CustomTypefaceSpan(typeFaceRobotoRegular), 0,
                    address.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            addressTextView.setText(spannableAddress);
            //Add map activity. It opens the location on Google Maps App if it's
            // available on the device or else on navigator.
            addressTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://maps.google.com/maps?q=" + address));
                        startActivity(intent);
                    } catch(Exception e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://maps.google.com/maps?q=" + address)));
                    }
                }
            });
        }
    }

    // This method is called when share button is clicked
    public void share (View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.shared_text, location.getTitle(),
                getString(R.string.ourense), getString(R.string.app_name)));
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    // Handle back button on toolbar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //Set up the GoogleMap object when it's ready to be used
    @Override
    public void onMapReady(GoogleMap map) {
        // Obtain geographical coordinates from address using reverse geocoding
        // https://stackoverflow.com/questions/9698328/
        // how-to-get-coordinates-of-an-address-in-android
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        // Manage IOException when there is no address available
        try {
            List<Address> addresses = geocoder.getFromLocationName(location.getAddress(), 1);
            Address address = addresses.get(0);
            double longitude = address.getLongitude();
            double latitude = address.getLatitude();
            // Set the specific location to show initially
            // https://stackoverflow.com/questions/14157536/
            // how-do-i-set-default-location-and-zoom-level-for-google-map-api-v2
            map.moveCamera(CameraUpdateFactory
                    .newLatLngZoom(new LatLng(latitude,longitude), 18.0f));
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(latitude, longitude))
                    .title(location.getTitle())).showInfoWindow();
        } catch (IOException e) {
            Log.e("IOException", "No Address available", e);
            map.addMarker(new MarkerOptions()
                    .position(new LatLng(42.3383573, -7.8987051))
                    .title("Ourense")).showInfoWindow();
        }
    }
}
