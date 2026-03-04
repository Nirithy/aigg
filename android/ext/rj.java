package android.ext;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;

class rj implements View.OnTouchListener {
    final ShowApp a;

    rj(ShowApp showApp0) {
        this.a = showApp0;
        super();
    }

    @Override  // android.view.View$OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view0, MotionEvent motionEvent0) {
        switch(motionEvent0.getAction()) {
            case 0: {
                this.a.a(true);
                return true;
            }
            case 1: 
            case 3: {
                this.a.a(false);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

