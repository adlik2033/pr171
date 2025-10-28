package com.example.phoyoooo;

import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Edit_Image extends AppCompatActivity {

    Bitmap selectedImage;
    ImageView photoView;
    private boolean isSaturated = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image);

        Init();
    }

    private void Init(){
        photoView = findViewById(R.id.imageView); // Ключевое исправление!
        selectedImage = MainActivity.selectedImage;
        if (selectedImage != null) {
            photoView.setImageBitmap(selectedImage);
        } else {
            // Обработка случая, когда изображение не выбрано
            finish(); // или показать сообщение
        }
    }

    public void Rotate90L(View view){
        Matrix matrix = new Matrix();
        matrix.setRotate((float) 90);
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
        matrix.setScale(1, -1, selectedImage.getWidth(), selectedImage.getHeight());
        selectedImage = Bitmap.createBitmap(selectedImage, 0, 0, selectedImage.getWidth(), selectedImage.getHeight(), matrix, false);
        photoView.setImageBitmap(selectedImage);
    }
    public void ReflectRTL(View view){
        Matrix matrix = new Matrix();
        matrix.setScale(-1, 1);
        selectedImage = Bitmap.createBitmap(selectedImage, 0, 0, selectedImage.getWidth(), selectedImage.getHeight(), matrix, false);
        photoView.setImageBitmap(selectedImage);
    }

    public void onClick(View v) {
        if (photoView.getColorFilter() == null) {
            // Включить насыщенность 50%
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.5f);
            photoView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        } else {
            // Выключить фильтр
            photoView.setColorFilter(null);
        }
    }
}
