package samples.it.sourse.com.bullsandcows;

/**
 * Created by Home on 11.07.2015.
 */
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.EditText;

public class DialogFactory implements Constants {

    protected DialogFactory() {
    }

    public static Dialog getDialogById (int id, final Context context) {
        Dialog dialog = null;
        switch (id) {
            case DIALOG_INPUT:
                dialog = createInputAlert(context);
                break;
        }
        return dialog;
    }

    private static Dialog createInputAlert(Context context) {
        final EditText editTextInputName = new EditText(context);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        final Editor edit = sharedPreferences.edit();
        Dialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        OnClickListener clickOkInputName = new OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String inputName = editTextInputName.getText().toString();
                edit.putString(KEYNAMEPLAYER, inputName);
                edit.commit();
            }
        };

        dialog = builder.setTitle(R.string.inputNewName).setPositiveButton(R.string.Ok, clickOkInputName).setView(editTextInputName).create();
        return dialog;
    }

}
