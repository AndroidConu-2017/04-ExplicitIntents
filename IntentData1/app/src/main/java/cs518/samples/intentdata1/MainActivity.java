package cs518.samples.intentdata1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText et;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et = (EditText) findViewById(R.id.data1);
	}

	public void launchActivity2(View view) {
		Intent i = new Intent(this, Activity2.class);
		
		logIt(et.getText().toString());
		i.putExtra("DATA1", et.getText().toString());
		
		startActivity(i);

	}
	public static void logIt(String msg) {
		final String TAG = "INTDATA1";
		Log.d(TAG, msg);
	}
}