package com.omaps.lab.webviews;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CallBackView extends WebViewClient {

	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		return (false);
	}

}
