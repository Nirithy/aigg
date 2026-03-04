package android.ext;

import android.view.View.OnFocusChangeListener;
import android.view.View;

class ks implements View.OnFocusChangeListener {
    int a;
    private final int b;

    ks(int v) {
        this.b = v;
        super();
        this.a = -1;
    }

    @Override  // android.view.View$OnFocusChangeListener
    public void onFocusChange(View view0, boolean z) {
        if((Config.B & 1) != 0) {
            InternalKeyboard internalKeyboard0 = (InternalKeyboard)view0.getRootView().findViewById(0x7F0B002A);  // id:keyboard
            if(internalKeyboard0 != null) {
                if(this.a == -1) {
                    this.a = internalKeyboard0.getFlags();
                }
                internalKeyboard0.setFlags((z ? this.b : 0) | this.a);
                internalKeyboard0.a();
            }
        }
    }
}

