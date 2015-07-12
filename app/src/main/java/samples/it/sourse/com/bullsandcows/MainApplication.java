package samples.it.sourse.com.bullsandcows;

/**
 * Created by Home on 11.07.2015.
 */
import android.app.Application;


public class MainApplication extends Application {
    DB db;
    @Override
    public void onCreate() {
        super.onCreate();
        db = new DB(getApplicationContext());
        db.open();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        db.close();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        db.close();
    }

}