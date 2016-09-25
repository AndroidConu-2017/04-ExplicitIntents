package cs518.sample.multiactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

/*
 * This class receives data returns data and it returns a result
 */
public class Activity4 extends Activity {
	private int counter = 0;
	private TextView tv2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity4);
		// get the data from the Activity that fired this intent
		String value1 = getIntent().getExtras().getString(Constants.KEY3);
		TextView tv1 = (TextView) findViewById(R.id.datatv1);
		tv2 = (TextView) findViewById(R.id.datatv2);
		if (value1 != null) {
			Activity1.logIt(value1);
			tv1.setText(value1);
		} else {
			tv1.setText("no data received from invoking activity ");
		}

	} // onCreate

	public void countNow(View v) {
		counter++;
		tv2.setText(Integer.toString(counter));
	}
/*
 * Note this onPause() sets a result of ok
 * however since we rely on the back button to return to the caller
 * whenever the back button is hit is sends a cancel, note the data is ok 
 * but the result is cancel
 * 
 * (non-Javadoc)
 * @see android.app.Activity#onPause()
 * 	public void onPause() {
		// set up a new Intent
		Intent i = new Intent();
		i.putExtra(Constants.KEY4, counter);
		setResult(RESULT_OK, i);
		super.onPause(); 
	}

 */
	@Override
	public void finish() {
		// set up a new Intent
		Intent i = new Intent();
		i.putExtra(Constants.KEY4, counter);
		setResult(RESULT_OK, i);  
		super.finish(); 
	}
} // class