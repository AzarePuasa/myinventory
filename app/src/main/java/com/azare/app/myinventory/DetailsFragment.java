package com.azare.app.myinventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DetailsFragment extends Fragment {
    int index = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent launchingIntent = getActivity().getIntent();

        index = launchingIntent.getIntExtra("index", -1);

        return inflater.inflate(R.layout.details,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        if(index > -1)
        {
            showItem(index);
        }
        else
        {
            Button btnDone = (Button) getActivity().findViewById(R.id.buttonDone);

            if(btnDone != null) {
                btnDone.setVisibility(View.GONE);
            }
        }

        super.onActivityCreated(savedInstanceState);
    }

    public void showItem(int index) {
        String[] note = {"This is Note 1","This is Note 2","This is Note 3"};

        EditText etNote = (EditText) this.getActivity().findViewById(R.id.editTextNote);

        etNote.setText(note[index]);
    }
}
