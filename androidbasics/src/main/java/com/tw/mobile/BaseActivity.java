package com.tw.mobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		log("onCreate()", "Creating...");
	}
	
	@Override
	protected void onRestart() {
		log("onRestart()","Starting...");
		super.onRestart();
	}
	
	@Override
	protected void onStart() {
		log("onStart()", "Starting...");
		super.onStart();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		log("onConfigurationChanged()", null);
		super.onConfigurationChanged(newConfig);
	}
	
	@Override
	protected void onResume() {
		log("onResume()", "Resumed");
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		log("onPause()", "Paused");
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		log("onStop()", "Stopped");
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		log("onDestroy()", "Destroyed");
		super.onDestroy();
	}

	@Override
	public void onAttachedToWindow() {
		log("onAttachedToWindow()", "Resumed");
		super.onAttachedToWindow();
	}

	@Override
	public void onDetachedFromWindow() {
		log("onDetachedFromWindow()", "Destroyed");
		super.onDetachedFromWindow();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		log("onSaveInstanceState()", null);
		super.onSaveInstanceState(outState);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		log("onRestoreInstanceState()", "Starting...");
		super.onRestoreInstanceState(savedInstanceState);
	}
	
    public void startDialog(View v) {
		new AlertDialog.Builder(this)
				.setTitle("Your Alert")
				.setMessage("Your Message")
				.setCancelable(false)
				.setPositiveButton("ok", new AlertDialog.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// Whatever...
					}
				}).show();
    }

	public void startCustomDialog(View v) {
		Intent intent = new Intent(this, DialogActivity.class);
		startActivity(intent);
	}

	private void log(String method, String status) {
		LogWindow.notifyOnAction(this, method, status);
		System.out.println(this.getClass().getSimpleName() + "." + method);
	}

}
