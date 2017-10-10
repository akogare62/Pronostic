package com.example.jacqu.pronostics;

import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Tab2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tableau2);

        String[] columns = new String[]{"_id", "col1", "col2", "col3", "col4"};

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        startManagingCursor(matrixCursor);

        matrixCursor.addRow(new Object[]{1, "col1:ligne1", "col2:ligne1", "col3:ligne1", "col4:ligne1"});
        matrixCursor.addRow(new Object[]{2, "col1:ligne2", "col2:ligne2", "col3:ligne2", "col4:ligne2"});
        String[] from = new String[]{"col1", "col2", "col3", "col4"};
        int[] to = new int[]{R.id.textViewCol1, R.id.textViewCol2, R.id.textViewCol3, R.id.textViewCol4};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.ligne_tableau2, matrixCursor, from, to, 0);
        ListView lv = (ListView) findViewById(R.id.lv2);
        LayoutInflater layoutinflater = getLayoutInflater();

        ViewGroup header = (ViewGroup)layoutinflater.inflate(R.layout.titre_tableau2,lv,false);

        lv.addHeaderView(header);
        lv.setAdapter(adapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View container, int position, long id) {
                Log.d("mydebug", "clic sur id:" + id);
            }
        };

        lv.setOnItemClickListener(itemClickListener);
    }
}
