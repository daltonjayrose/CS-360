package com.example.daltonrose_cs360;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.daltonrose_cs360.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.daltonrose_cs360.WeightDatabase;

public class WeightLog extends Fragment {

    private ListView listView;
    private WeightDatabase weightDB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        listView = rootView.findViewById(R.id.listView);

        weightDB = new WeightDatabase(getContext());

        Cursor cursor = weightDB.getAllData();

        String[] fromColumns = { "weight" };
        int[] toViews = { android.R.id.text1 };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getContext(),
                android.R.layout.simple_list_item_1,
                cursor,
                fromColumns,
                toViews,
                0
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cursor.moveToPosition(position);
                final long weightID = cursor.getLong(cursor.getColumnIndex("_id"));

                new AlertDialog.Builder(getContext())
                        .setTitle("Delete Entry")
                        .setMessage("Do you really want to delete this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                weightDB.deleteItem((int) weightID);

                                refreshListView();

                                Toast.makeText(getContext(), "Deleted", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton(android.R.string.no, null).show();
            }
        });

        return rootView;
    }

    private void refreshListView() {
        Cursor cursor = weightDB.getAllData();

        String[] fromColumns = { "weight" };
        int[] toViews = { android.R.id.text1 };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getContext(),
                android.R.layout.simple_list_item_1,
                cursor,
                fromColumns,
                toViews,
                0
        );

        adapter.changeCursor(cursor);
        listView.setAdapter(adapter);
    }
}