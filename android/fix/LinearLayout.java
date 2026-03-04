package android.fix;

import android.content.Context;
import android.content.res.Configuration;
import android.ext.ho;
import android.ext.la;
import android.util.AttributeSet;

public class LinearLayout extends android.widget.LinearLayout {
    public LinearLayout(Context context0) {
        super(context0);
    }

    public LinearLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public LinearLayout(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    public LinearLayout(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    @Override  // android.view.View
    protected void onConfigurationChanged(Configuration configuration0) {
        la.a(("LinearLayout onConfigurationChanged: " + (configuration0 == null ? null : configuration0.toString())));
        super.onConfigurationChanged(d.a(configuration0));
    }

    @Override  // android.widget.LinearLayout
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
}

