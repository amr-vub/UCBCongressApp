package org.ucb.ui.activity.session;

import org.ucb.ui.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;

public class ViewDocumentActivity extends Activity {
	
	WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_document);
 
		webView = (WebView) findViewById(R.id.web_doc);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://www.ucb.com");
	}
}
