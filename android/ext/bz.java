package android.ext;

import android.content.Context;
import android.fix.TextView;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;

class bz extends TextView implements View.OnTouchListener {
    String a;
    int b;
    int c;

    public bz(Context context0, String s, int v, int v1) {
        super(context0);
        this.a = s;
        this.b = v;
        this.c = v1;
        this.setTextColor(Color.rgb(0xFF, 0xFF, 0xFF));
        this.setText(s);
        this.setOnTouchListener(this);
    }

    @Override  // android.view.View
    protected boolean dispatchGenericFocusedEvent(MotionEvent motionEvent0) {
        la.a(("TestButton: dispatchGenericFocusedEvent for " + this.a + ": " + motionEvent0), new RuntimeException());
        return super.dispatchGenericFocusedEvent(motionEvent0);
    }

    @Override  // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent0) {
        la.a(("TestButton: dispatchGenericMotionEvent for " + this.a + ": " + motionEvent0), new RuntimeException());
        return super.dispatchGenericMotionEvent(motionEvent0);
    }

    @Override  // android.view.View
    protected boolean dispatchGenericPointerEvent(MotionEvent motionEvent0) {
        la.a(("TestButton: dispatchGenericPointerEvent for " + this.a + ": " + motionEvent0), new RuntimeException());
        return super.dispatchGenericPointerEvent(motionEvent0);
    }

    @Override  // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        la.a(("TestButton: dispatchKeyEvent for " + this.a + ": " + keyEvent0), new RuntimeException());
        return super.dispatchKeyEvent(keyEvent0);
    }

    @Override  // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        la.a(("TestButton: dispatchTouchEvent for " + this.a + ": " + motionEvent0), new RuntimeException());
        return super.dispatchTouchEvent(motionEvent0);
    }

    @Override  // android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent0) {
        la.a(("TestButton: dispatchTrackballEvent for " + this.a + ": " + motionEvent0), new RuntimeException());
        return super.dispatchTrackballEvent(motionEvent0);
    }

    @Override  // android.widget.TextView
    public boolean onGenericMotionEvent(MotionEvent motionEvent0) {
        la.a(("TestButton: onGenericMotionEvent for " + this.a + ": " + motionEvent0), new RuntimeException());
        return super.onGenericMotionEvent(motionEvent0);
    }

    @Override  // android.view.View$OnTouchListener
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        la.a(("TestButton: onTouch for " + this.a + ": " + motionEvent0), new RuntimeException());
        return false;
    }

    @Override  // android.fix.TextView
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        la.a(("TestButton: onTouchEvent for " + this.a + ": " + motionEvent0), new RuntimeException());
        return super.onTouchEvent(motionEvent0);
    }
}

