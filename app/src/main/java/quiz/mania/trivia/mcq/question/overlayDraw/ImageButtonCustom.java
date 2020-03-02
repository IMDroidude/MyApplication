package quiz.mania.trivia.mcq.question.overlayDraw;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageButton;

import quiz.mania.trivia.mcq.question.R;


public class ImageButtonCustom extends AppCompatImageButton implements View.OnTouchListener{

    float dX, dY;

    private RelativeLayout rootView;
    private ImageButtonCustom imageButtonCustom;
    private OnMoveListener onMoveListener;

    public ImageButtonCustom(Context context,RelativeLayout rootView){
        super(context);
        this.rootView = rootView;
        init();

    }
    public ImageButtonCustom(Context context) {
        super(context);
        init();
    }

    public ImageButtonCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageButtonCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        imageButtonCustom = this;
        setImageResource(R.mipmap.ic_launcher);
        setBackgroundColor(Color.TRANSPARENT);
        setOnTouchListener(this);

        /*RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        rl.addRule(RelativeLayout.ALIGN_BOTTOM);*/

        rootView.addView(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                dX = v.getX() - event.getRawX();
                dY = v.getY() - event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                v.animate()
                        .x(event.getRawX() + dX)
                        .y(event.getRawY() + dY)
                        .setDuration(0)
                        .start();
                //no use of ViewPositionUtil
                ///onMoveListener.onMove(ViewPositionUtil.getXYPositionRelativeToRoot(imageButtonCustom));//positionXY);
                break;
        }
        rootView.invalidate();
        return true;
    }

    public void setOnMoveListener(OnMoveListener onMoveListener){
        this.onMoveListener = onMoveListener;
    }

    public float getCenterX(){
        return getX() + getWidth()  / 2;

    }
    public float getCenterY(){
        return getY() + getHeight() / 2;
    }

    public float getParentRight(){
        return rootView.getRight() - 60;
    }

    public float getParentTop(){
        return rootView.getTop() + 60;
    }

    public float getParentBottom(){
        return rootView.getBottom() - 60;
    }
    public float getParentLeft() {
        return rootView.getLeft() - 60;
    }

    public interface OnMoveListener{
        void onMove(Position positionXY);
    }
}
