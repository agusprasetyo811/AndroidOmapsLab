package com.omaps.lab;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class OmapsLab extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// IMG LOADER SAMPLE =============================================================
		// Source: http://download.androidhive.info
		
		//int loader = R.drawable.loader;
		// Imageview to show
		// ImageView image = (ImageView) findViewById(R.id.image);
		// Image url
		// String image_url =
		// "http://www.kpopstarshop.com/template/omap-ci/images/catalog/252/small_STINKOYELLOW-500x500.jpg";
		// ImageLoader class instance
		// ImageLoader imgLoader = new ImageLoader(getApplicationContext());
		// whenever you want to load an image from url
		// call DisplayImage function
		// url - image url to load
		// loader - loader image, will be displayed before getting image
		// image - ImageView
		// imgLoader.DisplayImage(image_url, loader, image);
		
		// GCM NOTIFICATION SERVICE ======================================================
		// Please enable in AndroidManfest in the <application><service android:name="com.your.packet.GCMIntentService" /></application> 
		// GCMIntentService example in com.omap.lab.notification packet

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
