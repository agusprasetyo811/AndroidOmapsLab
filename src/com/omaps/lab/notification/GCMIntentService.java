package com.omaps.lab.notification;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;

public class GCMIntentService extends GCMBaseIntentService {

	public GCMIntentService() {
		super("972564378948");
	}

	@Override
	protected void onRegistered(Context arg0, String registrationId) {
		Log.i("OMAPS-LAB NOTIF", "Device registered: regId = " + registrationId);
		// GENERATE TRIGGER NOTIFICATION HERE
	}

	@Override
	protected void onUnregistered(Context arg0, String arg1) {
		Log.i("OMAPS-LAB NOTIF", "unregistered = " + arg1);
	}

	@Override
	protected void onMessage(Context context, Intent intent) {
		String message = intent.getExtras().getString("message");
		Log.i("OMAPS-LAB NOTIF", "new message= " + message);
		generateNotification(context, message);
	}

	@Override
	protected void onError(Context arg0, String errorId) {
		Log.i("OMAPS-LAB NOTIF", "Received error: " + errorId);
	}

	@Override
	protected boolean onRecoverableError(Context context, String errorId) {
		return super.onRecoverableError(context, errorId);
	}

	private static void generateNotification(Context context, String message) {

		// String getMessage = "NEW NOTIFICATION";
		// int icon = R.drawable.ic_launcher;
		// long when = System.currentTimeMillis();
		// NotificationManager notificationManager = (NotificationManager)
		// context.getSystemService(Context.NOTIFICATION_SERVICE);
		// Notification notification = new Notification(icon, getMessage, when);
		// String title = context.getString(R.string.app_name);

		// Intent notificationIntent = new Intent(context, ListGallery.class);
		// set intent so it does not start a new activity
		// notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
		// Intent.FLAG_ACTIVITY_SINGLE_TOP);
		// PendingIntent intent = PendingIntent.getActivity(context, 0,
		// notificationIntent, 0);
		// notification.setLatestEventInfo(context, title, getMessage, intent);
		// notification.flags |= Notification.FLAG_AUTO_CANCEL;

		// Play default notification sound
		// notification.defaults |= Notification.DEFAULT_SOUND;

		// Vibrate if vibrate is enabled
		// notification.defaults |= Notification.DEFAULT_VIBRATE;
		// notificationManager.notify(0, notification);

	}
}
