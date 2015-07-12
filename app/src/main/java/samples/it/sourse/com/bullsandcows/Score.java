package samples.it.sourse.com.bullsandcows;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Score extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MainApplication mainApplication = (MainApplication) getApplicationContext();
        Cursor cursor = mainApplication.db.getAllData();
        startManagingCursor(cursor);
        String[] from = new String[] {mainApplication.db.COLUMN_NAME_PLAYER,
                mainApplication.db.COLUMN_NUMBER_COWS,
                mainApplication.db.COLUMN_NUMBER_BULL,};
        int[] to = new int[] {R.id.txtLvNamePlayer,
                R.id.txtLvCows, R.id.txtLvBull};
        SimpleCursorAdapter scAdapterStory = new SimpleCursorAdapter(this,
                R.layout.item_story, cursor, from, to);
        ListView lvStory = (ListView) findViewById(R.id.lvStory);
        lvStory.setAdapter(scAdapterStory);
    }

}
