package cs518.sample.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.net.Uri;
import android.util.Log;

/**
 * 
 * icon: elvis, holmes, monroe from http://iconka.com/persons/
 * icon: targetarrow from https://www.iconfinder.com/iconsets/5-o-clock-shades-icon-set-2#readme
 * @author Tricia
 */
public class Activity1 extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity1);	
	}

	// use explicit intent -> name the target Activity class
	// send no data, receive no data back
	public void handleButton1Click(View view) {
		startActivity(new Intent(this, Activity2.class));
	}


	// use implicit intent -> (action, data.for.action)
	/*
	 * Implicit intent is send to the Android system, it searches for all
	 * components which are registered for the specific action and the fitting
	 * data type. (Registered means AndroidManifest -> <intent-filter>
	 */
	public void handleButton2Click(View view) {
		String url = "http://www.xkcd.org/";
		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

		/*
		 * can also add the url using Intent.setData()
		 * i.setData(Uri.parse(url)); can also add the action using
		 * Intent.setAction() i.setData(Intent.ACTION_VIEW);
		 */
		startActivity(i);
	}
	// use explicit intent -> name the target Activity class
	// send no data, expect a result back
	public void handleButton31Click(View v) {
		Intent i;
		i = new Intent(this, Activity3.class);
		/*
		 * can also add the class using Intent.setClass() i.setClass(this,
		 * Activity3.class)
		 */
		/* int, requestCode = Constants.REQUEST1
		 * requestCode If >= 0, this code will be returned in onActivityResult() when the activity exits.
		 * */
		startActivityForResult(i, Constants.REQUEST1);

	}

	// use explicit intent -> name the target Activity class
	// send  data, expect a result back
	public void handleButton32Click(View v) {
		Intent i;
		i = new Intent(this, Activity4.class);
		/*
		 * can also add the class using Intent.setClass() i.setClass(this,
		 * Activity3.class)
		 */
		i.putExtra(Constants.KEY3, "here's some data from main activity");
		startActivityForResult(i, Constants.REQUEST2);

	}
	public void handleButton4Click(View view) {
		Intent i = new Intent(this, Activity5.class);
		EditText et = (EditText) findViewById(R.id.dataforactivity);
		logIt(et.getText().toString());
		i.putExtra(Constants.KEY1, et.getText().toString());
		i.putExtra(Constants.KEY2, "second piece of data for activity");
		startActivity(i);
	}

	public void handleButton5Click(View view) {
		Intent i = new Intent(this, Activity6.class);
		startActivityForResult(i, Constants.REQUEST3);
	}
	/*
	 * 
	 * Called when result returned by an activity
	 * 
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onActivityResult(int, int,
	 * android.content.Intent)
	 * 
	 * result:  RESULT_OK and RESULT_CANCELED in Activity class, set by returning
	 * activity
	 * request:  same one sent in startActivityForResult(Intent, request);
	 */
	protected void onActivityResult(int request, int result, Intent data) {
		int counter;
		String msg = "activity " + result + " returned from request: "
				+ request;
		TextView tvresult = (TextView) findViewById(R.id.result);
		TextView tv = (TextView) findViewById(R.id.data);
		switch (request) {
		// 1 sent to Activity 3 so result is from Activity 3
		case Constants.REQUEST1:			

			if (result == RESULT_OK) {
				logIt(msg += " result ok");
				toastIt(msg + " result ok");
			}
			if (result == RESULT_CANCELED) {
				logIt(msg += " result canceled");
				toastIt(msg + " result canceled");
			}
			tvresult.setText(msg);
			tv.setText("");
			break;
		// 2 sent to Activity 4 so result is from Activity 4
		case Constants.REQUEST2:   		

			if (data != null && data.hasExtra(Constants.KEY4)) {
				counter = data.getExtras().getInt(Constants.KEY4);
			} else {
				counter = 0;
			}
			if (result == RESULT_OK) {
				msg = msg+" key4 data count: "+Integer.toString(counter)+" result ok";
				logIt(msg);
				toastIt(msg);
			}
			if (result == RESULT_CANCELED) {
				msg = msg + Integer.toString(counter)+" result canceled";
				logIt(msg);
				toastIt(msg);
			}
			tvresult.setText(msg);
			tv.setText("");
			break;
		// 3 sent to Activity 6 so  result is from Activity 6
		case Constants.REQUEST3:
			tvresult.setText(msg);
			if (result == RESULT_OK) {
				
				if (data.hasExtra(Constants.RETURN_KEY1)) {
					msg = "key1 data: " + data.getExtras().getString(Constants.RETURN_KEY1);
					logIt(msg);
				}
				if (data.hasExtra(Constants.RETURN_KEY2)) {
					msg += " key2 data: " + data.getExtras().getDouble(Constants.RETURN_KEY2);
					logIt(msg);
				}	
				tv.setText(msg);
			} else {
				logIt("Error, invalid return from Activity");
			}
			
			break; 
		default:
			logIt("no valid request received " + msg);
			toastIt("no valid request received " + msg);
			tvresult.setText(msg);
		}
	}// onActivityResult


	public static void logIt(String msg) {
		final String TAG = "MULTACT";
		Log.d(TAG, msg);
	}

	public void toastIt(String msg) {
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}
}
