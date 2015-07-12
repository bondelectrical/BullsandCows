package samples.it.sourse.com.bullsandcows;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements Constants{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Button new_Game = (Button) findViewById(R.id.btNewGame);
        Button settings = (Button) findViewById(R.id.btSettings);
        Button score = (Button) findViewById(R.id.btScore);
        new_Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                if (sharedPreferences.contains(KEYNAMEPLAYER)) {
                    Intent intent = new Intent(MainActivity.this, New_Game.class);
                    startActivity(intent);
                } else {
                    showDialog(DIALOG_INPUT);
                }
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });

        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainApplication mainApplication = (MainApplication) getApplicationContext();

                    Intent intent = new Intent(MainActivity.this, Score.class);
                    startActivity(intent);
                }


        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        return DialogFactory.getDialogById(id, this);
    }

}
