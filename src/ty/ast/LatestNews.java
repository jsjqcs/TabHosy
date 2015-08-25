package ty.ast;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class LatestNews extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.frm_commweibo_listview);
	}
}
