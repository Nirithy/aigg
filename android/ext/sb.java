package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.i;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class sb implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, TextWatcher, View.OnClickListener {
    EditText a;
    TextView b;
    TextView c;
    AlertDialog d;
    final rz e;

    private sb(rz rz0) {
        this.e = rz0;
        super();
    }

    sb(rz rz0, sb sb0) {
        this(rz0);
    }

    public void a() {
        String s;
        EditText editText0 = this.a;
        TextView textView0 = this.b;
        if(editText0 == null) {
            s = "?";
        }
        else {
            try {
                s = Tools.a(rz.a(editText0.getText().toString().trim()) / 1000000000L);
            }
            catch(NumberFormatException unused_ex) {
                s = "???";
            }
        }
        if(textView0 != null) {
            textView0.setText(s);
        }
    }

    @Override  // android.text.TextWatcher
    public void afterTextChanged(Editable editable0) {
        this.a();
    }

    @Override  // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            String s = re.c(this.a.getText().toString().trim());
            rz.a(rz.a(s));
            iw.a(s, 1);
            Tools.a(dialogInterface0);
        }
        catch(NumberFormatException numberFormatException0) {
            re.a(numberFormatException0, this.a);
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == null || view0.getTag() instanceof pj) {
            View view1 = i.a(0x7F040029, null);  // layout:time_jump
            Config.a(((ImageView)view1.findViewById(0x7F0B0011))).setOnClickListener(this);  // id:examples
            this.b = (TextView)view1.findViewById(0x7F0B002C);  // id:hint
            this.c = (TextView)view1.findViewById(0x7F0B0084);  // id:config_time_jump_panel
            this.c.setOnClickListener(this);
            this.c.setText(Config.a(0x7F0B0084).toString());  // id:config_time_jump_panel
            this.a = (EditText)view1.findViewById(0x7F0B0146);  // id:time_jump
            String s = Tools.a(((double)Config.v) / 1000.0);
            this.a.setText(s);
            this.a.addTextChangedListener(this);
            this.a.setDataType(1);
            this.a();
            this.d = android.ext.i.c().setView(InternalKeyboard.a(view1)).setPositiveButton(qk.a(0x7F07009D), this).setNegativeButton(qk.a(0x7F070249), null).create();  // string:ok "OK"
            android.ext.i.a(this.d, this);
            android.ext.i.a(this.d, this);
            android.ext.i.a(this.d, this.a);
            return;
        }
        switch(view0.getId()) {
            case 0x7F0B0011: {  // id:examples
                Searcher.a(qk.a(0x7F070028));  // string:examples_timejump "\n\"42345678\" = 1 __unit_years_short__ 125 __unit_days_short__ 
                                               // 2 __unit_hours_short__ 41 __unit_minutes_short__ 18 __unit_seconds_short__\n\"1:125:2:41:18\" 
                                               // = 1 __unit_years_short__ 125 __unit_days_short__ 2 __unit_hours_short__ 41 __unit_minutes_short__ 
                                               // 18 __unit_seconds_short__\n\"5:13\" = 5 __unit_minutes_short__ 13 __unit_seconds_short__\n\"7:3:1\" 
                                               // = 7 __unit_hours_short__ 3 __unit_minutes_short__ 1 __unit_seconds_short__\n\"3600\" 
                                               // = 1 __unit_hours_short__\n\"2:15:54:32\" = 2 __unit_days_short__ 15 __unit_hours_short__ 
                                               // 54 __unit_minutes_short__ 32 __unit_seconds_short__\n\"3600.15\" = 1 __unit_hours_short__ 
                                               // 0.15 __unit_seconds_short__\n\"7:3:1.519\" = 7 __unit_hours_short__ 3 __unit_minutes_short__ 
                                               // 1.519 __unit_seconds_short__\n\n__rtfm__\n    "
                return;
            }
            case 0x7F0B0084: {  // id:config_time_jump_panel
                ct ct0 = Config.a(0x7F0B0084);  // id:config_time_jump_panel
                ct0.a(new sc(this, ct0));
                ct0.d();
                return;
            }
            default: {
                this.onClick(this.d, -1);
            }
        }
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        rz.a = this.a.getText().toString().trim();
        try {
            rz.b(rz.a("0"));
        }
        catch(NumberFormatException unused_ex) {
        }
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this);
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        this.a();
    }
}

