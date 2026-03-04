package android.ext;

import android.view.View.OnFocusChangeListener;
import android.view.View;
import java.util.ArrayList;

class tl implements View.OnFocusChangeListener {
    private final ArrayList a;

    private tl() {
        this.a = new ArrayList();
    }

    tl(tl tl0) {
    }

    void a(View.OnFocusChangeListener view$OnFocusChangeListener0) {
        if(view$OnFocusChangeListener0 == null || this.a.contains(view$OnFocusChangeListener0)) {
            return;
        }
        this.a.add(view$OnFocusChangeListener0);
    }

    @Override  // android.view.View$OnFocusChangeListener
    public void onFocusChange(View view0, boolean z) {
        for(Object object0: this.a) {
            ((View.OnFocusChangeListener)object0).onFocusChange(view0, z);
        }
    }
}

