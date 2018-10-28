package hu.bme.aut.workplaceapp;

import android.app.DatePickerDialog;
import android.app.Dialog;

import android.content.Context;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by mobsoft on 2017. 09. 27..
 */

public class DatePickerDialogFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    private OnDateSelectedListener onDateSelectedListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (!(context instanceof OnDateSelectedListener)) {
            throw new RuntimeException("The activity does not implement the" +
                    "OnDateSelectedListener interface");
        }

        onDateSelectedListener = (OnDateSelectedListener) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this,
                year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        onDateSelectedListener.onDateSelected(year, month, day);
    }

    public interface OnDateSelectedListener {
        void onDateSelected(int year, int month, int day);
    }
}
