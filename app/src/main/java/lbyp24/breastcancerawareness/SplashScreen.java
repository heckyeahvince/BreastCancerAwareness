package lbyp24.breastcancerawareness;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class SplashScreen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final LinearLayout splashScreen = (LinearLayout) findViewById(R.id.bg2);
        final Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        splashScreen.startAnimation(fadeIn);

        fadeIn.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        Intent toMainActivity = new Intent(SplashScreen.this,MainMenu.class);
                        startActivity(toMainActivity);
                        finish();
                    }
                }, 2000);
                //finish();
                //Intent toMainActivity = new Intent(getBaseContext(), MainActivity.class);
                //startActivity(toMainActivity);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
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
}