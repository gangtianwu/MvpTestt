package com.hdsxtech.www.mvptestt;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * 作者:丁文 on 2018/4/2.
 * copyright: www.hdsxtech.com
 */

public class ImageChache {
    private LruCache<String, Bitmap> bitmapLruCache;

    public ImageChache() {
        initImageChache();
    }

    public void initImageChache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int mImageChacheSize = maxMemory / 4;

        bitmapLruCache = new LruCache<String, Bitmap>(mImageChacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {

                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }
    public void put(String url, Bitmap bitmap){
        bitmapLruCache.put(url,bitmap);
    }
    public Bitmap get(String url){
        return bitmapLruCache.get(url);
    }
}
