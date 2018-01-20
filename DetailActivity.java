package code.convert.com.workshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        String wikiPath = "";

        if (extras != null) {
            wikiPath = extras.getString("wiki");
        }

        WebView wv = (WebView) findViewById(R.id.wvWiki);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(wikiPath);
    }
}
