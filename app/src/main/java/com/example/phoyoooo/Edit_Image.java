package com.example.phoyoooo;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Edit_Image extends AppCompatActivity {

    Bitmap selectedImage;
    ImageView photoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image);

        Init();
    }

    private void Init(){
        ImageView photo = findViewById(R.id.imageView);
        selectedImage = MainActivity.selectedImage;
        photo.setImageBitmap(MainActivity.selectedImage);
    }

    public void Rotate90L(View view){
        Matrix matrix = new Matrix();
        matrix.setRotate((float) 90);
        selectedImage = Bitmap.createBitmap(selectedImage, 0, 0, selectedImage.getWidth(), selectedImage.getHeight(), matrix, false);
        photoView.setImageBitmap(selectedImage);
    }

    public void ReflectRTL(View view){
        Matrix matrix = new Matrix();
        matrix.setScale(-1, 1);
        selectedImage = Bitmap.createBitmap(selectedImage, 0, 0, selectedImage.getWidth(), selectedImage.getHeight(), matrix, false);
        photoView.setImageBitmap(selectedImage);
    }
    public void Rotate90R(View view){
        Matrix matrix = new Matrix();
        matrix.setRotate((float) 270);
        selectedImage = Bitmap.createBitmap(selectedImage, 0, 0, selectedImage.getWidth(), selectedImage.getHeight(), matrix, false);
        photoView.setImageBitmap(selectedImage);
    }

    public void ReflectTTB(View view){
        Matrix matrix = new Matrix();
        matrix.setScale(-1f, 1f, selectedImage.getWidth(), selectedImage.getHeight());
        selectedImage = Bitmap.createBitmap(selectedImage, 0, 0, selectedImage.getWidth(), selectedImage.getHeight(), matrix, false);
        photoView.setImageBitmap(selectedImage);
    }
}