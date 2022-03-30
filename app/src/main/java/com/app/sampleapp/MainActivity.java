package com.app.sampleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.resonai.VeraConfiguration;
import com.resonai.common.helpers.Languages;

public class MainActivity extends AppCompatActivity {


    private static final int MY_REQUEST_CODE = 100;
    String[] permissions =new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStart).setOnClickListener(view -> checkPermissions());
    }


    private void openVeraScreen() {

        VeraConfiguration.Builder()
                .setClientAppID("vera_client_app")
                .setLanguage(Languages.EN)
                .startWithoutLogin(this);


    }


    private void checkPermissions(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            boolean allPermissions=true;

            for (String per :permissions) {
                allPermissions = allPermissions && (checkSelfPermission(per) == PackageManager.PERMISSION_GRANTED);
            }

            if (!allPermissions) {
                requestPermissions(permissions, MY_REQUEST_CODE);
            }else {
                openVeraScreen();
            }

        }else {
            openVeraScreen();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openVeraScreen();
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }



}