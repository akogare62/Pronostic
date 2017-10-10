package com.example.jacqu.pronostics;


import android.database.MatrixCursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.LayoutInflater;

public class TabActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tableau);


        String[] columns = new String[]{"_id", "col1", "col2"};

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        startManagingCursor(matrixCursor);

        matrixCursor.addRow(new Object[]{1, "col1:ligne1", "col2:ligne1"});
        matrixCursor.addRow(new Object[]{2, "col1:ligne2", "col2:ligne2"});
        String[] from = new String[]{"col1", "col2"};
        int[] to = new int[]{R.id.textViewCol1, R.id.textViewCol2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.ligne_tableau, matrixCursor, from, to, 0);
        ListView lv = (ListView) findViewById(R.id.lv);
        LayoutInflater layoutinflater = getLayoutInflater();

        ViewGroup header = (ViewGroup)layoutinflater.inflate(R.layout.titre_tableau,lv,false);

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
