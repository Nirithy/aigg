package android.fix;

import android.content.Context;
import android.ext.ho;
import android.ext.la;
import android.util.AttributeSet;

public class RadioGroup extends android.widget.RadioGroup {
    public RadioGroup(Context context0) {
        super(context0);
    }

    public RadioGroup(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
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

