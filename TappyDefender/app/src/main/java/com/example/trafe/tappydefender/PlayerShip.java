package com.example.trafe.tappydefender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

/**
 * Created by Trajon Felton on 3/3/2017.
 */

public class PlayerShip {
    private Bitmap bitmap;
    private int x, y;
    private int speed = 0;

    //Constructor
    public PlayerShip(Context context){
        x = 50;
        y = 50;
        speed = 1;
        //This represents the appearance of the ship
        //To load bitmaps, we need to receive a context object from android
        //drawable ship is the name of the image we want to appear on the screen
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ship);
    }

    public void update() {
        x++;
    }

    //Getters
    public Bitmap getBitmap(){
        return bitmap;
    }
    public int getSpeed(){
        return speed;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
