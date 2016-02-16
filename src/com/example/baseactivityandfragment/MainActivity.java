package com.example.baseactivityandfragment;


import com.example.baseactivityandfragment.view.TopActionBar;
import com.example.baseactivityandfragment.view.TopActionBar.OnTopActionBarClickListener;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initTopActionBar();
	}

	@Override
	protected void initTopActionBar() {
		mTopActionBar = (TopActionBar) findViewById(R.id.topActionBar);
		mTopActionBar.setTitle("MainActivity");
		
		TextView tv1 = (TextView) View.inflate(this,R.layout.view_textview,null );
		tv1.setText("right1");
		TextView tv2 = (TextView) View.inflate(this,R.layout.view_textview,null );
		tv1.setText("right2");
		
		mTopActionBar.addRightOneView(tv1);
		mTopActionBar.addRightTwoView(tv2);
		
		mTopActionBar.setListener(new OnTopActionBarClickListener() {
			
			@Override
			public void onTopActionBarClick(int flag) {
				switch (flag) {
				case TopActionBar.FLAG_LEFT:
					Toast.makeText(MainActivity.this, "FLAG_LEFT", Toast.LENGTH_SHORT).show();
					break;
				case TopActionBar.FLAG_RIGHT_ONE:
					Toast.makeText(MainActivity.this, "FLAG_RIGHT_ONE", Toast.LENGTH_SHORT).show();
					break;
				case TopActionBar.FLAG_RIGHT_TWO:
					Toast.makeText(MainActivity.this, "FLAG_RIGHT_ONE", Toast.LENGTH_SHORT).show();
					break;

				}
			}
		});
		
	}
}
