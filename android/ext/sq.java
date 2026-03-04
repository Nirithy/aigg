package android.ext;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

class sq implements Runnable {
    private final View a;

    sq(View view0) {
        this.a = view0;
        super();
    }

    @Override
    public void run() {
        try {
            if(Tools.c == null) {
                Tools.c = (InputMethodManager)MainService.context.getSystemService("input_method");
            }
            if(this.a != null) {
                Tools.c.hideSoftInputFromWindow(this.a.getWindowToken(), 0);
            }
        }
        catch(Throwable throwable0) {
            la.c("hideSoftInputFromWindow", throwable0);
        }
    }
}

