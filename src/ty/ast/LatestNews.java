package ty.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;
import ty.ast.bean.WeiboBean;
import ty.ast.db.sqliteDB;
import ty.ast.utils.Utils;

public class LatestNews extends Activity{
	public ListView mListview;
	public List<HashMap<String,Object>> mList;
	public ListViewAdapter mAdapter;
	public sqliteDB sqlitedb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.frm_commweibo_listview);
		setTitle("最新消息");
		init();
		InitListView();
	}
	private void init() {
		// TODO Auto-generated method stub
		String usercode = WeiboBean.usercode;     
		int version = WeiboBean.version;
		sqlitedb = new sqliteDB(getApplicationContext(), usercode, version);
	}
	private void InitListView() {
		// TODO Auto-generated method stub
		mListview = (ListView)findViewById(R.id.comment_listview);
		mList = new ArrayList<HashMap<String,Object>>();
		mAdapter = new ListViewAdapter();
		mListview.setAdapter(mAdapter);
	}
	public void setTitle(String text){
		View view = (View)findViewById(R.id.pubcheaderlayout);
		TextView mText = (TextView)view.findViewById(R.id.title_tvw);
		mText.setText(text);
	}
	public List<HashMap<String,Object>> queryNews(){
		//queryTime = Utils.CountBeforeSenvenDay();
		//String sql = "select * from XT_WBMessage where ReportDate >="+ "'"+queryTime+"'" +" order by ID desc";
		//return sqlitedb.QueryFromWBMessage(sql);
	}
}
