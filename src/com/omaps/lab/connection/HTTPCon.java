package com.omaps.lab.connection;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.util.Base64;
import android.util.Log;

/**
 * (OMAPS-LAB) HTTPCon easy connection with HTTPPOST and HTTPGET
 * 
 * @author omap (agusprasetyo811@gmail.com)
 * @version 0.4.1
 * 
 */

@SuppressLint("NewApi")
public class HTTPCon {

	/**
	 * (OMAPS-LAB) Retrive data from server with GET method
	 * 
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

	/**
	 * (OMAPS-LAB) Send data to server with POST method
	 * 
	 * @param url
	 * @param nameValuePairs
	 * @return {@link String}
	 * 
	 */

	public static String POST(String url, List<? extends NameValuePair> nameValuePairs) {
		Log.i("HTTPCON", url);
		String getResponse = null;
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		// Sending to server
		try {
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = client.execute(post);
			getResponse = HTTPCon.request(response).toString();
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

	public static Bitmap DownloadImage(String URL) {
		Bitmap bitmap = null;
		InputStream in = null;
		try {
			in = OpenHttpConnection(URL);
			bitmap = BitmapFactory.decodeStream(in);
			in.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return bitmap;
	}

	public static InputStream OpenHttpConnection(String urlString) throws IOException {
		InputStream in = null;
		int response = -1;

		URL url = new URL(urlString);
		URLConnection conn = url.openConnection();

		if (!(conn instanceof HttpURLConnection))
			throw new IOException("Not an HTTP connection");

		try {
			HttpURLConnection httpConn = (HttpURLConnection) conn;
			httpConn.setAllowUserInteraction(false);
			httpConn.setInstanceFollowRedirects(true);
			httpConn.setRequestMethod("GET");
			httpConn.connect();

			response = httpConn.getResponseCode();
			if (response == HttpURLConnection.HTTP_OK) {
				in = httpConn.getInputStream();
			}
		} catch (Exception ex) {
			throw new IOException("Error connecting");
		}
		return in;
	}

	/**
	 * (OMAPS-LAB) Send Image data to server with POST method
	 * 
	 * @param url
	 * @param bitmapOrg
	 * @return {@link String}
	 * 
	 */	
	public static String UPLOADIMG(String url, Bitmap bitmapOrg) {
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		bitmapOrg.compress(Bitmap.CompressFormat.JPEG, 90, bao);

		byte[] ba = bao.toByteArray();
		String ba1 = Base64.encodeToString(ba, 0);
		ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("image", ba1));
		return POST(url, nameValuePairs);
	}
}
