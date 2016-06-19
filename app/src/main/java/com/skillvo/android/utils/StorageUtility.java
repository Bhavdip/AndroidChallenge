package com.skillvo.android.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageUtility {
    public final static String TAG = "StorageUtility";

    public static void cacheImageView(Bitmap image, String fileName, Context context) {
        File pictureFile = getOutputMediaFile(fileName, context);
        if (pictureFile == null) {
            Log.d(TAG, "Error creating media file, check storage permissions: ");// e.getMessage());
            return;
        }
        try {
            FileOutputStream fos = new FileOutputStream(pictureFile);
            image.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (FileNotFoundException e) {
            Log.d(TAG, "File not found: " + e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, "Error accessing file: " + e.getMessage());
        }
    }


    /**
     * Create a File for saving an image or video
     */
    public static File getOutputMediaFile(String fileName, Context context) {
        File mediaStorageDir = new File(Environment.getExternalStorageDirectory() + "/Android/data/" + context.getPackageName() + "/Files");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }
        return new File(mediaStorageDir.getPath() + fileName);
    }
}
