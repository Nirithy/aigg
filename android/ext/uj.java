package android.ext;

import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;

class uj implements CompoundButton.OnCheckedChangeListener {
    final ug a;
    private final CheckBox b;

    uj(ug ug0, CheckBox checkBox0) {
        this.a = ug0;
        this.b = checkBox0;
        super();
    }

    @Override  // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton0, boolean z) {
        if(z) {
            this.b.setChecked(true);
        }
    }
}

