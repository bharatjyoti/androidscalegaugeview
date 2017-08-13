package com.bhazarika.gaugeviewui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by Bharat on 28-Feb-17.
 */

public class GaugeView extends View {

    public GaugeView(Context context) {
        super(context);
    }

    public GaugeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private int mNoOfDivision = 6;

    private int mStartingVal = 0;

    public GaugeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setNoOfDivision(int n){

        mNoOfDivision = n;
    }

    public void setStartingVal(int val){

        mStartingVal = val;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        setLayerType(View.LAYER_TYPE_SOFTWARE,null);

        Paint paint = new Paint();
        paint.setColor(Color.RED);

       // canvas.drawPath(startLine,paint);

        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();

        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,20,metrics);//7total 20 dp padding applied

        float progressBarLen = metrics.widthPixels - px;

        Path endLine = new Path();

        endLine.addRect(progressBarLen-4,0,progressBarLen,15, Path.Direction.CW);

       canvas.drawPath(endLine,paint);

        paint.setTextSize(20);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);


        float unitLen = progressBarLen / mNoOfDivision ;//TODO

        int i = mStartingVal;

        float crntX = 0;
        float x = crntX;

        int incrDiv = mNoOfDivision + 1;

        float qaurterLen = unitLen / 4;

        int divisionTickCnt = 0;

        while (i < (incrDiv) ) {


           if(i == 0){

               canvas.drawRect(crntX, 0, crntX + 4, 15, paint);

               canvas.drawText(String.valueOf(i), x , 35, paint);
           }
           else if(i < mNoOfDivision) {
               canvas.drawRect(crntX -2, 0, crntX + 2, 15, paint);

               canvas.drawText(String.valueOf(i), x , 35, paint);

           }
            else{

               canvas.drawText(String.valueOf(i), x-5 , 35, paint);

               break;
           }

           //draw Small scales.. we have kept 4 small scales

            int n=0;
            while (n < 4){

                crntX = crntX + qaurterLen;
                canvas.drawRect(crntX -1.5f, 0, crntX + 1.5f, 10, paint);

                n++;
            }

            x = crntX - 5;

            i++;
        }

        super.onDraw(canvas);
    }
}
