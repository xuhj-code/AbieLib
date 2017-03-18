package com.tsign.xhj.view;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * 2016年11月4日17:01:54
 *
 * @author haru
 *
 */
public class CustomMarqueeTextView extends TextView {
	/** 是否停止滚动 */
	private boolean mStopMarquee;
	private String mText;
	private float mCoordinateX;
	private float mTextWidth;
	private float windowWith;
	private float position = 4;

	public CustomMarqueeTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setText(String text) {
		this.mText = text;
		mTextWidth = getPaint().measureText(mText);
		DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
		windowWith = displayMetrics.widthPixels;
		if (mHandler.hasMessages(0))
			mHandler.removeMessages(0);
		mHandler.sendEmptyMessageDelayed(0, 2000);
	}

	@Override
	protected void onAttachedToWindow() {
		mStopMarquee = false;
		if (mText != null)
			mHandler.sendEmptyMessageDelayed(0, 2000);
		super.onAttachedToWindow();
	}

	@Override
	protected void onDetachedFromWindow() {
		mStopMarquee = true;
		if (mHandler.hasMessages(0))
			mHandler.removeMessages(0);
		super.onDetachedFromWindow();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (mText != null)
			canvas.drawText(mText, mCoordinateX, 30, getPaint());
	}

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				if (mCoordinateX < 0
						&& Math.abs(mCoordinateX) > (mTextWidth + position)) {
					// mCoordinateX = CustomMarqueeTextView.this.getWidth();
					mCoordinateX = windowWith;
				} else {
					mCoordinateX -= position;
				}
				invalidate();
				if (!mStopMarquee) {
					mHandler.sendEmptyMessage(0);
				}
				break;
			}
			super.handleMessage(msg);
		}
	};

	public void setPosition(float position) {
		this.position = position;
	}
}
