package cs518.sample.multiactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/* 
 * The sole reason for this class is to receive data from the Intent of the Activity that started it
 * It puts the data on the UI
 */
public class Activity5 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity5);
		String value1 = getIntent().getExtras().getString(Constants.KEY1);
		TextView tv1 = (TextView) findViewById(R.id.textView1);
		if (value1 != null) {
			Activity1.logIt("key1 data: "+value1);
			tv1.setText("key1 data: "+value1);
		} else {
			tv1.setText("key1 data: none received");
		}
		String value2 = getIntent().getExtras().getString(Constants.KEY2);
		TextView tv2 = (TextView) findViewById(R.id.textView2);
		if (value2 != null) {
			Activity1.logIt("key2 data: "+value2);
			tv2.setText("key2 data: "+value2); 
		} else {
			tv2.setText("key2 data: none received");
		}
	} // onCreate()

}