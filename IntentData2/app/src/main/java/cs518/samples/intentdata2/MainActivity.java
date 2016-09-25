package cs518.samples.intentdata2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * App used to send data to child activity, then receive data from child
 * activity
 * 
 * @author tricia
 *
 */
public class MainActivity extends Activity {
	EditText et;
	TextView tv2, tv3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) findViewById(R.id.data1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
	}

	public void launchActivity2(View view) {
		Intent i = new Intent(this, Activity2.class);

		logIt(et.getText().toString());
		i.putExtra("DATA1", et.getText().toString());

		// request code = 0, only one activity used
		startActivityForResult(i, 0);

	}

	/**
	 * Lifecycle method called when an activity you launched exits
	 * 
	 * @param request
	 *            int originally supplied to startActivityForResult()
	 * @param result
	 *            int returned by the child activity through its setResult().
	 * @param i
	 *            Intent can be used to return (extras) result data to caller
	 */
	protected void onActivityResult(int request, int result, Intent i) {
		String data;
		switch (result) {
		case RESULT_OK:
			logIt("result ok");
			if (i != null && i.hasExtra("DATA2")) {
				data = i.getExtras().getString("DATA2");
				Log.d("DATA", data);
				if (data == null) 
					tv3.setText(R.string.nodata);
				else
					tv3.setText(data);
			} else {
				tv3.setText("No intent or no extras");
			}
			tv3.setTextColor(Color.MAGENTA);
			break;
		case RESULT_CANCELED:
		default:
			logIt("result canceled");
			tv3.setText("Cancel returned from child Activity");
			tv3.setTextColor(Color.RED);
		}
		tv2.setVisibility(View.VISIBLE);
		tv3.setVisibility(View.VISIBLE);
	} // onActivityResult()

	/**
	 * Simple wrapper method for Log.d()
	 * 
	 * @param msg
	 *            string to be logged
	 */
	public static void logIt(String msg) {
		final String TAG = "INTDATA1";
		Log.d(TAG, msg);
	}
}