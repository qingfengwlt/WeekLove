package pc.wlt.com.superlibrary.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;

import java.lang.reflect.Field;

/**
 * Created by PC_WLT on 2017/3/31.
 */

public class CheckOverSizeTextView extends android.support.v7.widget.AppCompatTextView{




    protected boolean isOverSize;
    private OnOverSizeChangedListener changedListener;
    private boolean isShowAll=false;

    public CheckOverSizeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CheckOverSizeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CheckOverSizeTextView(Context context) {
        super(context);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (changedListener != null) {
            changedListener.onChanged(checkOverLine());
        }
    }

    private void init() {
        // invalidate when layout end
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                if (changedListener != null) {
                    changedListener.onChanged(checkOverLine());
                }
            }
        });
    }

    /**
     * <p>
     * <span style="color: purple;">
     * <em>check if the text content has ellipsis </em></span>
     * </p>
     *
     * @return if the text content over maxlines
     */
    public boolean checkOverLine() {
        int maxLine = getMaxLines();
        try {
            Field field = getClass().getSuperclass().getDeclaredField("mLayout");
            field.setAccessible(true);
            Layout mLayout = (Layout) field.get(this);
            if (mLayout == null)
                return false;
            isOverSize = mLayout.getEllipsisCount(maxLine - 1) > 0 ? true : false;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return isOverSize;
    }

    public boolean isOverSize() {
        return isOverSize;
    }

    public void displayAll() {
        setMaxLines(Integer.MAX_VALUE);
        setEllipsize(null);
    }

    public void hide(int maxlines) {
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(maxlines);
    }

    // set a listener for callback
    public OnOverSizeChangedListener getChangedListener() {
        return changedListener;
    }

    public void setOnOverLineChangedListener(OnOverSizeChangedListener changedListener) {
        this.changedListener = changedListener;
    }

    public interface OnOverSizeChangedListener {
        /**
         * <span style="color:purple">when invalide,the method will be called
         * and tell you whether the content text is over size
         *
         */
        public void onChanged(boolean isOverSize);
    };
}
