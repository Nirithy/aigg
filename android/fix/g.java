package android.fix;

import android.annotation.TargetApi;
import android.content.Context;
import android.ext.ho;
import android.ext.la;
import android.graphics.Canvas;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

public class g extends KeyboardView {
    public static volatile boolean a;

    static {
        g.a = true;
    }

    public g(Context context0, AttributeSet attributeSet0) {
        if(g.a) {
            context0 = new h(context0);
        }
        super(context0, attributeSet0);
    }

    public g(Context context0, AttributeSet attributeSet0, int v) {
        if(g.a) {
            context0 = new h(context0);
        }
        super(context0, attributeSet0, v);
    }

    @TargetApi(21)
    public g(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if(g.a) {
            context0 = new h(context0);
        }
        super(context0, attributeSet0, v, v1);
    }

    @Override  // android.inputmethodservice.KeyboardView
    public void onDraw(Canvas canvas0) {
        try {
            super.onDraw(canvas0);
        }
        catch(OutOfMemoryError outOfMemoryError0) {
            la.a(outOfMemoryError0);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            la.a(illegalArgumentException0);
        }
    }

    @Override  // android.inputmethodservice.KeyboardView
    public void onMeasure(int v, int v1) {
        try {
            super.onMeasure(v, v1);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            ho.a(Thread.currentThread(), throwable0, false);
        }
    }
}

