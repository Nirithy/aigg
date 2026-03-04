package android.ext;

import android.text.Editable;
import android.text.TextWatcher;

class iz implements TextWatcher {
    final iy a;
    private final jd b;

    iz(iy iy0, jd jd0) {
        this.a = iy0;
        this.b = jd0;
        super();
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        jc jc0 = this.b.h;
        if(jc0 == null) {
            return;
        }
        je je0 = jc0.a;
        String s = this.b.c.getText().toString();
        this.a.a(je0, s, false);
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }
}

