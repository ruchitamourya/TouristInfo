package com.example.ruchita.touristinfoapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ruchita.touristinfoapp.Data.ImageUtils;
import com.example.ruchita.touristinfoapp.Data.InternalStorage;
import com.example.ruchita.touristinfoapp.Model.City;
import com.example.ruchita.touristinfoapp.Model.CityDetail;

import java.util.UUID;

import static android.app.Activity.RESULT_OK;

/**
 * Created by ruchita on 4/10/17.
 */

public class AddNewCityFragment extends Fragment implements View.OnClickListener {

    private static final int RESULT_LOAD_IMAGE = 1;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 0;
    private Button btn_add_img;
    private ImageView add_img;
    private Button saveData;
    private EditText cityName;
    private EditText cityDetails;
    private String imgDecodableString;
    private Bitmap bitmap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_new_city_fragment, container, false);

        add_img = (ImageView) view.findViewById(R.id.add_img);
        btn_add_img = (Button) view.findViewById(R.id.btn_add_img);
        btn_add_img.setOnClickListener(this);
        saveData = (Button) view.findViewById(R.id.btn_save);
        saveData.setOnClickListener(this);
        cityName = (EditText) view.findViewById(R.id.city_name);
        cityDetails = (EditText) view.findViewById(R.id.city_detail);
        return view;
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getActivity().getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            assert cursor != null;
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            imgDecodableString = cursor.getString(columnIndex);
            cursor.close();
            bitmap = BitmapFactory.decodeFile(imgDecodableString);
            add_img.setImageBitmap(bitmap);
        } else {
            Toast.makeText(getActivity(), "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkPermission(){
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Explain to the user why we need to read the contacts
            }

            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);

            // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
            // app-defined int constant that should be quite unique

            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // permission task you need to do.
                    openGallery();

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    btn_add_img.setVisibility(View.GONE);
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_add_img) {
            boolean permissionAlreadyGranted = checkPermission();
            if (permissionAlreadyGranted) {
                openGallery();
            }
        }else if(v.getId() == R.id.btn_save){
            boolean valid = validate();
            if(valid) {
                saveData.setOnClickListener(null);
                addCity();
                goBack();
            }
        }
    }

    private boolean validate() {
        if(cityName.getText().length() == 0 || cityDetails.getText().length() == 0 || bitmap == null){
            Toast.makeText(this.getContext(), "'City', 'About City' and 'Image' can't be empty.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void goBack() {
        FragmentManager manager = getFragmentManager();
        if(manager.getBackStackEntryCount() > 0){
            manager.popBackStack();
        }
    }

    private void addCity() {
        City city = new City();
        String id = UUID.randomUUID().toString();
        id = id.replace("-","");
        city.setCityId(id);
        city.setCityName(cityName.getText().toString());
        CityDetail cityDetail = new CityDetail();
        cityDetail.setDescription(cityDetails.getText().toString());
        city.setCityDetail(cityDetail);
        String path = ImageUtils.saveCityImage(this.getContext(), city, bitmap);
        cityDetail.setImagePath(path);
        InternalStorage.getInstance(this.getContext()).addCity(city);
    }
}
