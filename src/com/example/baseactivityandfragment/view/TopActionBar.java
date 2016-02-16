package com.example.baseactivityandfragment.view;

import com.example.baseactivityandfragment.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopActionBar extends LinearLayout implements OnClickListener{

	public static final int FLAG_LEFT = 0;
	public static final int FLAG_TITEL  = 1;
	public static final int FLAG_RIGHT_ONE = 2;
	public static final int FLAG_RIGHT_TWO = 3;
	
	
	private Context mContext;
	private View mView;
	private RelativeLayout relative_topbar_right1;
	private RelativeLayout relative_topbar_right2;
	private LinearLayout ll_topbar_back;
	private TextView tv_topbar_title;
	
	public TopActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	public TopActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public TopActionBar(Context context) {
		super(context);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		mView = View.inflate(mContext, R.layout.view_topactionbar, this);
		relative_topbar_right1 = (RelativeLayout) mView.findViewById(R.id.relative_topbar_right1);
		relative_topbar_right2 = (RelativeLayout) mView.findViewById(R.id.relative_topbar_right2);
		tv_topbar_title = (TextView) mView.findViewById(R.id.tv_topbar_title);
		ll_topbar_back = (LinearLayout) mView.findViewById(R.id.ll_topbar_back);
		relative_topbar_right1.setOnClickListener(this);
		relative_topbar_right2.setOnClickListener(this);
	    ll_topbar_back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.relative_topbar_right1:
			if(listener != null){
				listener.onTopActionBarClick(FLAG_RIGHT_ONE);
			}
			break;

		case R.id.relative_topbar_right2:
			if(listener != null){
				listener.onTopActionBarClick(FLAG_RIGHT_TWO);
			}
			break;
			
		case R.id.ll_topbar_back:
			if(listener != null){
				listener.onTopActionBarClick(FLAG_LEFT);
			}
			break;	
		}
	}
	
	/**
	 * 设置右边的第一个按钮
	 * @param v
	 */
	public void addRightOneView(View v){
		ViewGroup p = (ViewGroup) relative_topbar_right1.getParent();
		if (p != null) { 
            p.removeAllViewsInLayout(); 
        } 
		relative_topbar_right1.addView(v);
	}
	
	
	/**
	 * 设置右边的第二个按钮
	 * @param v
	 */
	public void addRightTwoView(View v){
		ViewGroup p = (ViewGroup) relative_topbar_right2.getParent();
		if (p != null) { 
            p.removeAllViewsInLayout(); 
        } 
		relative_topbar_right2.addView(v);
	}
	
	/**
	 * 设置标题
	 * @param s
	 */
	public void setTitle(String s){
		tv_topbar_title.setText(s);
	}
	
	private OnTopActionBarClickListener listener;
	
	/**
	 * 监听TopActionBar的各个按钮的点击事件
	 * 
	 * @author LYH
	 */
	public interface OnTopActionBarClickListener{
		
		/**
		 * @param flag
		 *  FLAG_LEFT         左边的按钮
		 *  FLAG_RIGHT_ONE    右边第一个按钮
		 *  FLAG_RIGHT_TWO    右边第二个按钮
		 */
		public void onTopActionBarClick(int flag);
	}

	/**
	 * 设置监听接口
	 * @param listener
	 */
	public void setListener(OnTopActionBarClickListener listener){
		this.listener = listener;
	}
}
