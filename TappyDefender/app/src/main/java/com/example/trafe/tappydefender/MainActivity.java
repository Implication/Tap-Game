package com.example.trafe.tappydefender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//This is the entry point to the game
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Here we are setting our home screen as the view page
        setContentView(R.layout.activity_main);

        //Get a reference to our play button
        final Button btnPlay = (Button) findViewById(R.id.btnPly);

        //Listen for clicks
        btnPlay.setOnClickListener(this);
    }

    /**
     Called when the play button is clicked
     */
    @Override
    public void onClick(View v) {
        //Intent is used to switch between activity's(Or views in this case
        //GameActivity is where the activity of the game will take place
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
        finish();
    }
}
