package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;

class hz implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, View.OnClickListener, View.OnLongClickListener {
    final hy a;
    private AlertDialog b;
    private EditText c;
    private EditText d;
    private CheckBox e;
    private CheckBox f;
    private CheckBox g;
    private Button h;
    private View i;

    private hz(hy hy0) {
        this.a = hy0;
        super();
    }

    hz(hy hy0, hz hz0) {
        this(hy0);
    }

    private void a() {
        boolean z = hy.a;
        this.h.setText(qk.a((z ? 0x7F070157 : 0x7F070156)));  // string:less "Less"
        this.i.setVisibility((z ? 0 : 8));
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        hy.b = this.e.isChecked();
        hy.c = this.f.isChecked();
        hy.d = this.g.isChecked();
        int v1 = 0;
        String s = this.d.getText().toString().trim();
        if(!hy.a) {
        label_13:
            iw.a(s, 4);
            EditText editText0 = this.c;
            if(editText0 != null) {
                String s1 = editText0.getText().toString().trim();
                if(Tools.o(s1) && Tools.b(s1)) {
                    iw.a(s1, 4);
                    if(MainService.instance.d != null) {
                        i.a(i.c().setCustomTitle(Tools.d(0x7F0700AE)).setMessage(qk.a(0x7F070218)).setPositiveButton(qk.a(0x7F070219), new ia(this, v)).setNegativeButton(qk.a(0x7F07009C), null));  // string:error "Error"
                        return;
                    }
                    MainService.instance.a(s1, v1, s);
                    Tools.a(this.b);
                    qm qm0 = MainService.instance.h;
                    if(qm0 != null) {
                        qm0.write("loadfile(");
                        Script.Consts.a(qm0, s1);
                        qm0.write(")()\n");
                    }
                }
            }
        }
        else if(Tools.o(s)) {
            if(hy.b) {
                v1 = 1;
            }
            if(hy.c) {
                v1 |= 2;
            }
            if(hy.d) {
                v1 |= 4;
            }
            goto label_13;
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        String s;
        if(view0 == null || view0.getTag() instanceof pj) {
            if(!MainService.instance.k.y()) {
                return;
            }
            View view1 = android.fix.i.a(0x7F040003, null);  // layout:execute
            ((TextView)view1.findViewById(0x7F0B000E)).setText(qk.a(0x7F070216));  // id:message
            EditTextPath editTextPath0 = (EditTextPath)view1.findViewById(0x7F0B000F);  // id:file
            this.c = editTextPath0;
            editTextPath0.setText(qd.a("script-path", "-script", ".lua"));
            editTextPath0.setDataType(4);
            editTextPath0.setPathType(1);
            view1.findViewById(0x7F0B0010).setTag(editTextPath0);  // id:file_selector
            Config.a(((ImageView)view1.findViewById(0x7F0B0011))).setOnClickListener(this);  // id:examples
            view1.findViewById(0x7F0B0012).setOnClickListener(new be("kwws=22jdphjxdugldq1qhw2iruxp2ilohv2fdwhjru|290oxd0vfulswv2"));  // id:download_scripts
            view1.findViewById(0x7F0B0013).setOnClickListener(new be("kwws=22jdphjxdugldq1qhw2khos2"));  // id:help
            view1.findViewById(0x7F0B0014).setOnClickListener(this);  // id:help_extract
            this.i = view1.findViewById(0x7F0B0015);  // id:debug
            EditTextPath editTextPath1 = (EditTextPath)view1.findViewById(0x7F0B000A);  // id:path
            this.d = editTextPath1;
            editTextPath1.setText(qd.a(null, "script-debug"));
            editTextPath1.setDataType(4);
            editTextPath1.setPathType(0);
            view1.findViewById(0x7F0B000B).setTag(editTextPath1);  // id:path_selector
            CheckBox checkBox0 = (CheckBox)view1.findViewById(0x7F0B0016);  // id:disassemble
            this.e = checkBox0;
            checkBox0.setChecked(hy.b);
            Tools.j(checkBox0);
            checkBox0.setOnLongClickListener(this);
            CheckBox checkBox1 = (CheckBox)view1.findViewById(0x7F0B0017);  // id:load
            this.f = checkBox1;
            checkBox1.setChecked(hy.c);
            CheckBox checkBox2 = (CheckBox)view1.findViewById(0x7F0B0018);  // id:log
            this.g = checkBox2;
            checkBox2.setChecked(hy.d);
            Button button0 = (Button)view1.findViewById(0x7F0B0019);  // id:ext_btn
            this.h = button0;
            button0.setOnClickListener(this);
            this.a();
            AlertDialog alertDialog0 = i.c().setView(InternalKeyboard.c(view1, false)).setPositiveButton(qk.a(0x7F070217), this).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:execute "Execute"
            i.a(alertDialog0, this);
            i.a(alertDialog0, this);
            this.b = alertDialog0;
            i.a(alertDialog0, editTextPath0);
            return;
        }
        switch(view0.getId()) {
            case 0x7F0B0011: {  // id:examples
                new Script("print(\'gg =\', gg)", 0, "").c_();
                return;
            }
            case 0x7F0B0014: {  // id:help_extract
                File file0 = new File(Tools.r(), "help.zip");
                try {
                    Tools.a("he", file0);
                    s = null;
                }
                catch(RuntimeException runtimeException0) {
                    s = runtimeException0.getMessage();
                }
                i.a(i.c().setCustomTitle(Tools.d(0x7F070245)).setMessage((s == null ? Tools.a(qk.a(0x7F070246), new Object[]{file0.getAbsolutePath()}) : Tools.c(0x7F070247) + ": " + s)).setNegativeButton(qk.a(0x7F07009D), null));  // string:help_extract "Extract the help"
                return;
            }
            case 0x7F0B0019: {  // id:ext_btn
                hy.a = !hy.a;
                this.a();
                return;
            }
            default: {
                this.onClick(null, -1);
            }
        }
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        EditText editText0 = this.c;
        if(editText0 != null) {
            qd.a(editText0.getText().toString(), "script-path", "-script", ".lua");
        }
        EditText editText1 = this.d;
        if(editText1 != null) {
            qd.a(editText1.getText().toString().trim(), "script-debug");
        }
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        if(view0 != null && view0.getId() == 0x7F0B0016) {  // id:disassemble
            ConfigListAdapter.b(0x7F070342);  // string:help_lasm "__app_name__ has a built-in disassembler / assembler for Lua scripts.\n\nYou 
                                              // can select the \"__debug_disassemble__\" option in the script launch window, after 
                                              // clicking the \"__more__\" button.\n\nThe resulting __ext_lasm__ file can be edited 
                                              // and selected in the script launch window. The result will be a binary __ext_lua__ 
                                              // file, with the changes made.\n\nRead the script API help for more details.\n    
                                              // "
            return true;
        }
        return false;
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this);
    }
}

