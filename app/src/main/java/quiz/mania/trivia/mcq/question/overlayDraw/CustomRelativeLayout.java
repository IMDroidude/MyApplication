package quiz.mania.trivia.mcq.question.overlayDraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CustomRelativeLayout extends RelativeLayout {

    private Context mContext;
    private ImageButtonCustom[] imageButtonCustoms = new ImageButtonCustom[3];
    private Paint paint;
    CustomRelativeLayout customRelativeLayout;

    private ImageButtonCustom bottomLeftIv,topRightIv,centerIv;

    public CustomRelativeLayout(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init();
    }

    public CustomRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        //setBackgroundColor(Color.BLACK);
        customRelativeLayout = this;
        setWillNotDraw(false);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth((float) 12);

        bottomLeftIv = new ImageButtonCustom(mContext,customRelativeLayout);
        topRightIv = new ImageButtonCustom(mContext,customRelativeLayout);
        centerIv = new ImageButtonCustom(mContext,customRelativeLayout);

        bottomLeftIv.setBackgroundColor(Color.GRAY);
        topRightIv.setBackgroundColor(Color.BLUE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawLine(bottomLeftIv.getCenterX(),bottomLeftIv.getCenterY()
                ,topRightIv.getCenterX() ,bottomLeftIv.getCenterY(),paint); //left Bottom Corner to Right Corner from Bob -> 1
        canvas.drawLine(bottomLeftIv.getCenterX(),bottomLeftIv.getCenterY()
                ,bottomLeftIv.getCenterX() ,topRightIv.getCenterY(),paint);// left Bottom Corner to Top of it.

        canvas.drawLine(topRightIv.getCenterX(),topRightIv.getCenterY()
                ,bottomLeftIv.getCenterX() ,topRightIv.getCenterY(),paint);// right top Corner to Left Top Corner
        canvas.drawLine(topRightIv.getCenterX(),topRightIv.getCenterY()
                ,topRightIv.getCenterX() ,bottomLeftIv.getCenterY(),paint);// right top Corner to Bottom of it.

        canvas.drawLine(centerIv.getCenterX(),centerIv.getCenterY(),
                bottomLeftIv.getCenterX(),bottomLeftIv.getCenterY(),paint); // centre to Bottom left corner

        canvas.drawLine(centerIv.getCenterX(),centerIv.getCenterY(),
                topRightIv.getCenterX(),bottomLeftIv.getCenterY(),paint);  // centre to Bottom right corner

        canvas.drawLine(centerIv.getCenterX(),centerIv.getCenterY(),
                bottomLeftIv.getCenterX(),topRightIv.getCenterY(),paint); // centre to Top left corner

        canvas.drawLine(centerIv.getCenterX(),centerIv.getCenterY(),
                topRightIv.getCenterX(),topRightIv.getCenterY(),paint); // centre to Top Right corner

        //canvas.drawLine(centerIv.getCenterX(),topRightIv.getCenterY(),
          //      centerIv.getCenterX(),bottomLeftIv.getCenterY(),paint); // Center line from top to bottom

        float xLoc = bottomLeftIv.getCenterX() + topRightIv.getCenterX()/2.0f;

        //canvas.drawLine(xLoc,bottomLeftIv.getCenterY(),xLoc,topRightIv.getCenterY(),paint);

        canvas.drawLine(xLoc,topRightIv.getCenterY(),centerIv.getCenterX(),centerIv.getCenterY(),paint);
        canvas.drawLine(xLoc,bottomLeftIv.getCenterY(),centerIv.getCenterX(),centerIv.getCenterY(),paint);

        //draw line from bottom left imageView to it's top and right corner
        /*canvas.drawLine(imageButtonCustoms[0].getCenterX(),imageButtonCustoms[0].getCenterY()
                ,imageButtonCustoms[1].getCenterX() ,imageButtonCustoms[0].getCenterY(),paint); //left Bottom Corner to Right Corner from Bob -> 1
        canvas.drawLine(imageButtonCustoms[0].getCenterX(),imageButtonCustoms[0].getCenterY()
                ,imageButtonCustoms[0].getCenterX() ,imageButtonCustoms[1].getCenterY(),paint);// left Bottom Corner to Top of it.


        canvas.drawLine(imageButtonCustoms[1].getCenterX(),imageButtonCustoms[1].getCenterY()
                ,imageButtonCustoms[0].getCenterX() ,imageButtonCustoms[1].getCenterY(),paint);// right top Corner to Left Top Corner
        canvas.drawLine(imageButtonCustoms[1].getCenterX(),imageButtonCustoms[1].getCenterY()
                ,imageButtonCustoms[1].getCenterX() ,imageButtonCustoms[0].getCenterY(),paint);// right top Corner to Bottom of it.


        canvas.drawLine(imageButtonCustoms[2].getCenterX(),imageButtonCustoms[2].getCenterY(),
                imageButtonCustoms[0].getCenterX(),imageButtonCustoms[0].getCenterY(),paint); // centre to Bottom left corner

        canvas.drawLine(imageButtonCustoms[2].getCenterX(),imageButtonCustoms[2].getCenterY(),
                imageButtonCustoms[1].getCenterX(),imageButtonCustoms[0].getCenterY(),paint);  // centre to Bottom right corner

        canvas.drawLine(imageButtonCustoms[2].getCenterX(),imageButtonCustoms[2].getCenterY(),
                imageButtonCustoms[0].getCenterX(),imageButtonCustoms[1].getCenterY(),paint); // centre to Top left corner

        canvas.drawLine(imageButtonCustoms[2].getCenterX(),imageButtonCustoms[2].getCenterY(),
                imageButtonCustoms[1].getCenterX(),imageButtonCustoms[1].getCenterY(),paint); // centre to Top Right corner


        */



    }
}

