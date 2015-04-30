package cn.edu.zafu.viewpagerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements OnClickListener{
	private Button tabPageIndicator=null;
	private Button tabPageIndicator2=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		init();
		
	}
	public void init(){
		tabPageIndicator=(Button) findViewById(R.id.tabPageIndicator);
		tabPageIndicator2=(Button) findViewById(R.id.tabPageIndicator2);
		tabPageIndicator.setOnClickListener(this);
		tabPageIndicator2.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.tabPageIndicator:
			startActivity(new Intent(MainActivity.this,TabPageIndicatorActivity.class));
			break;
		case R.id.tabPageIndicator2:
			startActivity(new Intent(MainActivity.this,TabPageIndicatorActivity2.class));
			break;
		}
	}
	
}
