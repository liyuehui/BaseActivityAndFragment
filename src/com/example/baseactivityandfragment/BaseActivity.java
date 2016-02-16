package com.example.baseactivityandfragment;

import com.example.baseactivityandfragment.view.TopActionBar;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {
	protected TopActionBar mTopActionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	protected abstract void initTopActionBar();
}
