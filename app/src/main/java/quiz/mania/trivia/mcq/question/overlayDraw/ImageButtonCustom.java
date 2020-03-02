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
    private RingLocation ringLocation;


    public ImageButtonCustom(Context context,RelativeLayout rootView,RingLocation ringLocation){
        super(context);
        this.rootView = rootView;
        this.ringLocation = ringLocation;
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
        ///setOnTouchListener(this);

        setOnTouchListener(new OnDragTouchListener(this, rootView, new OnDragTouchListener.OnDragActionListener() {
            @Override
            public void onDragStart(View view) {

            }

            @Override
            public void onDragEnd(View view) {
                rootView.invalidate();
            }
        }));

        /*RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        rl.addRule(RelativeLayout.ALIGN_BOTTOM);*/

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        switch (ringLocation){
            case BOTTOM_LEFT:
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
                break;
            case TOP_RIGHT:
                params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
                break;
            case CENTER:
                params.addRule(RelativeLayout.CENTER_IN_PARENT,RelativeLayout.TRUE);
                break;
        }
        rootView.addView(this,params);
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

    public interface OnMoveListener{
        void onMove(Position positionXY);
    }

    public enum RingLocation{
        BOTTOM_LEFT,TOP_RIGHT,CENTER
    }
}
