package com.example.ruchita.touristinfoapp.Data;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.ruchita.touristinfoapp.Model.City;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruchita on 21-10-2017.
 */

/*
 *Class for managing the image files.
 */
public class ImageUtils {
    /*
     *Method for getting the images from storage and assets.
     *@param context is used for getting context of related activity.
     *@param city is used for getting the city.
      */
    public static Bitmap getCityImage(Context context, City city) {
        if (city.getCityId() != null) {
            return getImageFromStorage(context, city.getCityDetail().getImagePath());
        } else {
            return getImageFromAssets(context, city.getCityName().toLowerCase(), "city.jpeg");
        }
    }

    /*
     *Method to get images from storage.
     *@param context is used for getting context of related activity.
     *@param path is used to provide path for file.
      */
    private static Bitmap getImageFromStorage(Context context, String path) {
        Bitmap bitmap = null;
        try {
            File file = new File(context.getFilesDir(), path);
            /*
             *FileInputStream inputStream = new FileInputStream(file);
             */
            bitmap = BitmapFactory.decodeFile(file.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /*
      *Method to get the images from assets.
      *@param context is used for getting context of related activity.
      *@param cityName is used to get the city name.
      *@param imageName is used to provide name of image.
     */
    private static Bitmap getImageFromAssets(Context context, String cityName, String imageName) {
        AssetManager assetManager = context.getAssets();
        Bitmap bitmap = null;
        try {
            InputStream inputStream = assetManager.open(cityName + "/" + imageName);
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    /*
     *Method to set the image according to name of the title.
     */
    public static Bitmap getFamousPlacesImage(Context context, String cityName, String title) {
        title = title.toLowerCase();
        title = title.replace(" ", "");
        title = title + ".jpeg";
        return getImageFromAssets(context, cityName.toLowerCase(), title);
    }

    /*
     *Method to fetch the images for gallery.
     */
    public static List<Bitmap> getGalleryImages(Context context, City city) {
        ArrayList<Bitmap> bitmaps = new ArrayList<>();
        if (city.getCityId() != null) {
            fetchImagesFromStorage(context, bitmaps, city.getCityId());
        } else {
            String folder = city.getCityName().toLowerCase();
            AssetManager assetManager = context.getAssets();
            try {
                String[] images = assetManager.list(folder);
                for (String path : images) {
                    InputStream inputStream = assetManager.open(folder + "/" + path);
                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    bitmaps.add(bitmap);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bitmaps;
    }

    /*
     *Method to fetch the images from storage.
     */
    private static void fetchImagesFromStorage(Context context, ArrayList<Bitmap> bitmaps, String cityId) {
        File file = new File(context.getFilesDir(), cityId);
        if (file.exists() && file.isDirectory()) {
            File[] children = file.listFiles();
            for (File file1 : children) {
                Bitmap bitmap = BitmapFactory.decodeFile(file1.getPath());
                bitmaps.add(bitmap);
            }
        }
    }

    // A method to save the cities images.
    public static String saveCityImage(Context context, City city, Bitmap bitmap) {
        String imagePath = city.getCityId() + "/city.jpeg";
        try {
            File file = new File(context.getFilesDir(), imagePath);
            file.getParentFile().mkdirs();
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath;
    }
}
