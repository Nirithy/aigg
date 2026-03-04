package android.ext;

import android.view.View;
import android.view.Window;

class sp implements Runnable {
    private final Window a;

    sp(Window window0) {
        this.a = window0;
        super();
    }

    @Override
    public void run() {
        try {
            View view0 = this.a.getCurrentFocus();
            if(view0 == null) {
                view0 = this.a.peekDecorView();
            }
            if(view0 != null) {
                Tools.e(view0);
            }
        }
        catch(Throwable throwable0) {
            la.c("hideSoftInputFromWindow", throwable0);
        }
    }
}

