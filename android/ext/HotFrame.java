package android.ext;

import android.content.Context;
import android.fix.FrameLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.view.ViewConfiguration;

public class HotFrame extends FrameLayout implements View.OnLongClickListener {
    private final Runnable a;

    public HotFrame(Context context0) {
        super(context0);
        this.setHapticFeedbackEnabled(false);
        this.setOnLongClickListener(this);
        this.a = new jf(this);
    }

    public HotFrame(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.setHapticFeedbackEnabled(false);
        this.setOnLongClickListener(this);
        this.a = new jf(this);
    }

    public HotFrame(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.setHapticFeedbackEnabled(false);
        this.setOnLongClickListener(this);
        this.a = new jf(this);
    }

    public HotFrame(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.setHapticFeedbackEnabled(false);
        this.setOnLongClickListener(this);
        this.a = new jf(this);
    }

    @Override  // android.view.ViewGroup
    public boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        try {
            int v = motionEvent0.getAction();
            if(v == 0 || v == 1 || v == 3) {
                this.removeCallbacks(this.a);
            }
        }
        catch(NoSuchMethodError noSuchMethodError0) {
            la.a(noSuchMethodError0);
        }
        try {
            return super.dispatchTouchEvent(motionEvent0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        int v = ViewConfiguration.getLongPressTimeout();
        if(v < 0) {
            v = 0;
        }
        la.a(("Fake long click: " + (750 - v)));
        if(750 - v > 0) {
            this.removeCallbacks(this.a);
            this.postDelayed(this.a, ((long)(750 - v)));
            return true;
        }
        this.a.run();
        return true;
    }
}

