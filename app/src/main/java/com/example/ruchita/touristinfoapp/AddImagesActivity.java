package com.example.ruchita.touristinfoapp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class AddImagesActivity extends AppCompatActivity {

    private String imgDecodableString;
    private static final int RESULT_LOAD_IMAGE = 1;
    private ImageView add_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_images);
        add_img = (ImageView)findViewById(R.id.add_img);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = this.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            assert cursor != null;
            cursor.moveToFirst();

            int colunmIndex = cursor.getColumnIndex(filePathColumn[0]);
            imgDecodableString = cursor.getString(colunmIndex);
            cursor.close();

            add_img.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
        } else {
            Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }

}
