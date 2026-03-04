package android.ext;

import android.view.View.OnFocusChangeListener;
import android.view.View;

public abstract class ku implements View.OnFocusChangeListener {
    protected abstract boolean a(View arg1, boolean arg2);

    @Override  // android.view.View$OnFocusChangeListener
    public void onFocusChange(View view0, boolean z) {
        if((Config.B & 1) != 0) {
            InternalKeyboard internalKeyboard0 = (InternalKeyboard)view0.getRootView().findViewById(0x7F0B002A);  // id:keyboard
            if(internalKeyboard0 != null) {
                boolean z1 = this.a(view0, z);
                if(!z1) {
                    z = false;
                }
                internalKeyboard0.b(view0, z);
                if(!z1) {
                    Tools.e(view0);
                }
            }
        }
    }
}

