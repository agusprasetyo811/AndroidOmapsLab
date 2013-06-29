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
	
	// EXAMPLE OF ENABLED GCM

	// public void registerGCM() {
	// GCMRegistrar.checkDevice(this);
	// GCMRegistrar.checkManifest(this);
	//
	// final String regId = GCMRegistrar.getRegistrationId(this);
	// System.out.println("REGISTER ID==" + regId);
	//
	// if (regId.equals("")) {
	// GCMRegistrar.register(getApplicationContext(), Config.API_DEVICE_ID);
	// System.out.println("REGISTER IN PROGRESS");
	// } else {
	// System.out.println("REGISTERD");
	// }
	// }
	//
	// public void unRegisterGCM() {
	// GCMRegistrar.unregister(this);
	// }
}
