package android.fix;

import android.annotation.TargetApi;
import android.content.Context;
import android.ext.MainService;
import android.ext.ho;
import android.ext.la;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public class ListView extends android.widget.ListView {
    public ListView(Context context0) {
        super(context0);
    }

    public ListView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public ListView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @TargetApi(21)
    public ListView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
    }

    @Override  // android.widget.ListView
    protected void dispatchDraw(Canvas canvas0) {
        try {
            super.dispatchDraw(canvas0);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
        }
    }

    @Override  // android.view.ViewGroup
    public boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        boolean z1;
        boolean z;
        try {
            z = super.dispatchTouchEvent(motionEvent0);
            z1 = false;
        }
        catch(OutOfMemoryError | IndexOutOfBoundsException | NullPointerException outOfMemoryError0) {
            la.a(outOfMemoryError0);
            z1 = true;
            z = false;
        }
        if(z1) {
            MainService.H();
        }
        return z;
    }

    @Override  // android.widget.AbsListView
    public void draw(Canvas canvas0) {
        try {
            super.draw(canvas0);
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.a(arrayIndexOutOfBoundsException0);
        }
    }

    @Override  // android.widget.ListView
    protected void layoutChildren() {
        try {
            super.layoutChildren();
        }
        catch(IllegalStateException illegalStateException0) {
            la.b("Layout failed 1", illegalStateException0);
            ListAdapter listAdapter0 = this.getAdapter();
            if(listAdapter0 instanceof BaseAdapter) {
                ((BaseAdapter)listAdapter0).notifyDataSetChanged();
                try {
                    super.layoutChildren();
                }
                catch(IllegalStateException illegalStateException1) {
                    la.b("Layout failed 2", illegalStateException1);
                }
            }
        }
    }

    @Override  // android.widget.AbsListView
    protected void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
        }
        catch(StackOverflowError stackOverflowError0) {
            la.a(stackOverflowError0);
        }
        View view0 = this.getEmptyView();
        if(view0 != null) {
            this.setEmptyView(view0);
        }
    }

    @Override  // android.widget.AbsListView
    protected void onLayout(boolean z, int v, int v1, int v2, int v3) {
        try {
            super.onLayout(z, v, v1, v2, v3);
        }
        catch(NoSuchMethodError | NullPointerException noSuchMethodError0) {
            la.a(noSuchMethodError0);
        }
    }

    @Override  // android.widget.ListView
    protected void onMeasure(int v, int v1) {
        try {
            super.onMeasure(v, v1);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            ho.a(Thread.currentThread(), throwable0, false);
        }
    }

    @Override  // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        try {
            super.setFastScrollEnabled(z);
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

