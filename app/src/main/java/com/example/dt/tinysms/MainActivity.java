package com.example.dt.tinysms;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.telephony.SmsManager;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText phoneNumber = (EditText)findViewById(R.id.editText);
        final EditText messageContext = (EditText)findViewById(R.id.editText2);
        final Button button =(Button)findViewById(R.id.button);
       // button.getBackground().setAlpha(100);
       // button.setBackgroundColor(Color.TRANSPARENT);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=phoneNumber.getText().toString();
                String message=messageContext.getText().toString();
                SmsManager manager =SmsManager.getDefault();
                ArrayList<String> texts=manager.divideMessage(message);

                if(phone.length()>0 && message.length()>0)
                {
                    for(String temp:texts)
                    manager.sendTextMessage(phone,null,temp,null,null);
                    Toast.makeText(MainActivity.this,"send OK!",Toast.LENGTH_LONG).show();
                }
                else {
                   Toast.makeText(MainActivity.this,"invalid input!",Toast.LENGTH_LONG).show();
                }
            }
        });
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
