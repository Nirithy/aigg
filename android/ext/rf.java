package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.text.Editable;
import android.widget.EditText;

class rf implements DialogInterface.OnClickListener {
    private final EditText a;
    private final ak b;

    rf(EditText editText0, ak ak0) {
        this.a = editText0;
        this.b = ak0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Editable editable0 = this.a.getText();
        String s = editable0.toString();
        String s1 = this.b.b;
        if(!s.contains(s1)) {
            return;
        }
        int v1 = s.indexOf(s1);
        editable0.replace(v1, s1.length() + v1, this.b.a);
    }
}

