package com.hdsxtech.www.mvptestt;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作者:丁文 on 2018/4/2.
 * copyright: www.hdsxtech.com
 */

public class ImageLoader {

    ImageChache imageChache = new ImageChache();
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ImageLoader() {

    }


    private void displayImage(final String url, final ImageView imageView) {
        imageView.setTag(url);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
            Bitmap bitmap = downloadImage(url);
            if (bitmap == null){
                return;
            }
            if (imageView.getTag().equals(url)){
                imageView.setImageBitmap(bitmap);
            }
            imageChache.put(url,bitmap);
            }
        });
    }

    private Bitmap downloadImage(String url) {
        Bitmap bitmap = null;
        try {
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
             bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
