package com.deitel.cannonball;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class CannonGame extends AppCompatActivity {

    private CannonView cannonView;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannon_game);

        cannonView = (CannonView) findViewById(R.id.cannonView);

        gestureDetector = new GestureDetector(this, gestureListener);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    protected void onPause() {
        super.onPause();
        cannonView.stopGame();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cannonView.releaseResources();
    }

    GestureDetector.SimpleOnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener(){
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            // TODO: 18-03-16 fire
            return true;

        }
    };


}
