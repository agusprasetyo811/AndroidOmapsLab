package com.omaps.lab;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/**
 * @author omap (agusprasetyo811@gmail.com)
 * 
 */
public class OmapsLab extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**
		 * ====================================================================
		 * WELCOME TO OMAPS-LAB *
		 * ====================================================================
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
