package com.example.mediaplayer;

import static com.example.mediaplayer.MyApplication.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    private MediaPlayer mediaPlayer;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("My app", "My service onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            Song song = (Song) bundle.get("object_song");

            if(song!=null) {
                startMusic(song);
                sendNotification(song);
            }

        }

        return START_NOT_STICKY;
    }

    private void startMusic(Song song) {
        if(mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), song.getResource());
            if(mediaPlayer != null)
                Log.e("Start music", "Create media player");
        }
        mediaPlayer.start();
    }

    private void sendNotification(Song song) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.layout_custom_notification);
        remoteViews.setTextViewText(R.id.tv_title_song, song.getTitle());
        remoteViews.setTextViewText(R.id.tv_single_song, song.getSingle());
        remoteViews.setImageViewResource(R.id.img_song, song.getImage());
        remoteViews.setImageViewResource(R.id.img_play_or_pause, R.drawable.outline_pause_black_24);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pendingIntent)
                .setCustomContentView(remoteViews)
                .setSound(null)
                .build();

        startForeground(1, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("My app", "My service onDestroy");
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
