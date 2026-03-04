package android.fix;

import android.content.Context;
import android.ext.ho;
import android.ext.la;
import android.util.AttributeSet;

public class HorizontalScrollView extends android.widget.HorizontalScrollView {
    public HorizontalScrollView(Context context0) {
        super(context0);
    }

    public HorizontalScrollView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public HorizontalScrollView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public HorizontalScrollView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    @Override  // android.widget.HorizontalScrollView
    protected void onMeasure(int v, int v1) {
        try {
            super.onMeasure(v, v1);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            ho.a(Thread.currentThread(), throwable0, false);
        }
    }

    @Override  // android.view.View
    public void playSoundEffect(int v) {
        try {
            super.playSoundEffect(v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.view.View
    public void sendAccessibilityEvent(int v) {
        try {
            super.sendAccessibilityEvent(v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.view.View
    public void setOverScrollMode(int v) {
        try {
            super.setOverScrollMode(v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }
}

