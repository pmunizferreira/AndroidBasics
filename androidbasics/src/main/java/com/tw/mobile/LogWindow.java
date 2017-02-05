package com.tw.mobile;

import java.text.SimpleDateFormat;
import java.util.Date;

import wei.mark.standout.StandOutWindow;
import wei.mark.standout.constants.StandOutFlags;
import wei.mark.standout.ui.Window;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class LogWindow extends StandOutWindow {

	private static View parent;
	private static String log = "";
	private static String[] stack = new String[3];
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
	public static boolean visible;

	@Override
	public String getAppName() {
		return "Log";
	}

	@Override
	public int getAppIcon() {
		return android.R.drawable.ic_menu_close_clear_cancel;
	}

	@Override
	public void createAndAttachView(int id, FrameLayout frame) {
		System.out.println("LogWindow.createAndAttachView()");
		visible = true;
		
		// create a new layout from body.xml
		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		parent = inflater.inflate(R.layout.log_layout, frame, true);
		
		updateLog();
	}

	private static void updateLog() {
		TextView t = (TextView) parent.findViewById(R.id.logView);
		t.setText(log);
		if (stack[0] != null) {
			((TextView) parent.findViewById(R.id.statusFirst)).setText("FirstActivity " + stack[0]);
		} else {
			((TextView) parent.findViewById(R.id.statusFirst)).setText("");
		}
		if (stack[1] != null) {
			((TextView) parent.findViewById(R.id.statusSecond)).setText("SecondActivity " + stack[1]);
		} else {
			((TextView) parent.findViewById(R.id.statusSecond)).setText("");
		}
		if (stack[2] != null) {
			((TextView) parent.findViewById(R.id.statusThird)).setText("ThirdActivity " + stack[2]);
		} else {
			((TextView) parent.findViewById(R.id.statusThird)).setText("");
		}
	}
	
	@Override
	public boolean onClose(int id, Window window) {
		System.out.println("LogWindow.onClose()");
		visible = false;
		parent = null;
		return super.onClose(id, window);
	}

	// the window will be centered
	@Override
	public StandOutLayoutParams getParams(int id, Window window) {
		return new StandOutLayoutParams(id, 700, 550,
				StandOutLayoutParams.CENTER, StandOutLayoutParams.CENTER);
	}

	// move the window by dragging the view
	@Override
	public int getFlags(int id) {
		return super.getFlags(id) | StandOutFlags.FLAG_BODY_MOVE_ENABLE
				| StandOutFlags.FLAG_WINDOW_FOCUSABLE_DISABLE;
	}

	@Override
	public String getPersistentNotificationMessage(int id) {
		return "Click to close the log";
	}

	@Override
	public Intent getPersistentNotificationIntent(int id) {
		return StandOutWindow.getCloseIntent(this, LogWindow.class, id);
	}
	
	public static void notifyOnAction(Activity activity, String method, String status) {
		System.out.println("LogWindow.notifyOnAction() "+activity +" - " + parent);
		if (log.length() > 0) {
			log += "\n";
		}
		log += currentTime() + " " + activity.getClass().getSimpleName() + "." + method;
		if (status != null) {
			if (activity instanceof FirstActivity) {
				stack[0] = status;
			} else if (activity instanceof SecondActivity) {
				stack[1] = status;
			} else if (activity instanceof ThirdActivity) {
				stack[2] = status;
			}
		}

		if (parent != null) {
			updateLog();
		}
	}

	private static String currentTime() {
		return timeFormat.format(new Date());
	}
}
