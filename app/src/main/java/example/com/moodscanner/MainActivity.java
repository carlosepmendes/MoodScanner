package example.com.moodscanner;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Handler;


public class MainActivity extends ActionBarActivity {

    private ImageView thumbPrint;
    private TextView result;
    private AnimationDrawable thumbAnimation;
    private String[] moodResults;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodResults = new String[]{
                "Someone is cranky!",
                "You are my sunshyne!",
                "No comments...",
                "You're stressed out!",
                "Happy camper ;)",
                "Not your day :(",
                "Smile - it's good for you",
                "In the clouds...",
                "Passive",
                "Sad",
                "Excited!"
        };

        thumbPrint = (ImageView) findViewById(R.id.thumbPrint);
        thumbPrint.setBackgroundResource(R.drawable.thumb_animation);
        thumbAnimation = (AnimationDrawable)thumbPrint.getBackground();

        result = (TextView) findViewById(R.id.resultText);

        thumbPrint.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                thumbAnimation.start();
                showResult();
                //Toast.makeText(getApplicationContext(), "Hellooooo there", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    public void showResult(){
        mRunnable = new Runnable() {
            @Override
            public void run() {
                int rand = (int) (Math.random() * moodResults.length);
                result.setText(moodResults[rand]);

                //stop animation
                thumbAnimation.stop();
            }
        };

        android.os.Handler mHandler = new android.os.Handler();
        mHandler.postDelayed(mRunnable, 5000); // 5 seconds

    }

}
