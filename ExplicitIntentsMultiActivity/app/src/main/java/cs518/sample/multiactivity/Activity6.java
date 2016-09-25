package cs518.sample.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/* 
 * The sole reason for this class is to return data to the Activity that started it
 * It puts the data on the Intent
 * The overriding of finish() is to illustrate the possiblity.
 * If someone hits the back button, finish() will be called, this covers
 * all ways this Activity can end.
 * Cannot do it in the onStop() onDestroy() as they are not guaranteed to run
 * Cannot do it in the onPause() because we could be interrupted by another app
 */
public class Activity6 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// using the same layout as activity 2 as it just needs a simple text 
		setContentView(R.layout.activity6);

	} // onCreate()

	@Override
	public void finish(){
		// set up a new Intent
		double num = 5.5;
		Intent i  = new Intent();
		i.putExtra(Constants.RETURN_KEY1, "data from Activity6.java");
		i.putExtra(Constants.RETURN_KEY2, num);
		setResult(RESULT_OK, i);
		super.finish();		
	}

}