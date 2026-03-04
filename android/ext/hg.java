package android.ext;

import android.text.Editable;
import android.text.TextWatcher;

class hg implements TextWatcher {
    final he a;

    hg(he he0) {
        this.a = he0;
        super();
    }

    private void a() {
        this.a.c.setChecked(true);
        this.a.n();
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        this.a();
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        this.a();
    }
}

