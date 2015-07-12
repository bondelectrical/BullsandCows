package samples.it.sourse.com.bullsandcows;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Settings extends Activity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btnNewName = (Button) findViewById(R.id.btnNewPlayer);
        Button btnRules = (Button) findViewById(R.id.btnRules);
        Button btnSetingExit = (Button) findViewById(R.id.btnSettingExit);

        btnNewName.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog(DIALOG_INPUT);
            }
        });

        btnRules.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                MyFragment myFragment = new MyFragment();
                fragmentTransaction.add(R.id.container, myFragment);
                fragmentTransaction.commit();

            }
        });

        btnSetingExit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        return DialogFactory.getDialogById(id, this);
    }

    class MyFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            return inflater.inflate(R.layout.rulesfragment, null);
        }

    }

}