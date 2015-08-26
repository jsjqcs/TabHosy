package ty.ast.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;
import ty.ast.R;
import ty.ast.bean.WeiboBean;
import ty.ast.sqlitedb.sqliteDB;


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
		queryNews();
	}
	private void init() {
		// TODO Auto-generated method stub
		String usercode = WeiboBean.usercode;     
		sqlitedb = new sqliteDB(usercode);
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
	public void queryNews(){
		String queryTime = CountBeforeSenvenDay();
		String sql = "select * from XT_WBMessage where ReportDate >="+ "'"+queryTime+"'" +" order by ID desc";
		mList.addAll(sqlitedb.QueryFromWBMessage(getApplicationContext(),sql));
		mAdapter.notifyDataSetChanged();
	}
	public static String CountBeforeSenvenDay() {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DAY_OF_YEAR, -7);
		SimpleDateFormat date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");
		String k = date2.format(c.getTime());
		return k;
	}
}
