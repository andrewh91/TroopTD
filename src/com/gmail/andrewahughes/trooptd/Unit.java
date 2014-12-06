package com.gmail.andrewahughes.trooptd;

import java.util.Vector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater.Filter;

public class Unit {

	private Context mContext;//this will be the context of the view that displays this class's textures
	

	private BitmapDrawable[] texture = new BitmapDrawable[10];
	private Paint paint = new Paint();//this is taken as a parameter when we draw it later on in the view
	private Rect rect;//rectangle
	private Rect sourceRect;//rectangle to determine how much of the bitmap to display
	private int scale = 5;//my texture is a pixel big, use this just to make it easier to see!

	public Unit(Context context, int textureID,int positionX,int positionY) //we refer to resources such a bitmaps by their ID
	{
		texture[0]=(BitmapDrawable)context.getResources().getDrawable(textureID);
		
		ColorFilter filter = new LightingColorFilter( Color.BLACK, Color.BLACK);//this changes my white pixel to black
		paint.setColorFilter(filter);
		
		
		BitmapFactory.Options dimensions = new BitmapFactory.Options();//all this does is 
		dimensions.inJustDecodeBounds = true;	//get the size of the bitmap without loading the bitmap
		BitmapFactory.decodeResource(context.getResources(), textureID, dimensions);
		int height = dimensions.outHeight;//it returns the height...
		int width =  dimensions.outWidth;// ...and width so we can use them in the ...
		
		sourceRect= new Rect(0,0,width,height);//...source rectangle
		
		rect = new Rect(positionX, positionY, positionX+(width*scale), positionY+(height*scale));//Destination rect left,top,right,bottom or posx, posy, width, height position and scale of unit
		
		
	}
	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(getTexture(),getSourceRect(),getRect(),getPaint());
	}
	//#
	//getters and setters 
	//#
	public Bitmap getTexture() {
		return texture[0].getBitmap();
	}

	public void setTexture(BitmapDrawable[] texture) {
		this.texture = texture;
	}
	public Paint getPaint() {
		return paint;
	}
	public void setPaint(Paint paint) {
		this.paint = paint;
	}
	public Rect getRect() {
		return rect;
	}
	public void setRect(Rect rect) {
		this.rect = rect;
	}
	public Rect getSourceRect() {
		return sourceRect;
	}
	public void setSourceRect(Rect sourceRect) {
		this.sourceRect = sourceRect;
	}
}
