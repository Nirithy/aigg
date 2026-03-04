package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

class qp implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, View.OnClickListener {
    final qo a;
    private AlertDialog b;
    private EditText c;

    private qp(qo qo0) {
        this.a = qo0;
        super();
    }

    qp(qo qo0, qp qp0) {
        this(qo0);
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        qm qm0;
        EditText editText0 = this.c;
        if(editText0 != null) {
            String s = editText0.getText().toString().trim();
            if(Tools.o(s)) {
                if(MainService.instance.h != null) {
                    i.a(i.c().setCustomTitle(Tools.d(0x7F0700AE)).setMessage(qk.a(0x7F0702E5)).setPositiveButton(qk.a(0x7F0702E7), new qq(this, v)).setNegativeButton(qk.a(0x7F07009C), null));  // string:error "Error"
                    return;
                }
                try {
                    qm0 = new qm(s);
                }
                catch(Throwable throwable0) {
                    i.a(i.c().setCustomTitle(Tools.d(0x7F0700AE)).setMessage(s + "\n\n" + throwable0.toString()).setPositiveButton(qk.a(0x7F07009D), null));  // string:error "Error"
                    return;
                }
                iw.a(s, 4);
                MainService.instance.b(qm0);
                Tools.a(this.b);
            }
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == null || view0.getTag() instanceof pj) {
            if(!MainService.instance.k.y()) {
                return;
            }
            View view1 = android.fix.i.a(0x7F040015, null);  // layout:save
            ((TextView)view1.findViewById(0x7F0B000E)).setText(qk.a(0x7F0702E3));  // id:message
            EditTextPath editTextPath0 = (EditTextPath)view1.findViewById(0x7F0B000F);  // id:file
            this.c = editTextPath0;
            editTextPath0.setText(qd.a("record-path", "-record", ".lua"));
            editTextPath0.setDataType(4);
            editTextPath0.setPathType(2);
            view1.findViewById(0x7F0B000B).setTag(editTextPath0);  // id:path_selector
            AlertDialog alertDialog0 = i.c().setView(InternalKeyboard.c(view1, false)).setPositiveButton(qk.a(0x7F0702E4), this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:record "Record"
            i.a(alertDialog0, this);
            i.a(alertDialog0, this);
            this.b = alertDialog0;
            i.a(alertDialog0, editTextPath0);
            return;
        }
        this.onClick(null, -1);
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        EditText editText0 = this.c;
        if(editText0 != null) {
            qd.a(editText0.getText().toString(), "record-path", "-record", ".lua");
        }
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this);
    }
}

