package com.example.textutils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageUrlActivity extends AppCompatActivity {

    String imageUrl;
    EditText imageUrlTxt;
    ImageView imageImg;
    Button previewBtn;
    ImageButton leftRotateBtn;
    ImageButton rightRotateBtn;
    Button flipHorizontalBtn;
    Button flipVerticalBtn;
    int angle = 0;
    int scaleX = 1;
    int scaleY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_url);
        getSupportActionBar().setTitle("Image Utils");
        //getSupportActionBar().hide();
        //getSupportActionBar().show();
        previewBtn = findViewById(R.id.preview_btn);
        imageUrlTxt = findViewById(R.id.image_url_txt);
        imageUrl = imageUrlTxt.getText().toString();
        imageImg = findViewById(R.id.image_img);
        leftRotateBtn = findViewById(R.id.left_rotate_btn);
        rightRotateBtn = findViewById(R.id.right_rotate_btn);
        flipHorizontalBtn = findViewById(R.id.flip_horizontal_btn);
        flipVerticalBtn = findViewById(R.id.flip_vertical_btn);
        handlePreviewBtn();
        handleRotateLeft();
        handleRotateRight();
        handleFlipHorizontal();
        handleFlipVertical();
    }

    public void handlePreviewBtn() {
        previewBtn.setOnClickListener(view -> {
            angle = 0;
            scaleX = 1;
            scaleY = 1;
            imageImg.setScaleX(scaleX);
            imageImg.setScaleY(scaleY);
            imageUrl = imageUrlTxt.getText().toString();
            Picasso.get().load(imageUrl).into(imageImg);
        });
    }

    public void handleRotateLeft() {
        leftRotateBtn.setOnClickListener(view -> {
            angle = angle + (scaleX * scaleY * -90);
            Picasso.get().load(imageUrl).rotate(angle).into(imageImg);
        });
    }

    public void handleRotateRight() {
        rightRotateBtn.setOnClickListener(view -> {
            angle = angle + (scaleX * scaleY * 90);
            Picasso.get().load(imageUrl).rotate(angle).into(imageImg);
        });
    }

    public void handleFlipHorizontal() {
        flipHorizontalBtn.setOnClickListener(view -> {
            scaleX = scaleX * -1;
            imageImg.setScaleX(scaleX);
        });
    }

    public void handleFlipVertical() {
        flipVerticalBtn.setOnClickListener(view -> {
            scaleY = scaleY * -1;
            imageImg.setScaleY(scaleY);
        });
    }
}