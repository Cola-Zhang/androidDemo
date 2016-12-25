package com.example.zbk.fragment;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.example.zbk.demo.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DialogPickerFragment extends DialogFragment {

    public DialogPickerFragment() {
        // Required empty public constructor
    }


    public static DialogPickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable("dialog_date", date);
        DialogPickerFragment fragment = new DialogPickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Date date = (Date)getArguments().getSerializable("dialog_date");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);
        datePicker = (DatePicker)v.findViewById(R.id.dialog_date_id);
        datePicker.init(year, month, day, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);
        builder.setTitle("Test").setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int day = datePicker.getDayOfMonth();
                Date date = new GregorianCalendar(year, month, day).getTime();
                sendResult(Activity.RESULT_OK, date);
            }
        });
        return builder.create();
    }

    private void sendResult(int resultCode, Date date) {
        if (getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("dialog_date", date);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

    private DatePicker datePicker;
}
