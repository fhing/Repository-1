package com.example.templar.tasklist;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button btn_add;
    private TextView tv_msg;
    private EditText et_box;

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        // if we get a key down event on the enter button change the text on the textview
        if (v.getId() == et_box.getId() &&
                event.getAction() == KeyEvent.ACTION_DOWN &&
                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
            tv_msg.setText(et_box.getText().toString());
            return true;
        }
        return false;
    }

    public void onClick(View v)
    {
        if(v.getId() == btn_add.getId())
            tv_msg.setText("Task added! ");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add = (Button) findViewById(R.id.btn_add);

        et_box = (EditText) findViewById(R.id.et_box);

        tv_msg = (TextView) findViewById(R.id.tv_msg);

        et_box.setOnKeyListener(this);
        btn_add.setOnClickListener(this);

        //tv_msg.setText(Click);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
