package android.ext;

import android.text.Editable;
import android.text.TextWatcher;

class rg implements TextWatcher {
    final Searcher a;

    rg(Searcher searcher0) {
        this.a = searcher0;
        super();
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        this.a.c();
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        this.a.c();
    }
}

