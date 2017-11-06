package com.example.ruchita.touristinfoapp.Data;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Ruchita on 5/11/17.
 */

public class ExternalStorage extends FileDataProvider {
    private static String filepath = "MyFileStorage";

    private ExternalStorage(Context context) {
        super(context);
    }

    public static FileDataProvider getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ExternalStorage(context.getApplicationContext());
        }
        return mInstance;
    }

    @Override
    protected FileOutputStream openFileOutput() throws FileNotFoundException {
        if (isExternalStorageWritable()) {
            File myExternalFile = new File(mContext.getExternalFilesDir(filepath), CITY_FILE);
            FileOutputStream outputStream = new FileOutputStream(myExternalFile);
            return outputStream;
        } else {
            return null;
        }
    }

    @Override
    protected FileInputStream getFileInputStream() throws FileNotFoundException {
        if (isExternalStorageWritable() || isExternalStorageReadOnly()) {
            File myExternalFile = new File(mContext.getExternalFilesDir(filepath), CITY_FILE);
            FileInputStream fis = new FileInputStream(myExternalFile);
            return fis;
        } else {
            return null;
        }
    }

    /*
     *Checks if external storage is available for read and write.
      */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }
}
