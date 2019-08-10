package com.miles.inches;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;

public class MainActivity extends Activity {

	Bluetooth bt;
	Button connectbt;
	boolean conoff = true; // Records if connection is open or closed
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Link button to Button defined in activity_main.xml
		// connectbt = (Button) findViewById(R.id.connectbut);
		connectbt = (Button) findViewById(R.id.connectbt);

		// Create an instance of the Bluetooth class defined in Bluetooth.java
		bt = new Bluetooth(getApplicationContext(), this);
	}

	public void connectPressed(View view) throws IOException {
		// If Bluetooth Device could not be found then quit

		if(bt.findBT() == -1) {
            return;
        }
		
        if (conoff) {
        // Attempt open a Bluetooth connection
        try {
            bt.openBT();
            Button connection = (Button) findViewById(R.id.connectbt);
    		connection.setText("Close BT connection");
        } catch (IOException e) {
            e.printStackTrace();
        }
        } else { // Close Bluetooth connection
        	bt.closeBT();
        	Button connection = (Button) findViewById(R.id.connectbt);
    		connection.setText("Connect to BT");
        }
        
        conoff = !conoff;

        // Start listening for Bluetooth data from the Teensy
        //bt.beginListenForData();
    }
	
	public void killPressed(View view) throws IOException {
		try {
			byte kill = (byte) 0b00000000;
			bt.sendData(kill);
			
			Toast toast = Toast.makeText(this, "Kill sent..", Toast.LENGTH_LONG);
			toast.show();
			
		} catch (Exception e) {
			Log.e("7inches", "Hit killPressed");
		}
	}
    
	public void forwardPressed(View view) throws IOException {
		try {
			byte forw = (byte) 0b00001010;
			bt.sendData(forw);
			
			Toast toast = Toast.makeText(this, "Forward sent..", Toast.LENGTH_LONG);
			toast.show();
			
		} catch (Exception e) {
			Log.e("7inches", "Hit forward");
		}
	}
	
	public void backwardPressed(View view) throws IOException {
		try {
			byte back = (byte) 0b00000101;
			bt.sendData(back);
			
			Toast toast = Toast.makeText(this, "Backward sent..", Toast.LENGTH_LONG);
			toast.show();
			
		} catch (Exception e) {
			Log.e("7inches", "Hit backward");
		}
	}

	public void rightSpinPressed(View view) throws IOException {
		try {
			byte rspin = (byte) 0b00001001;
			bt.sendData(rspin);
			
			Toast toast = Toast.makeText(this, "Right Spin sent..", Toast.LENGTH_LONG);
			toast.show();
			
		} catch (Exception e) {
			Log.e("7inches", "Hit rightSpin");
		}
	}
	
	public void leftSpinPressed(View view) throws IOException {
		try {
			byte lspin = (byte) 0b00000110;
			bt.sendData(lspin);
			
			Toast toast = Toast.makeText(this, "Left Spin sent..", Toast.LENGTH_LONG);
			toast.show();
			
		} catch (Exception e) {
			Log.e("7inches", "Hit leftSpin");
		}
	}
	
	public void rightForwardCurvePressed(View view) throws IOException {
		try {
			byte rfcurve = (byte) 0b00001000;
			bt.sendData(rfcurve);
			
			Toast toast = Toast.makeText(this, "Right Forward Curve sent..", Toast.LENGTH_LONG);
			toast.show();
			
		} catch (Exception e) {
			Log.e("7inches", "Hit rightForCurve");
		}
	}

	public void rightBackwardCurvePressed(View view) throws IOException {
		try {
			byte rbcurve = (byte) 0b00000100;
			bt.sendData(rbcurve);
			
			Toast toast = Toast.makeText(this, "Right Backward Curve sent..", Toast.LENGTH_LONG);
			toast.show();
			
		} catch (Exception e) {
			Log.e("7inches", "Hit rightBackCurve");
		}
	}
	
	public void leftForwardCurvePressed(View view) throws IOException {
		try {
			byte lfcurve = (byte) 0b00000010;
			bt.sendData(lfcurve);
			
			Toast toast = Toast.makeText(this, "Left Forward Curve sent..", Toast.LENGTH_LONG);
			toast.show();
			
		} catch (Exception e) {
			Log.e("7inches", "Hit leftForCurve");
		}
	}
	
	public void leftBackwardCurvePressed(View view) throws IOException {
		try {
			byte lbcurve = (byte) 0b00000001;
			bt.sendData(lbcurve);
			
			Toast toast = Toast.makeText(this, "Left Backward Curve sent..", Toast.LENGTH_LONG);
			toast.show();
			
		} catch (Exception e) {
			Log.e("7inches", "Hit leftBackCurve");
		}
	}

}
