package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class tw implements DialogInterface.OnClickListener, View.OnClickListener {
    private final String[] a;
    private final String[] b;
    private EditText c;

    public tw(String[] arr_s, String[] arr_s1) {
        this.a = arr_s;
        this.b = arr_s1;
        if(arr_s.length != arr_s1.length) {
            throw new IllegalArgumentException("Params must be with same length: " + arr_s.length + " != " + arr_s1.length);
        }
    }

    public static void a(Button button0, EditText editText0) {
        String s1;
        String s;
        try {
            s = Tools.e().getFilesDir().getAbsolutePath();
        }
        catch(Throwable throwable0) {
            la.b("Failed get files dir", throwable0);
            s = "error";
        }
        try {
            s1 = Tools.e().getExternalFilesDir(null).getAbsolutePath();
        }
        catch(Throwable throwable1) {
            s1 = "error";
            la.b("Failed get ext files dir", throwable1);
        }
        button0.setOnClickListener(new tw(new String[]{qk.a(0x7F0701A0), qk.a(0x7F0701A1)}, new String[]{s, s1}));  // string:internal_storage "Internal storage"
        button0.setTag(editText0);
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v < 0 || v >= this.b.length) {
            la.b(("Bad index: " + v + " for " + this.b.length), new IndexOutOfBoundsException());
            return;
        }
        if(this.c == null) {
            la.b("Unkwnon edit", new NullPointerException());
            return;
        }
        this.c.setText(this.b[v]);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == null) {
            la.b("Unkwnon view", new NullPointerException());
            return;
        }
        Object object0 = view0.getTag();
        if(!(object0 instanceof EditText)) {
            la.b(("Unkwnon tag: " + object0), new IllegalArgumentException());
            return;
        }
        this.c = (EditText)object0;
        i.a(i.c().setCustomTitle(Tools.d(0x7F07025D)).setItems(this.a, this).setNegativeButton(qk.a(0x7F0700A1), null));  // string:typical_values "Typical values"
    }
}

