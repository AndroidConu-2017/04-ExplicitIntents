package cs518.sample.multiactivity;

import android.app.Activity;
import android.os.Bundle;
/*
 * This Activity is total independent of any others that might fire it
 * no data is received or returned 
 */
public class Activity2 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
	}

}