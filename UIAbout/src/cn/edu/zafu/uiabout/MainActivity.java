package cn.edu.zafu.uiabout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private LinearLayout option1 = null;
	private LinearLayout option2 = null;
	private LinearLayout option3 = null;
	private LinearLayout option4 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		option1 = (LinearLayout) findViewById(R.id.option1);
		option2 = (LinearLayout) findViewById(R.id.option2);
		option3 = (LinearLayout) findViewById(R.id.option3);
		option4 = (LinearLayout) findViewById(R.id.option4);
		option1.setOnClickListener(this);
		option2.setOnClickListener(this);
		option3.setOnClickListener(this);
		option4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.option1:
			Toast.makeText(getApplicationContext(), "option1",
					Toast.LENGTH_LONG).show();
			break;

		case R.id.option2:
			Toast.makeText(getApplicationContext(), "option2",
					Toast.LENGTH_LONG).show();
			break;

		case R.id.option3:
			Toast.makeText(getApplicationContext(), "option3",
					Toast.LENGTH_LONG).show();
			break;
		case R.id.option4:
			Toast.makeText(getApplicationContext(), "option4",
					Toast.LENGTH_LONG).show();
			break;
		}
	}

}
