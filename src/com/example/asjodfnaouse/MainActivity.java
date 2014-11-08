package com.example.asjodfnaouse;

import android.app.Activity;
import android.nfc.FormatException;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcAdapter.CreateNdefMessageCallback;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends Activity implements CreateNdefMessageCallback {

	private NfcAdapter myNfcAdapter;
	private NdefMessage nfcMessage;
	private EditText nameText;
	private EditText dobText;
	private EditText iceNumberText;
	private EditText iceNameText;
	private EditText allergiesText;
	private EditText medicalConditionsText;
	private MedicalData medicalData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**
		 * This code handles the input Strings. They are converted into a long
		 * String which is then changed into a byte array to create the
		 * NdefMessage Object
		 */

		nameText = (EditText) findViewById(R.id.enterName);
		dobText = (EditText) findViewById(R.id.enterDOB);
		iceNumberText = (EditText) findViewById(R.id.enterICENumber);
		iceNameText = (EditText) findViewById(R.id.enterICEName);
		allergiesText = (EditText) findViewById(R.id.enterAllergies);
		medicalConditionsText = (EditText) findViewById(R.id.enterConditions);

		myNfcAdapter = NfcAdapter.getDefaultAdapter(this);
		// According to the Android Beam example, to enable NDef transfer
		// to devices in proximity, setNdefPushMessage method must be called
		// this will only work when the app is in resumed state
		myNfcAdapter.setNdefPushMessageCallback(this, this); 

	}

	@Override
	public NdefMessage createNdefMessage(NfcEvent event) {
		medicalData = new MedicalData(nameText.getText().toString(), dobText
				.getText().toString(), iceNumberText.getText().toString(),
				iceNameText.getText().toString(), allergiesText.getText()
						.toString(), medicalConditionsText.getText().toString());
		// Create the NdefRecord container which will contain our String to be
		// beamed
		NdefRecord dataToSend = NdefRecord.createMime(
				"emergencymedicalinformation/plain", medicalData.toByteArray());

		// Create the NdefMessage Object
		return new NdefMessage(dataToSend);

	}

}
