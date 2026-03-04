package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.widget.EditText;

class ix implements DialogInterface.OnClickListener {
    private final iy a;
    private final EditText b;

    ix(iy iy0, EditText editText0) {
        this.a = iy0;
        this.b = editText0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        String s = this.a.getItem(v).toString();
        int v1 = Math.max(this.b.getSelectionStart(), 0);
        int v2 = Math.max(this.b.getSelectionEnd(), 0);
        this.b.getText().replace(Math.min(v1, v2), Math.max(v1, v2), s, 0, s.length());
        int v3 = Math.max(this.b.getSelectionStart(), this.b.getSelectionEnd());
        this.b.setSelection(v3);
    }
}

