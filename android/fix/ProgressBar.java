package android.fix;

import android.annotation.TargetApi;
import android.content.Context;
import android.ext.ho;
import android.ext.la;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;

public class ProgressBar extends android.widget.ProgressBar {
    public ProgressBar(Context context0) {
        super(context0);
    }

    public ProgressBar(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public ProgressBar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @TargetApi(21)
    public ProgressBar(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    @Override  // android.widget.ProgressBar
    protected void onDraw(Canvas canvas0) {
        synchronized(this) {
            try {
                super.onDraw(canvas0);
            }
            catch(RuntimeException runtimeException0) {
                la.a(runtimeException0);
            }
        }
    }

    @Override  // android.widget.ProgressBar
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
    protected void onVisibilityChanged(View view0, int v) {
        try {
            super.onVisibilityChanged(view0, v);
        }
        catch(RuntimeException runtimeException0) {
            la.a(runtimeException0);
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

    @Override  // android.widget.ProgressBar
    public void setInterpolator(Context context0, int v) {
        try {
            super.setInterpolator(context0, v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.widget.ProgressBar
    public void setInterpolator(Interpolator interpolator0) {
        try {
            super.setInterpolator(interpolator0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    @Override  // android.widget.ProgressBar
    public void setProgress(int v) {
        synchronized(this) {
            try {
                super.setProgress(v);
            }
            catch(NullPointerException nullPointerException0) {
                la.a(nullPointerException0);
            }
        }
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        try {
            super.setVisibility(v);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }
}

