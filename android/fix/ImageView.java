package android.fix;

import android.annotation.TargetApi;
import android.content.Context;
import android.ext.ho;
import android.ext.la;
import android.graphics.Canvas;
import android.util.AttributeSet;

public class ImageView extends android.widget.ImageView {
    public ImageView(Context context0) {
        super(context0);
    }

    public ImageView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public ImageView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @TargetApi(21)
    public ImageView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    @Override  // android.widget.ImageView
    protected void onDraw(Canvas canvas0) {
        try {
            super.onDraw(canvas0);
        }
        catch(NoSuchFieldError noSuchFieldError0) {
            la.a(noSuchFieldError0);
        }
        catch(RuntimeException runtimeException0) {
            la.a(runtimeException0);
        }
    }

    @Override  // android.widget.ImageView
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

