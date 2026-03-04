package android.ext;

import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;

class hh implements CompoundButton.OnCheckedChangeListener {
    final he a;

    hh(he he0) {
        this.a = he0;
        super();
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        if(z) {
            this.a.d.setChecked(false);
        }
        this.a.c.setChecked(true);
    }
}

