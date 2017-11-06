package com.example.ruchita.touristinfoapp.Data;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by chandan on 5/11/17.
 */

public class InternalStorage extends FileDataProvider {
    private InternalStorage(Context context) {
        super(context);
    }

    @Override
    protected FileOutputStream openFileOutput() throws FileNotFoundException {
        return mContext.openFileOutput(CITY_FILE, Context.MODE_PRIVATE);
    }

    @Override
    protected FileInputStream getFileInputStream() throws FileNotFoundException {
        return mContext.openFileInput(CITY_FILE);
    }

    /*

     */
    public static FileDataProvider getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new InternalStorage(context.getApplicationContext());
        }
        return mInstance;
    }

}
