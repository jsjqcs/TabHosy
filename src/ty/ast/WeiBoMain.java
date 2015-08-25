package ty.ast;

import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class WeiBoMain extends ActivityGroup{
    /** Called when the activity is first created. */
	private TabHost mTabHost;
	private Context mContex = this;
	private String TAB1 = "最新消息";
	private String TAB2 = "全部消息";
	private String TAB3 = "消息分类";
	private String TAB4 = "我的空间";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	setContentView(R.layout.frm_commweibo_main);
        mTabHost = (TabHost)findViewById(R.id.tabhost);
        mTabHost.setup(this.getLocalActivityManager());
        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator(getMenuItem(R.drawable.commweibo_latestnews_pressed, TAB1)).setContent(new Intent(this,LatestNews.class)));
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(getMenuItem(R.drawable.commweibo_allnews_pressed, TAB2)).setContent(new Intent(this,AllNews.class)));
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator(getMenuItem(R.drawable.commweibo_categorynews_pressed, TAB3)).setContent(new Intent(this,CategoryNews.class)));
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator(getMenuItem(R.drawable.commweibo_myzonenews_pressed, TAB4)).setContent(new Intent(this,MyZoneNews.class)));
    }
	private View getMenuItem(int imgId, String textId) {
		// TODO Auto-generated method stub
		View view = LayoutInflater.from(mContex).inflate(
				R.layout.frm_commweibo_main_item, null);
		ImageView mImage = (ImageView)view.findViewById(R.id.icon);
		TextView mText = (TextView)view.findViewById(R.id.name);
		mImage.setBackgroundResource(imgId);
		mText.setText(textId);
		return view;
	}
}