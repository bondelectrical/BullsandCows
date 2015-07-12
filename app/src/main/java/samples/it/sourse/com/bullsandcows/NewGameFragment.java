package samples.it.sourse.com.bullsandcows;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Home on 11.07.2015.
 */
public class NewGameFragment extends Fragment implements View.OnClickListener, Constants {

    TextView tvAttempt;
    TextView tvBull;
    TextView tvCows;
    TextView tvResult;

    ArrayList<Integer> result;

    Button btnNumber0;
    Button btnNumber1;
    Button btnNumber2;
    Button btnNumber3;
    Button btnNumber4;
    Button btnNumber5;
    Button btnNumber6;
    Button btnNumber7;
    Button btnNumber8;
    Button btnNumber9;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_namber, null);

        result = new ArrayList<>();

        tvAttempt = (TextView) getActivity().findViewById(R.id.tvAttempt);
        tvBull = (TextView) getActivity().findViewById(R.id.tvBull);
        tvCows = (TextView) getActivity().findViewById(R.id.tvCows);
        tvResult = (TextView) getActivity().findViewById(R.id.tvResult);

        btnNumber0 = (Button) v.findViewById(R.id.btn0);
        btnNumber1 = (Button) v.findViewById(R.id.btn1);
        btnNumber2 = (Button) v.findViewById(R.id.btn2);
        btnNumber3 = (Button) v.findViewById(R.id.btn3);
        btnNumber4 = (Button) v.findViewById(R.id.btn4);
        btnNumber5 = (Button) v.findViewById(R.id.btn5);
        btnNumber6 = (Button) v.findViewById(R.id.btn6);
        btnNumber7 = (Button) v.findViewById(R.id.btn7);
        btnNumber8 = (Button) v.findViewById(R.id.btn8);
        btnNumber9 = (Button) v.findViewById(R.id.btn9);

        btnNumber0.setOnClickListener(this);
        btnNumber0.setEnabled(false);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btn0):{
                result.add(0);
                btnNumber0.setEnabled(false);
                break;
            }
            case (R.id.btn1): {
                result.add(1);
                btnNumber1.setEnabled(false);
                break;
            }
            case (R.id.btn2):{
                result.add(2);
                btnNumber2.setEnabled(false);
                break;
            }
            case (R.id.btn3): {
                result.add(3);
                btnNumber3.setEnabled(false);
                break;
            }
            case (R.id.btn4):{
                result.add(4);
                btnNumber4.setEnabled(false);
                break;
            }
            case (R.id.btn5): {
                result.add(5);
                btnNumber5.setEnabled(false);
                break;
            }
            case (R.id.btn6):{
                result.add(6);
                btnNumber6.setEnabled(false);
                break;
            }
            case (R.id.btn7): {
                result.add(7);
                btnNumber7.setEnabled(false);
                break;
            }
            case (R.id.btn8):{
                result.add(8);
                btnNumber8.setEnabled(false);
                break;
            }
            case (R.id.btn9): {
                result.add(9);
                btnNumber9.setEnabled(false);
                break;
            }
        }

        tvResult.setText(outputResult());
        if (result.size() == 1) {
            btnNumber0.setEnabled(true);
        }

        if (result.size() > 3) {
            Integer[] resultCowsandBull = Logik.rezultRandom(result);

            tvCows.setText(Integer.toString(resultCowsandBull[0]));
            tvBull.setText(Integer.toString(resultCowsandBull[1]));

            tvAttempt.setText(R.string.rezult);

            MainApplication mainApplication = (MainApplication) getActivity().getApplicationContext();
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
            String name = sharedPreferences.getString(KEYNAMEPLAYER, "");
            mainApplication.db.add(name, resultCowsandBull[0], resultCowsandBull[1]);

            FragmentTransaction fragmentTransactionExitFragment = getActivity().getFragmentManager().beginTransaction();
            ExitFragment exitFragment = new ExitFragment();
            fragmentTransactionExitFragment.replace(R.id.containerNewGame, exitFragment);
            fragmentTransactionExitFragment.commit();
        }
    }

    private String outputResult() {
        String str;
        int tempResult = 0;
        switch (result.size()) {
            case (1): {
                tempResult = result.get(0);
                break;
            }
            case (2): {
                tempResult = result.get(0)*10 + result.get(1);
                break;
            }
            case (3): {
                tempResult = result.get(0)*100 + result.get(1)*10 + result.get(2);
                break;
            }
            case(4): {
                tempResult = result.get(0)*1000 + result.get(1)*100 + result.get(2)*10 + result.get(3);
                break;
            }
        }
        str = Integer.toString(tempResult);
        return str;
    }


}
