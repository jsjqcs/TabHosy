package ty.ast.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import ty.ast.R;

public class CategoryNews extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.frm_commweibo_listview);
	}
}
