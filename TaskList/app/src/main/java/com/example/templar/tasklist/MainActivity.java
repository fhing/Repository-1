package com.example.templar.tasklist;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends Activity implements View.OnClickListener{

    private ArrayList<c1> al_strings;
    private CustomAdaptater aa;

    @Override
    public void onClick(View v)
    {
        EditText et = (EditText)findViewById(R.id.et_box);
        String s = ((EditText)findViewById(R.id.et_box)).getText().toString().trim();
        if(s.isEmpty())
        {
            return;
        }
        c1 acc = new c1(s,false);
        aa.add(acc);
        et.setText("");
        aa.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        al_strings = new ArrayList<c1>();
        aa = new CustomAdaptater(this, al_strings);
        final ListView lv_mainlist = (ListView) findViewById(R.id.lv_mainlist);
        lv_mainlist.setAdapter(aa);

        final Button btn = (Button) findViewById(R.id.btn_add);
        final EditText etc =(EditText) findViewById(R.id.et_box);

        registerForContextMenu(lv_mainlist);

        lv_mainlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (parent == lv_mainlist) {
                    al_strings.remove(position);
                    aa.notifyDataSetChanged();
                    return true;
                }
                return true;
            }
        });
        aa.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
