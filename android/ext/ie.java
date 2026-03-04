package android.ext;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;

class ie implements TextWatcher {
    final id a;
    private final CheckBox b;

    ie(id id0, CheckBox checkBox0) {
        this.a = id0;
        this.b = checkBox0;
        super();
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        this.b.setChecked(true);
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }
}

