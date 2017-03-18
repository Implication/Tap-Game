package com.example.trafe.tappydefender;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class GameActivity extends AppCompatActivity {
    private TDView gameView;
    @Override
    //This will be where play button sends us
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Get a display object to access screen details
        Display display = getWindowManager().getDefaultDisplay();
        //Load the resolution into a Point object
        Point size = new Point();
        display.getSize(size);

        //Create an instance of our Tappy Defender View
        //"this" means in this case the context of our app
        gameView = new TDView(this, size.x, size.y);

        //Make our gameview the view for the Acitivity
        setContentView(gameView);
    }

    //If the activity is paused, we have to pause our thread
    @Override
    protected  void onPause(){
        super.onPause();
        gameView.pause();
    }

    //If the Activity is resumed make sure to resume our thread
    @Override
    protected  void onResume(){
        super.onResume();
        gameView.resume();
    }
}
