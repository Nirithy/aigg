package android.ext;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;

class uh implements TextWatcher {
    final ug a;
    private final CheckBox b;
    private final CheckBox c;

    uh(ug ug0, CheckBox checkBox0, CheckBox checkBox1) {
        this.a = ug0;
        this.b = checkBox0;
        this.c = checkBox1;
        super();
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        this.b.setChecked(true);
        if(this.c != null) {
            this.c.setChecked(true);
        }
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }
}

