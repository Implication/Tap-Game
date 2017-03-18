/**
 * Created by Trajon Felton on 3/3/2017.
 */

package com.example.trafe.tappydefender;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class TDView extends SurfaceView implements  Runnable {
    volatile boolean playing;
    Thread gameThread = null;

    //Game objects
    private PlayerShip player;

    //To draw the objects
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder ourHolder;
    @Override
    public boolean onTouchEvent (MotionEvent motionEvent){
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_UP:
                player.stopBoosting();
                break;

            case MotionEvent.ACTION_DOWN:
                player.setBoosting();
                break;
        }
        return true;
    }
    public TDView(Context context, int x, int y) {
        super(context);
        //Initialize our drawing objects
        ourHolder = getHolder();
        paint = new Paint();

        //Initialize our ship
        player = new PlayerShip(context, x, y);

    }

    /**

     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        //Game loop
        //playing is a boolean that will turn false when playing is done
        while (playing) {
            //We update the status of the gmae whiel playing, then draw  the image at a new location
            //Then update the control and repeat
            update();
            draw();
            control();
        }



    }
    public void update(){
        //Update the ship
        player.update();
    }
    public void draw(){
        if (ourHolder.getSurface().isValid()) {

            //First we lock the area of memory we will be drawing to
            canvas = ourHolder.lockCanvas();

            //Rub out the last frame
            canvas.drawBitmap(
                    player.getBitmap(),
                    player.getX(),
                    player.getY(),
                    paint);

            //Unlock and draw the scene
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }
    public void control(){
        try {
            gameThread.sleep(17);
        }catch (InterruptedException e) {

        }
    }
    //Clean up the game if the game is paused or interrupted
    public void pause(){
        playing = false;
        try{
            gameThread.join();
        } catch (InterruptedException e) {

        }
    }

    //Make a new thread and start it
    //Execution moves out ot R
    public void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
}

