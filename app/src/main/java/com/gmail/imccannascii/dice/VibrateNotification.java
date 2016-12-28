package com.gmail.imccannascii.dice;

import java.lang.Thread;

import android.content.Context;
import android.os.Vibrator;


/**
 * Created by Ian on 9/28/2016.
 */

public class VibrateNotification implements Runnable {

    private Thread vibratorThread;
    private static String vibratorThreadName = "vibratorThread";
    private Context context;
    private Vibrator vibrator;
    private long[] vibratePattern = {0, 300, 100, 300, 100, 300};

    @Override
    public void run() {
        if (vibrator != null) {
            if (vibrator.hasVibrator()) {
                vibrator.vibrate(vibratePattern, -1);

            }
        }
    }


    public void start() {
        if (vibratorThread == null) {
            vibratorThread = new Thread(this, vibratorThreadName);
            vibratorThread.start();
        }
    }

    public void setContext(Context sourceContext) {
        context = sourceContext;
        setVibrator();
    }

    private void setVibrator() {
        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

}
