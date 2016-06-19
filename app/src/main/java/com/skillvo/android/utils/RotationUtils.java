package com.skillvo.android.utils;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

public class RotationUtils {

    public static Bitmap rotate(int rotateAngle, Bitmap paramBitmap) {
        if (rotateAngle % 360 == 0) {
            return paramBitmap;
        }
        Matrix localMatrix = new Matrix();
        float f1 = paramBitmap.getWidth() / 2;
        float f2 = paramBitmap.getHeight() / 2;
        localMatrix.postTranslate(-paramBitmap.getWidth() / 2, -paramBitmap.getHeight() / 2);
        localMatrix.postRotate(rotateAngle);
        localMatrix.postTranslate(f1, f2);
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
        new Canvas(paramBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, null);
        return paramBitmap;
    }

    public static Bitmap rotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        float f1 = source.getWidth() / 2;
        float f2 = source.getHeight() / 2;
        matrix.postRotate(angle, f1, f2);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }

    public Bitmap roateInCenter(Bitmap paramBitmap, int rotateAngle) {
        Matrix minMatrix = new Matrix();
        //height and width are set earlier.
        Bitmap minBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas minCanvas = new Canvas(minBitmap);

        int minwidth = paramBitmap.getWidth();
        int minheight = paramBitmap.getHeight();
        int centrex = minwidth / 2;
        int centrey = minheight / 2;

        minMatrix.setRotate(rotateAngle, centrex, centrey);
        Bitmap newmin = Bitmap.createBitmap(minBitmap, 0, 0, (int) minwidth, (int) minheight, minMatrix, true);

        minCanvas.drawBitmap(newmin, (centrex - newmin.getWidth() / 2), (centrey - newmin.getHeight() / 2), null);
        minCanvas.setBitmap(minBitmap);
        return minBitmap;
    }
}
