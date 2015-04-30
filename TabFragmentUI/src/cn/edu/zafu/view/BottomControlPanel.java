package cn.edu.zafu.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import cn.edu.zafu.constant.Constant;
import cn.edu.zafu.ui.R;

public class BottomControlPanel extends RelativeLayout implements
		OnClickListener {
	private Context mContext;
	private ImageText mMessageBtn = null;
	private ImageText mContactBtn = null;
	private ImageText mNewsBtn = null;
	private ImageText mSettingBtn = null;
	private int DEAFALUT_BACKGROUND_COLOR = Color.rgb(243, 243, 243);
	private BottomPanelCallback mBottomCallback = null;
	private List<ImageText> viewList = new ArrayList<ImageText>();

	public interface BottomPanelCallback {
		public void onBottomPanleClick(int itemID);
	}

	public BottomControlPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext=context;
	}

	@Override
	protected void onFinishInflate() {
		mMessageBtn = (ImageText) findViewById(R.id.btn_message);
		mContactBtn = (ImageText) findViewById(R.id.btn_contact);
		mNewsBtn = (ImageText) findViewById(R.id.btn_news);
		mSettingBtn = (ImageText) findViewById(R.id.btn_setting);
		setBackgroundColor(DEAFALUT_BACKGROUND_COLOR);
		viewList.add(mMessageBtn);
		viewList.add(mContactBtn);
		viewList.add(mNewsBtn);
		viewList.add(mSettingBtn);
	}

	public void initBottomPanel() {
		if (mMessageBtn != null) {
			mMessageBtn.setImage(R.drawable.skin_tab_icon_conversation_normal);
			//mMessageBtn.setText(Constant.FRAGMENT_FLAG_MESSAGE);
		}
		if (mContactBtn != null) {
			mContactBtn.setImage(R.drawable.skin_tab_icon_contact_normal);
			//mContactBtn.setText(Constant.FRAGMENT_FLAG_CONTACT);
		}
		if (mNewsBtn != null) {
			mNewsBtn.setImage(R.drawable.skin_tab_icon_plugin_normal);
			//mNewsBtn.setText(Constant.FRAGMENT_FLAG_NEWS);
		}
		if (mSettingBtn != null) {
			mSettingBtn.setImage(R.drawable.skin_tab_icon_setup_normal);
			//mSettingBtn.setText(Constant.FRAGMENT_FLAG_SETTING);
		}
		setButtonListener();
	}

	private void setButtonListener() {
		int num = this.getChildCount();
		for (int i = 0; i < num; i++) {
			View v = getChildAt(i);
			if (v != null) {
				v.setOnClickListener(this);
			}
		}
	}

	public void setBottonCallback(BottomPanelCallback bottomCallback) {
		mBottomCallback = bottomCallback;
	}

	@Override
	public void onClick(View v) {
		initBottomPanel();
		int index = -1;
		switch (v.getId()) {
		case R.id.btn_message:
			index = Constant.BTN_FLAG_MESSAGE;
			mMessageBtn.setChecked(Constant.BTN_FLAG_MESSAGE);
			break;
		case R.id.btn_contact:
			index = Constant.BTN_FLAG_CONTACT;
			mContactBtn.setChecked(Constant.BTN_FLAG_CONTACT);
			break;
		case R.id.btn_news:
			index = Constant.BTN_FLAG_NEWS;
			mNewsBtn.setChecked(Constant.BTN_FLAG_NEWS);
			break;
		case R.id.btn_setting:
			index = Constant.BTN_FLAG_SETTING;
			mSettingBtn.setChecked(Constant.BTN_FLAG_SETTING);
			break;
		default:
			break;
		}
		if(mBottomCallback!=null){
			 mBottomCallback.onBottomPanleClick(index);
		}

	}
	public void defaultButtonChecked(){
		if(mMessageBtn!=null){
			mMessageBtn.setChecked(Constant.BTN_FLAG_MESSAGE);
		}
	}
	@Override
	public void onLayout(boolean changed, int left, int top, int right, int bottom){
		super.onLayout(changed, left, top, right, bottom);
		layoutItems(left,top,right,bottom);
	}

	private void layoutItems(int left, int top, int right, int bottom) {
		int n=getChildCount();
		if(n==0){
			return;
		}
		int paddingLeft=getPaddingLeft();
		int paddingRight=getPaddingRight();
		int width=right-left;
		int height=bottom-top;
		int allWidth=0;
		for(int i=0;i<n;i++){
			View v=getChildAt(i);
			allWidth+=v.getWidth();
		}
		int blankWidth=(width-allWidth-paddingLeft-paddingRight)/(n-1);
		
		LayoutParams params1=(LayoutParams) viewList.get(1).getLayoutParams();
		params1.leftMargin=blankWidth;
		viewList.get(1).setLayoutParams(params1);
		
		LayoutParams params2=(LayoutParams) viewList.get(2).getLayoutParams();
		params2.leftMargin=blankWidth;
		viewList.get(2).setLayoutParams(params2);
	}

}
