package com.gmail.imccannascii.dice;

import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.content.Context;

import java.io.IOException;

/**
 * Created by Ian on 9/28/2016.
 */

public class AudioNotification implements Runnable {

    private Thread audioThread;
    private static String audioThreadName = "audioThread";
    private Context context;
    private Resources resources;
    private AudioManager audioManager;
    private MediaPlayer player;

    @Override
    public void run() {
        int answer = audioManager.requestAudioFocus(onAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

        if (answer == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setVolume(1, 1);
            player.start();
            while (player.isPlaying() == true) {

            }
            player.stop();
            player.release();
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
    }

    public void start() {
        if (audioThread == null) {
            audioThread = new Thread(this, audioThreadName);
            audioThread.start();
        }
    }

    public void setContext(Context sourceContext) {
        context = sourceContext;
        setUpAudioNotifier();
    }

    private void setUpAudioNotifier() {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        player = MediaPlayer.create(context, R.raw.crtihit);
    }

    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {

        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {

                case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                    break;
            }
        }
    };
}
