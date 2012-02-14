/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.feigdev.fourcolumngv;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class FourColumnGridViewActivity extends FragmentActivity {
	private static final String TAG = "FourColumnGridView";
	private Point imgSize;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GridView g = (GridView) findViewById(R.id.myGrid);
        g.setAdapter(new ImageAdapter(this));
        
        Display display = getWindowManager().getDefaultDisplay();
        imgSize = new Point();
        imgSize.set((display.getWidth())/4, (display.getWidth())/4);
       
    }
    
    
    @Override
    public void onStart(){
    	super.onStart();
    	if (this.getIntent() != null){
    		onNewIntent(this.getIntent());
    	}
    }
    
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent called: " + intent.toString());
        Uri uri = intent.getData(); 
        if (uri != null){
        	String uriVar = uri.getQueryParameter("var");
        	if (uriVar != null){
        		Log.d(TAG, uriVar);
        	}
        }
      }
    
    public class ImageAdapter extends BaseAdapter {
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(imgSize.x,imgSize.y));
                imageView.setAdjustViewBounds(true);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(1,1,1,1);
            } else {
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);

            return imageView;
        }

        private Context mContext;

        private Integer[] mThumbIds = {
                R.drawable.sample_thumb_0, R.drawable.sample_thumb_1,
                R.drawable.sample_thumb_2, R.drawable.sample_thumb_3,
                R.drawable.sample_thumb_4, R.drawable.sample_thumb_5,
                R.drawable.sample_thumb_6, R.drawable.sample_thumb_7,
                R.drawable.sample_thumb_0, R.drawable.sample_thumb_1,
                R.drawable.sample_thumb_2, R.drawable.sample_thumb_3,
                R.drawable.sample_thumb_4, R.drawable.sample_thumb_5,
                R.drawable.sample_thumb_6, R.drawable.sample_thumb_7,
                R.drawable.sample_thumb_0, R.drawable.sample_thumb_1,
                R.drawable.sample_thumb_2, R.drawable.sample_thumb_3,
                R.drawable.sample_thumb_4, R.drawable.sample_thumb_5,
                R.drawable.sample_thumb_6, R.drawable.sample_thumb_7,
                R.drawable.sample_thumb_0, R.drawable.sample_thumb_1,
                R.drawable.sample_thumb_2, R.drawable.sample_thumb_3,
                R.drawable.sample_thumb_4, R.drawable.sample_thumb_5,
                R.drawable.sample_thumb_6, R.drawable.sample_thumb_7,
                R.drawable.sample_thumb_0, R.drawable.sample_thumb_1,
                R.drawable.sample_thumb_2, R.drawable.sample_thumb_3,
                R.drawable.sample_thumb_4, R.drawable.sample_thumb_5,
                R.drawable.sample_thumb_6, R.drawable.sample_thumb_7,
                R.drawable.sample_thumb_0, R.drawable.sample_thumb_1,
                R.drawable.sample_thumb_2, R.drawable.sample_thumb_3,
                R.drawable.sample_thumb_4, R.drawable.sample_thumb_5,
                R.drawable.sample_thumb_6, R.drawable.sample_thumb_7,
                R.drawable.sample_thumb_0, R.drawable.sample_thumb_1
        };
    }
}