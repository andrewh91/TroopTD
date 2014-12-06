package com.gmail.andrewahughes.trooptd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View{//make our GameView inherit from the View java class
	private Handler handler;//used in framerate, the postDelayed method is used to run a method after a defined time
	private int unitSize = 100;
	public Unit[] unit = new Unit[unitSize];
	public GameView(Context context, AttributeSet attributes){
		super(context,attributes);//invoke the super class (View) 's constructor
		handler = new Handler();
		for(int i = 0; i<unitSize;i++)
		{
			unit[i] = new Unit(context,R.drawable.whitepixel,6*i,6*i);
		}
		
	}
	private Runnable runnable = new Runnable() {
		// @overide
		public void run() {
			invalidate();//basically redraws the view, basically.  It will call onDraw at some point
		}
	};
	protected void onDraw(Canvas canvas)//protected means this is accessible to the class, package and any subclass 
	{
		for(int i = 0;i<unitSize;i++)
		{
			unit[i].draw(canvas);
		}
		//canvas.drawBitmap(unit01.getTexture(),unit01.getSourceRect(),unit01.getRect(),unit01.getPaint());
		handler.postDelayed(runnable, 30);
	}
}
