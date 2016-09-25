package cs518.samples.intentdata3;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 
 * This class does two things 1 receive data from the Intent of the Activity
 * that started it. 2 create a new Intent to send data back to the Activity that
 * started it.
 * 
 * It displays the received data on the UI.
 * 
 * @author Tricia
 * 
 */
public class Activity2 extends Activity {
	boolean returnHit = false;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2_main);

		String value = getIntent().getExtras().getString("DATA1");
		TextView tv2 = (TextView) findViewById(R.id.a2tv2);

		if (value == null || value.isEmpty()) {
			tv2.setText(R.string.nodata);
			tv2.setTextColor(Color.RED);
		} else {
			MainActivity.logIt("DATA1 " + value);
			tv2.setText(value);
			tv2.setTextColor(Color.MAGENTA);
		}
	} // onCreate()

	public void returnData(View view) {
		EditText et1 = (EditText) findViewById(R.id.a2et1);
		Intent i = new Intent();
		i.putExtra("DATA2", et1.getText().toString());
		setResult(RESULT_OK, i);
		returnHit = true;
		finish();
	}

	@Override
	public void finish() {
		if (!returnHit) {
		Intent i = new Intent();
		i.putExtra("DATA2", "Data dropped, back button was hit!");
		setResult(RESULT_CANCELED, i);
		}
		super.finish();
	}

}  // Activity2
