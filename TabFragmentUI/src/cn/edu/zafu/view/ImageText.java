package cn.edu.zafu.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.edu.zafu.constant.Constant;
import cn.edu.zafu.ui.R;
import cn.edu.zafu.util.DensityUtil;

public class ImageText extends LinearLayout {

	private Context mContext=null;
	private ImageView mImageView=null;
	private TextView mTextView=null;
	private final static int DEAFAULT_IMAGE_WIDTH=64;
	private final static int DEAFAULT_IMAGE_HEIGHT=64;
	private int CHECKED_COLOR=Color.rgb(29,118,199);
	private int UNCHECKED_COLOR=Color.GRAY;
	public ImageText(Context context) {
		super(context);
		mContext=context;
	}
	public ImageText(Context context,AttributeSet attrs){
		super(context,attrs);
		mContext=context;
		LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View parent=inflater.inflate(R.layout.bottom_image_text, this, true);
		mImageView=(ImageView) findViewById(R.id.bottom_image);
		mTextView=(TextView) findViewById(R.id.bottom_text);
	}
	public void setText(String s){
		if(mTextView!=null){
			mTextView.setText(s);
			mTextView.setTextColor(UNCHECKED_COLOR);
		}
	}
	public void setImage(int id){
		if(mImageView!=null){
			mImageView.setImageResource(id);
			//setImageSize(DEAFAULT_IMAGE_WIDTH,DEAFAULT_IMAGE_HEIGHT);
			setImageSize(DensityUtil.dip2px(mContext,DEAFAULT_IMAGE_WIDTH),DensityUtil.dip2px(mContext,DEAFAULT_IMAGE_HEIGHT));

		}
	}
	public void setImageSize(int w,int h){
		if(mImageView!=null){
			LayoutParams params=(LayoutParams) mImageView.getLayoutParams();
			params.width=w;
			params.height=h;
			mImageView.setLayoutParams(params);
		}
	}
	public void setChecked(int itemId){
		if(mTextView!=null){
			mTextView.setTextColor(CHECKED_COLOR);
		}
		int checkDrawableId=-1;
		switch(itemId){
		case Constant.BTN_FLAG_MESSAGE:
			checkDrawableId=R.drawable.skin_tab_icon_conversation_selected;
			break;
		case Constant.BTN_FLAG_CONTACT:
			checkDrawableId=R.drawable.skin_tab_icon_contact_selected;
			break;
		case Constant.BTN_FLAG_NEWS:
			checkDrawableId=R.drawable.skin_tab_icon_plugin_selected;
			break;
		case Constant.BTN_FLAG_SETTING:
			checkDrawableId=R.drawable.skin_tab_icon_setup_selected;
			break;
		default:
			break;
		}
		if(mImageView!=null){
			mImageView.setImageResource(checkDrawableId);
		}
	}
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return true;
	}
	
}
