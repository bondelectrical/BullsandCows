package samples.it.sourse.com.bullsandcows;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;


public class New_Game extends Activity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        FragmentTransaction fragmentTransactionExitFragment = getFragmentManager().beginTransaction();
        NewGameFragment newGameFragment = new NewGameFragment();
        fragmentTransactionExitFragment.add(R.id.containerNewGame, newGameFragment);
        fragmentTransactionExitFragment.commit();
    }

}
