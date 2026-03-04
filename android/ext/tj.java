package android.ext;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class tj implements TextWatcher {
    final ti a;
    private final CharSequence[] b;
    private final TextView c;
    private final Drawable[] d;
    private final int e;

    tj(ti ti0, CharSequence[] arr_charSequence, TextView textView0, Drawable[] arr_drawable, int v) {
        this.a = ti0;
        this.b = arr_charSequence;
        this.c = textView0;
        this.d = arr_drawable;
        this.e = v;
        super();
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        this.onTextChanged(editable0, 0, 0, 0);
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        try {
            String s = charSequence0.toString();
            for(int v3 = 0; true; ++v3) {
                if(v3 >= this.b.length) {
                    return;
                }
                if(this.b[v3].toString().equals(s)) {
                    Tools.a(this.c, this.d[v3], this.e);
                    return;
                }
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }
}

