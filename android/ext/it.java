package android.ext;

import android.text.Editable;

class it implements cv {
    final is a;
    private final ct b;
    private final long c;
    private final EditText d;
    private final int e;
    private final int f;
    private final Editable g;

    it(is is0, ct ct0, long v, EditText editText0, int v1, int v2, Editable editable0) {
        this.a = is0;
        this.b = ct0;
        this.c = v;
        this.d = editText0;
        this.e = v1;
        this.f = v2;
        this.g = editable0;
        super();
    }

    @Override  // android.ext.cv
    public void a(int v) {
        this.b.a(null);
        String s = Tools.a("%,d", new Object[]{((long)(this.c ^ Config.s))});
        try {
            this.d.setSelection(this.e, this.f);
            this.g.replace(this.e, this.f, s);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            la.b("Failed replace text", indexOutOfBoundsException0);
            this.d.setText(s);
        }
        this.d.requestFocus();
    }
}

