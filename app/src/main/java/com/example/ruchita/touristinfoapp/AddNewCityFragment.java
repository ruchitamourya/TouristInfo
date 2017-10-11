package com.example.ruchita.touristinfoapp;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;

/**
 * Created by ruchita on 4/10/17.
 */

public class AddNewCityFragment extends Fragment {

    private static final int RESULT_LOAD_IMAGE = 1;
    private Button btn_add_img;
    private ImageView add_img;
    private String imgDecodableString;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_new_city_fragment, container, false);

        add_img = (ImageView) view.findViewById(R.id.add_img);
        btn_add_img = (Button) view.findViewById(R.id.btn_add_img);
        btn_add_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });
        return view;
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
//            assert cursor != null;
//            cursor.moveToFirst();
//
//            int colunmIndex = cursor.getColumnIndex(filePathColumn[0]);
//            imgDecodableString = cursor.getString(colunmIndex);
//            cursor.close();
//
//            add_img.setImageBitmap(BitmapFactory.decodeFile(imgDecodableString));
//        } else {
//            Toast.makeText(getActivity(), "You haven't picked Image", Toast.LENGTH_LONG).show();
//        }
//    }


    @Override
    public void onResume() {
        super.onResume();
    }
}
