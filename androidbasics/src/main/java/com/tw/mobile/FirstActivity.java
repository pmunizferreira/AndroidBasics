package com.tw.mobile;

import wei.mark.standout.StandOutWindow;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (LogWindow.visible == false) {
			StandOutWindow.closeAll(this, LogWindow.class);
			StandOutWindow.show(this, LogWindow.class, StandOutWindow.DEFAULT_ID);
		}
		
		setContentView(R.layout.first_activity_layout);
		
		((Button)this.findViewById(R.id.button1To2)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(FirstActivity.this, SecondActivity.class));
			}
		});
	}
}
