package com.example.boundserviceusebinderclass;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MusicBoundService extends Service {
    private MyBinder mBinder = new MyBinder();
    private MediaPlayer mMediaPlayer;

    public class MyBinder extends Binder {
        MusicBoundService getMusicBoundService(){
            return MusicBoundService.this;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MusicBoundService", "onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e("MusicBoundService", "onBind");
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("MusicBoundService", "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MusicBoundService", "onDestroy");
        if(mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public  void startMusic(){
        if(mMediaPlayer == null){
            mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
            mMediaPlayer.start();
        }
    }
}