package pers.lbreak.bitmapdemo;

import android.graphics.drawable.LevelListDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageView img_show;
    private ImageView img_show2;
    private LevelListDrawable ld;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                if (ld.getLevel() > 10000) ld.setLevel(0);
                img_show.setImageLevel(ld.getLevel() + 2000);
//                try {
//                    Thread.sleep(1200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_show = (ImageView) findViewById(R.id.img_show);
        ld = (LevelListDrawable) img_show.getDrawable();
        img_show.setImageLevel(0);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 100);



        img_show2 = (ImageView) findViewById(R.id.img_show2);
        TransitionDrawable td = (TransitionDrawable) img_show2.getDrawable();
        td.startTransition(3000);
    }
}
