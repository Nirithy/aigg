package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.i;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;

class io implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, View.OnClickListener {
    private static String a;
    private AlertDialog b;
    private EditText c;

    static {
        io.a = "";
    }

    private io() {
    }

    io(io io0) {
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            this.onClick(((AlertDialog)dialogInterface0).getButton(-1));
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == null || view0.getTag() instanceof pj) {
            View view1 = i.a(0x7F040021, null);  // layout:service_goto
            TextView textView0 = (TextView)view1.findViewById(0x7F0B011D);  // id:addr
            Tools.j(textView0);
            textView0.setOnClickListener(this);
            EditText editText0 = (EditText)view1.findViewById(0x7F0B0065);  // id:mem_edit_addr
            this.c = editText0;
            RegionList regionList0 = (RegionList)view1.findViewById(0x7F0B0004);  // id:region_from
            regionList0.setTag(editText0);
            ip ip0 = new ip(this, regionList0);
            view1.findViewById(0x7F0B011F).setOnClickListener(ip0);  // id:cd
            view1.findViewById(0x7F0B0120).setOnClickListener(ip0);  // id:cb
            view1.findViewById(0x7F0B0121).setOnClickListener(ip0);  // id:ps
            view1.findViewById(0x7F0B0122).setOnClickListener(ip0);  // id:xa
            view1.findViewById(0x7F0B011E).setOnClickListener(this);  // id:history
            editText0.setText("");
            editText0.setDataType(1);
            AlertDialog alertDialog0 = android.ext.i.c().setView(InternalKeyboard.a(view1)).setPositiveButton(qk.a(0x7F07008D), this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:goto1 "Goto"
            this.b = alertDialog0;
            android.ext.i.a(alertDialog0, this);
            android.ext.i.a(alertDialog0, this);
            android.ext.i.a(alertDialog0, editText0);
            return;
        }
        switch(view0.getId()) {
            case 0x7F0B011D: {  // id:addr
                android.ext.i.a(android.ext.i.c().setMessage(qk.a(0x7F07018E) + ":\nBAFE890\nBAFE890+3F0\nBAFE890-A40\nBAFE890+FE-CD7+44-3E\n\nlibc.so\nlibc.so+E0\nlibc.so-32C").setPositiveButton(qk.a(0x7F07012B), ConfigListAdapter.h()).setNegativeButton(qk.a(0x7F0700A1), null));  // string:examples "Examples"
                return;
            }
            case 0x7F0B011E: {  // id:history
                Tools.a(this.b);
                MainService.instance.L.b();
                return;
            }
            default: {
                try {
                    EditText editText1 = this.c;
                    if(editText1 != null) {
                        String s = re.c(editText1.getText().toString().trim());
                        iw.a(s, 1);
                        MainService.instance.a(null, s, Tools.c(0x7F070250));  // string:from_goto "Call goto"
                    }
                    Tools.a(this.b);
                }
                catch(NumberFormatException numberFormatException0) {
                    re.a(numberFormatException0, this.c);
                }
            }
        }
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        EditText editText0 = this.c;
        if(editText0 != null) {
            io.a = editText0.getText().toString().trim();
        }
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this, this.c);
    }
}

