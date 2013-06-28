package com.omap.lab.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.UnknownHostException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

/**
 * HTTPCon easy connection with HTTPPOST and HTTPGET
 * 
 * @author omap (agusprasetyo811@gmail.com)
 * @version 0.4.1
 * 
 */

@SuppressLint("NewApi")
public class HTTPCon {

	/**
	 * (OMAPS-LAB) Retrive data from server with GET method 
	 * @param url
	 * @return {@link String}
	 * 
	 */
	
	public static String GET(String url) {
		Log.i("HTTPCON", url);
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		String getResponse = null;
		try {
			HttpResponse response = client.execute(request);
			getResponse = request(response).toString();
			Log.i("HTTPCON", "conect");
		} catch (UnknownHostException e) {
			getResponse = "ERROR_URL";
		} catch (ConnectException e) {
			getResponse = "TIMEOUT";
		} catch (Exception e) {
			getResponse = "ERROR_CONN";
		}
		return getResponse;
	}

	public static String request(HttpResponse response) {
		String result = "";
		try {
			InputStream is = response.getEntity().getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			StringBuilder str = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				str.append(line + "\n");
				Log.i("HTTPCON", line);
			}
			is.close();
			result = str.toString();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * (OMAPS-LAB) Set on Android 4.0 or Above
	 * 
	 */
	public static void setOnHighestSDK() {
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
	}
	
	// Utiliy method to download image from the internet
	// static private Bitmap downloadBitmap(String url) throws IOException {
	// HttpUriRequest request = new HttpGet(url);
	// HttpClient httpClient = new DefaultHttpClient();
	// HttpResponse response = httpClient.execute(request);
	//
	// StatusLine statusLine = response.getStatusLine();
	// int statusCode = statusLine.getStatusCode();
	// if (statusCode == 200) {
	// HttpEntity entity = response.getEntity();
	// byte[] bytes = EntityUtils.toByteArray(entity);
	//
	// Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0,
	// bytes.length);
	// return bitmap;
	// } else {
	// throw new IOException("Download failed, HTTP response code "
	// + statusCode + " - " + statusLine.getReasonPhrase());
	// }
	// }
}
