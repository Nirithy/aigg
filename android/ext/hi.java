package android.ext;

import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;

class hi implements CompoundButton.OnCheckedChangeListener {
    final he a;

    hi(he he0) {
        this.a = he0;
        super();
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        if(z) {
            this.a.b.setChecked(false);
        }
    }
}

