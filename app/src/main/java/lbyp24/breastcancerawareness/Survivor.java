package lbyp24.breastcancerawareness;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


public class Survivor extends AppCompatActivity {

    private MyWebChromeClient mWebChromeClient = null;
    private View mCustomView;
    private RelativeLayout mContentView;
    private FrameLayout mCustomViewContainer;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //trylang();
      setContentView(R.layout.survivor);


//        WebView wview = (WebView) findViewById(R.id.webView);
//        wview.getSettings().setLoadWithOverviewMode(true);
//        wview.getSettings().setUseWideViewPort(true);
//        wview.loadUrl("https://m.youtube.com/watch?v=MC6O2aHHedA");

        myWebView = (WebView) findViewById(R.id.webView);
        mWebChromeClient = new MyWebChromeClient();
        myWebView.setWebChromeClient(mWebChromeClient);
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://m.youtube.com/watch?v=MC6O2aHHedA");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }
    public void trylang(){
        setContentView(R.layout.survivor);
        myWebView = (WebView) findViewById(R.id.webView);
        mWebChromeClient = new MyWebChromeClient();
        myWebView.setWebChromeClient(mWebChromeClient);
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("https://m.youtube.com/watch?v=MC6O2aHHedA");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public class MyWebChromeClient extends WebChromeClient {

        FrameLayout.LayoutParams LayoutParameters = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            // if a view already exists then immediately terminate the new one
            if (mCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }
            mContentView = (RelativeLayout) findViewById(R.id.acitivity_main);
            mContentView.setVisibility(View.GONE);
            mCustomViewContainer = new FrameLayout(Survivor.this);
            mCustomViewContainer.setLayoutParams(LayoutParameters);
            mCustomViewContainer.setBackgroundResource(android.R.color.black);
            view.setLayoutParams(LayoutParameters);
            mCustomViewContainer.addView(view);
            mCustomView = view;
            mCustomViewCallback = callback;
            mCustomViewContainer.setVisibility(View.VISIBLE);
            setContentView(mCustomViewContainer);
        }

    }

    @Override
    public void onBackPressed() {

        if (mCustomViewContainer != null)
            mWebChromeClient.onHideCustomView();

        else if (myWebView.canGoBack())
            myWebView.goBack();
        else
            super.onBackPressed();


    }

}