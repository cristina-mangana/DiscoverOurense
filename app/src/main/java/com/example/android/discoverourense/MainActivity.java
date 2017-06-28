package com.example.android.discoverourense;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoViewPromotional = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cover title settings
        // Find the TextView
        TextView textViewCoverTitle = (TextView) findViewById(R.id.cover_title);
        // Find and build the string
        String substringCityName = getString(R.string.ourense);
        String stringCoverTitle = getString(R.string.fall_in_love, substringCityName);
        // Find the position of the city name
        // https://stackoverflow.com/questions/2615749/java-method-to-get-position-of-a-match
        // -in-a-string
        int cityNamePosition = stringCoverTitle.indexOf(substringCityName);
        // Different text size for the city name
        SpannableString spannableCoverTitle = new SpannableString(stringCoverTitle);
        spannableCoverTitle.setSpan(new RelativeSizeSpan(3.0f), cityNamePosition,
                cityNamePosition + 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Different font for the city name
        // Set the font's path
        String fontPathPermanentMarker = "fonts/PermanentMarker.ttf";
        String fontPathRobotoRegular = "fonts/Roboto-Regular.ttf";
        // Load the font as a TypeFace object
        Typeface typeFacePermanentMarker = Typeface.createFromAsset(getAssets(),
                fontPathPermanentMarker);
        Typeface typeFaceRobotoRegular = Typeface.createFromAsset(getAssets(),
                fontPathRobotoRegular);
        spannableCoverTitle.setSpan(new CustomTypefaceSpan(typeFaceRobotoRegular), 0,
                stringCoverTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableCoverTitle.setSpan(new CustomTypefaceSpan(typeFacePermanentMarker),
                cityNamePosition, cityNamePosition + 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Set custom text
        textViewCoverTitle.setText(spannableCoverTitle);

        // Playing promotional video
        playVideo();
    }

    // This helper method plays the promotional video. VideoView tutorial:
    // https://www.youtube.com/watch?v=voYDlnfcchs
    public void playVideo () {
        // Find the VideoView
        videoViewPromotional = (VideoView) findViewById(R.id.promotional_video);
        // Find the video file
        String uriPath = "android.resource://com.example.android.discoverourense/"
                + R.raw.ourense_lq;
        Uri uri = Uri.parse(uriPath);
        // Add the video file to de VideoView and play it
        videoViewPromotional.setVideoURI(uri);
        videoViewPromotional.requestFocus();
        videoViewPromotional.start();
        // When video file has finished playing, start again
        videoViewPromotional.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoViewPromotional.start();
            }
        });
    }

    // Start playing the video again after pausing and releasing media
    @Override
    protected void onResume() {
        super.onResume();
        if (videoViewPromotional == null) {
            playVideo();
        }
    }

    // This method opens List Activity when explore button is pressed
    public void explore(View view) {
        Intent openActivityList = new Intent(this, ListActivity.class);
        startActivity(openActivityList);
        // Finish this activity in order to delete it from satck when opening other activities
        finish();
    }

    // Release video resources when the activity is stopped.
    @Override
    protected void onStop() {
        super.onStop();
        // If the videoView is not null, then it may be currently playing the video.
        if (videoViewPromotional != null) {
            // Stop and release resources. Based on the VideoView.java source, stopPlayback() method
            // stops mediaPlayer, releases it and sets it as null.
            // https://stackoverflow.com/questions/15767742/android-videoview-clear-display
            // -after-stopplayback
            videoViewPromotional.stopPlayback();
            videoViewPromotional = null;
        }
    }
}
