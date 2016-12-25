package com.example.zbk.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;



public class DialogPickerFragment extends DialogFragment {

    public DialogPickerFragment() {
        // Required empty public constructor
    }


    public static DialogPickerFragment newInstance() {
        DialogPickerFragment fragment = new DialogPickerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Test").setPositiveButton(android.R.string.ok, null);
        return builder.create();
    }
}
