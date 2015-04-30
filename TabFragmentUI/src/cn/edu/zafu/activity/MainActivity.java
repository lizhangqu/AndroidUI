package cn.edu.zafu.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import cn.edu.zafu.constant.Constant;
import cn.edu.zafu.fragment.ContactFragment;
import cn.edu.zafu.fragment.MessageFragment;
import cn.edu.zafu.fragment.NewsFragment;
import cn.edu.zafu.fragment.SettingFragment;
import cn.edu.zafu.ui.R;
import cn.edu.zafu.view.BottomControlPanel;
import cn.edu.zafu.view.BottomControlPanel.BottomPanelCallback;

public class MainActivity extends FragmentActivity {
	private BottomControlPanel bottomPanel = null;
	private FragmentManager fragmentManager = null;
	private FragmentTransaction fragmentTransaction = null;
	public static int currentTab;
	private List<Fragment> fragments = new ArrayList<Fragment>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
		initFragments();
	}

	private void initUI() {
		bottomPanel = (BottomControlPanel) findViewById(R.id.bottom_layout);
		if (bottomPanel != null) {
			bottomPanel.initBottomPanel();
			bottomPanel.setBottonCallback(new MyBottomPanelListener());
			bottomPanel.defaultButtonChecked();
		}
		
	}
	public void initFragments() {
		fragments.add(new MessageFragment());
		fragments.add(new ContactFragment());
		fragments.add(new NewsFragment());
		fragments.add(new SettingFragment());
		currentTab = Constant.BTN_FLAG_MESSAGE;
		fragmentManager = getSupportFragmentManager();
		fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.fragment_content, fragments.get(0));
		fragmentTransaction.commit();

	}


	private void switchFragment(int index) {
		fragmentTransaction = fragmentManager.beginTransaction();
		Fragment fragment = fragments.get(index);
		fragments.get(currentTab).onPause();
		if (fragment.isAdded()) {
			fragment.onResume(); 
		} else {
			fragmentTransaction.add(R.id.fragment_content, fragment);
			
		}
		showTab(index); 
		fragmentTransaction.commit();
	}
	private void showTab(int idx) {
		for (int i = 0; i < fragments.size(); i++) {
			Fragment fragment = fragments.get(i);
			if (idx == i) {
				fragmentTransaction.show(fragment);
			} else {
				fragmentTransaction.hide(fragment);
			}
		}
		currentTab = idx;
	}
	class MyBottomPanelListener implements BottomPanelCallback{

		@Override
		public void onBottomPanleClick(int itemID) {
			switchFragment(itemID);
		}
	}
}
