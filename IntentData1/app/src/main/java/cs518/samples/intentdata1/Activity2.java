package cs518.samples.intentdata1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 
 * The sole reason for this class is to receive data from the Intent of the Activity that 
 * started it.
 * It displays the data on the UI.
 * @author Tricia
 * 
 */
public class Activity2 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2_main);
		
		String value = getIntent().getExtras().getString("DATA1");
		TextView tv1 = (TextView) findViewById(R.id.tv1);
		if (value == null || value.isEmpty()) {
			tv1.setText(R.string.nodata);
			tv1.setTextColor(Color.RED);
		} else {
			MainActivity.logIt("DATA1 " + value);
			tv1.setText(value);
			tv1.setTextColor(Color.MAGENTA);
		}
	} // onCreate()

}
