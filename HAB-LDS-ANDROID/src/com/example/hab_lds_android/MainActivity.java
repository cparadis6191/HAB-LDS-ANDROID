package com.example.hab_lds_android;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        
        Spinner select=(Spinner) findViewById(R.id.spinner1);
        
        ArrayAdapter <CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.polls, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        select.setAdapter(adapter);
        
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
           Context bluecontext=getApplicationContext();
           CharSequence blueerror="Device does not support Bluetooth.";
           int toastlength=Toast.LENGTH_LONG;
           
           Toast noblue=Toast.makeText(bluecontext, blueerror, toastlength);
           noblue.show();
        }
        
	    if (mBluetoothAdapter!=null){
	        int REQUEST_ENABLE_BT=1;
	        if (!mBluetoothAdapter.isEnabled()) {
	        	
	            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
	            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
	        }
	    }
        
        final Button send=(Button) findViewById(R.id.sendbutton);
        send.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Context sendcontext=getApplicationContext();
		        CharSequence sendmessage="Polling rate sent to device.";
		        int toastlength=Toast.LENGTH_LONG;
		          
		        Toast noblue=Toast.makeText(sendcontext, sendmessage, toastlength);
		        noblue.show();
			}
		});
        
        final Button view=(Button) findViewById(R.id.viewbutton);
        view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Context viewcontext=getApplicationContext();
		        CharSequence viewmessage="Data set displayed in textbox below (WIP).";
		        int toastlength=Toast.LENGTH_LONG;
		          
		        Toast noblue=Toast.makeText(viewcontext, viewmessage, toastlength);
		        noblue.show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
