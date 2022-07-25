package com.example.wallpaperchange;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.lang.annotation.Inherited;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button changeWallPaperBtn;
    Boolean isRunning = false;
    int[] ia = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeWallPaperBtn = findViewById(R.id.changeWallPaperBtn);
        changeWallPaperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isRunning){
                    new Timer().schedule(new MyTimer(),0,3000);
                    isRunning = true;
                }
            }
        });
    }

    private class MyTimer extends TimerTask{
        @Override
        public void run(){
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
            Random random = new Random();
            try{
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),ia[random.nextInt(5)]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}