package com.azare.app.myinventory;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListItem extends ListFragment {

    ArrayList<String> alInventory;
    ArrayAdapter<String> aaInventory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alInventory = new ArrayList<String>();

        alInventory.add("Cannon Printer");
        alInventory.add("Sony NEX 6 camera");
        alInventory.add("Apple Macbook Pro");

        aaInventory = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, alInventory);

        setListAdapter(aaInventory);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragleft,container,false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)
        {
            DetailsFragment details = (DetailsFragment) getFragmentManager()
                    .findFragmentById(R.id.fragDetails);

            details.showItem(position);
        }else {
            Intent intent = new Intent(getActivity(),DetailsActivity.class);
            intent.putExtra("index",position);
            startActivity(intent);
        }
    }
}
