package android.fix;

import android.annotation.TargetApi;
import android.content.Context;
import android.ext.Tools;
import android.ext.ho;
import android.ext.la;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ScrollView extends android.widget.ScrollView {
    private boolean a;
    private long b;
    private static final long c;
    private int d;

    static {
        ScrollView.c = 100L;
    }

    public ScrollView(Context context0) {
        super(context0);
        this.a = false;
        this.b = -1L;
        this.d = 1;
    }

    public ScrollView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = false;
        this.b = -1L;
        this.d = 1;
    }

    public ScrollView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = false;
        this.b = -1L;
        this.d = 1;
    }

    @TargetApi(23)
    public ScrollView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.a = false;
        this.b = -1L;
        this.d = 1;
    }

    private void a() {
        this.b = -1L;
    }

    private boolean a(float f) {
        return f >= ((float)(this.getWidth() - Tools.b()));
    }

    private int b(float f) {
        int v = this.getHeight();
        int v1 = Tools.b();
        float f1 = (float)this.getChildAt(0).getHeight();
        return (int)Math.min(Math.max((f - ((float)(v1 / 2))) / (((float)(v - 1)) - 2.0f * ((float)(v1 / 2))) * f1, 0.0f), f1);
    }

    private void b() {
        this.b = SystemClock.uptimeMillis() + ScrollView.c;
    }

    private void c() {
        this.b = -1L;
        this.d = 2;
        this.requestDisallowInterceptTouchEvent(true);
        this.d();
    }

    private void d() {
        MotionEvent motionEvent0 = MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        this.onTouchEvent(motionEvent0);
        motionEvent0.recycle();
    }

    @Override  // android.widget.ScrollView
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            la.a(illegalArgumentException0);
        }
    }

    @Override  // android.widget.ScrollView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        if(this.a) {
            switch(motionEvent0.getActionMasked()) {
                case 0: {
                    if(this.a(motionEvent0.getX())) {
                        this.b();
                        return super.onInterceptTouchEvent(motionEvent0);
                    }
                    break;
                }
                case 2: {
                    if(!this.a(motionEvent0.getX())) {
                        this.a();
                        return super.onInterceptTouchEvent(motionEvent0);
                    }
                    if(this.b >= 0L && this.b <= SystemClock.uptimeMillis()) {
                        this.c();
                        this.scrollTo(this.getScrollX(), this.b(motionEvent0.getY()));
                        return this.onTouchEvent(motionEvent0);
                    }
                    break;
                }
                case 1: 
                case 3: {
                    this.a();
                    return super.onInterceptTouchEvent(motionEvent0);
                }
                default: {
                    return super.onInterceptTouchEvent(motionEvent0);
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent0);
    }

    @Override  // android.widget.ScrollView
    protected void onMeasure(int v, int v1) {
        try {
            super.onMeasure(v, v1);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            ho.a(Thread.currentThread(), throwable0, false);
        }
    }

    @Override  // android.widget.ScrollView
    protected boolean onRequestFocusInDescendants(int v, Rect rect0) {
        try {
            return super.onRequestFocusInDescendants(v, rect0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
        }
    }

    @Override  // android.widget.ScrollView
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        if(this.a) {
            switch(motionEvent0.getActionMasked()) {
                case 0: {
                    if(this.a(motionEvent0.getX())) {
                        this.c();
                        return true;
                    }
                    break;
                }
                case 1: {
                    if(this.b >= 0L) {
                        this.c();
                        this.scrollTo(this.getScrollX(), this.b(motionEvent0.getY()));
                    }
                    if(this.d == 2) {
                        this.requestDisallowInterceptTouchEvent(false);
                        this.d = 1;
                        return true;
                    }
                    break;
                }
                case 2: {
                    if(this.b >= 0L) {
                        this.c();
                    }
                    if(this.d == 2) {
                        this.scrollTo(this.getScrollX(), this.b(motionEvent0.getY()));
                        return true;
                    }
                    break;
                }
                case 3: {
                    this.a();
                }
            }
        }
        try {
            return super.onTouchEvent(motionEvent0);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return false;
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

    public void setFastScrollEnabled(boolean z) {
        this.a = z;
        if(Build.VERSION.SDK_INT >= 16) {
            this.setScrollBarSize(Tools.b() / 2);
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

