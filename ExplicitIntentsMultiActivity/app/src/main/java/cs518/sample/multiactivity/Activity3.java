package cs518.sample.multiactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
/*
 * This class receives no data but it returns a result, depending on which button is clicked
 */
public class Activity3 extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity3);
	}
	public void thisResult(View v) {
		setResult(RESULT_OK);        
		finish();
	} //thisResult()
	public void thatResult(View v) {
		setResult(RESULT_CANCELED);        
		finish();
	} //thisResult()

}