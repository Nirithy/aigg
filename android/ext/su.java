package android.ext;

import android.view.View;
import android.view.ViewParent;

class su implements Runnable {
    private final View a;

    su(View view0) {
        this.a = view0;
        super();
    }

    @Override
    public void run() {
        ViewParent viewParent0 = this.a.getParent();
        if(viewParent0 instanceof Tools.ViewWrapper) {
            Tools.b(((Tools.ViewWrapper)viewParent0));
            ((Tools.ViewWrapper)viewParent0).removeAllViews();
        }
    }
}

