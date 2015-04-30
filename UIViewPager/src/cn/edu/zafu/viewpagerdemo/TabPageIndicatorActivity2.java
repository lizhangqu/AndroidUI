package cn.edu.zafu.viewpagerdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Window;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TabPageIndicator;

public class TabPageIndicatorActivity2 extends SherlockFragmentActivity  {

	private static final String[] TITLE=new String[]{"分组一","分组二","分组三","分组四","分组五"};
	private static final List<Fragment> list=new ArrayList<Fragment>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tab_page_indicator);
		list.add(new Tab1());
		list.add(new Tab2());
		list.add(new Tab3());
		list.add(new Tab4());
		list.add(new Tab4());
		FragmentPagerAdapter adapter=new TabPageIndicatorAdapter(getSupportFragmentManager());
		ViewPager page=(ViewPager) findViewById(R.id.pager);
		page.setAdapter(adapter);
		
		PageIndicator indicator=(TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(page);
		
		indicator.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		
	}
	class TabPageIndicatorAdapter extends FragmentPagerAdapter{
		
		public TabPageIndicatorAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int arg0) {
			return list.get(arg0);
		}

		@Override
		public int getCount() {
			return TITLE.length;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLE[position%TITLE.length];
		}
		
	}
}
