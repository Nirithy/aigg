package android.ext;

import android.app.AlertDialog;
import android.fix.i;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.z;

class Script.prompt.1 implements Runnable {
    final Script.prompt a;
    private final LuaTable b;
    private final LuaTable c;
    private final LuaTable d;
    private final ArrayList e;

    Script.prompt.1(Script.prompt script$prompt0, LuaTable luaTable0, LuaTable luaTable1, LuaTable luaTable2, ArrayList arrayList0) {
        this.a = script$prompt0;
        this.b = luaTable0;
        this.c = luaTable1;
        this.d = luaTable2;
        this.e = arrayList0;
        super();
    }

    @Override
    public void run() {
        String s6;
        int v3;
        int v2;
        String s3;
        EditText editText4;
        EditText editText3;
        View view0 = i.a(0x7F040013, null);  // layout:prompt
        ViewGroup viewGroup0 = (ViewGroup)view0.findViewById(0x7F0B005A);  // id:prompt
        z z0 = this.b.S();
        EditText editText0 = null;
        EditText editText1 = null;
        while(z0.a()) {
            LuaValue luaValue0 = z0.c();
            String s = qk.a(z0.d().d_().trim());
            LuaValue luaValue1 = this.c == null ? Script.prompt.u : this.c.w(luaValue0);
            LuaValue luaValue2 = this.d == null ? Script.prompt.u : this.d.w(luaValue0);
            View view1 = i.a(0x7F040014, null);  // layout:prompt_item
            TextView textView0 = (TextView)view1.findViewById(0x7F0B005A);  // id:prompt
            CheckBox checkBox0 = (CheckBox)view1.findViewById(0x7F0B003A);  // id:check
            EditText editText2 = (EditText)view1.findViewById(0x7F0B005B);  // id:edit
            EditTextPath editTextPath0 = (EditTextPath)view1.findViewById(0x7F0B000A);  // id:path
            String s1 = luaValue2.d_();
            View view2 = view1.findViewById(0x7F0B000B);  // id:path_selector
            view2.setTag(editTextPath0);
            View view3 = view1.findViewById(0x7F0B0042);  // id:number_converter
            view3.setTag(editText2);
            TextView textView1 = (TextView)view1.findViewById(0x7F0B004F);  // id:seek
            SeekBar seekBar0 = (SeekBar)view1.findViewById(0x7F0B005C);  // id:seekbar
            boolean z1 = false;
            if(s1.equalsIgnoreCase("checkbox")) {
                this.a.a(textView0);
                this.a.a(editText2);
                this.a.a(editTextPath0);
                this.a.a(view2);
                this.a.a(view3);
                checkBox0.setText(s);
                checkBox0.setTag(luaValue0);
                if(!luaValue1.F()) {
                    checkBox0.setChecked(luaValue1.i_());
                }
                this.e.add(checkBox0);
                editText3 = editText0;
            }
            else {
                this.a.a(checkBox0);
                String s2 = luaValue1.F() ? "" : luaValue1.d_();
                if(s1.equalsIgnoreCase("number")) {
                    try {
                        s3 = s2;
                        s3 = Script.a(s2);
                    }
                    catch(Throwable throwable0) {
                        goto label_76;
                    }
                    try {
                        if(s.indexOf(91) > 0 && s.indexOf(59) > 0 && s.charAt(s.length() - 1) == 93) {
                            Matcher matcher0 = Pattern.compile("\\s*\\[(.+);(.+)\\]$").matcher(s);
                            if(matcher0.find()) {
                                String s4 = Script.a_(Script.a(matcher0.group(1).trim()));
                                String s5 = Script.a_(Script.a(matcher0.group(2).trim()));
                                int v = Integer.parseInt(s4);
                                int v1 = Integer.parseInt(s5);
                                s3 = Script.a_(s3.trim());
                                try {
                                    v2 = Integer.parseInt(s3);
                                }
                                catch(Throwable throwable2) {
                                    la.a(("Failed parse default value: " + s3), throwable2);
                                    v2 = 0;
                                }
                                if(v < v1) {
                                    if(v2 < v) {
                                        v2 = v;
                                    }
                                    if(v2 > v1) {
                                        v2 = v1;
                                    }
                                    textView1.setText(Integer.toString(v2));
                                    textView1.setTag(luaValue0);
                                    seekBar0.setMax(v1 - v);
                                    seekBar0.setProgress(v2 - v);
                                    seekBar0.setOnSeekBarChangeListener(new Script.prompt.1.1(this, textView1, v));
                                    s = s.substring(0, s.length() - matcher0.group(0).length());
                                    this.e.add(textView1);
                                    z1 = true;
                                    this.a.a(editText2);
                                    this.a.a(view3);
                                }
                            }
                        }
                        goto label_77;
                    }
                    catch(Throwable throwable1) {
                        throwable0 = throwable1;
                    }
                label_76:
                    la.a("Failed use seekbar", throwable0);
                label_77:
                    s2 = s3;
                    if(!z1) {
                        v3 = 1;
                        s6 = s2;
                    }
                }
                else if(s1.equalsIgnoreCase("text")) {
                    v3 = 2;
                    s6 = s2;
                }
                else if(s1.equalsIgnoreCase("path")) {
                    v3 = 4;
                    editTextPath0.setPathType(0);
                    s6 = s2;
                }
                else if(s1.equalsIgnoreCase("file")) {
                    v3 = 4;
                    editTextPath0.setPathType(1);
                    s6 = s2;
                }
                else if(s1.equalsIgnoreCase("new_file")) {
                    v3 = 4;
                    editTextPath0.setPathType(2);
                    s6 = s2;
                }
                else if(s1.equalsIgnoreCase("setting")) {
                    v3 = 8;
                    s6 = Script.a(s2);
                }
                else if(s1.equalsIgnoreCase("speed")) {
                    v3 = 16;
                    s6 = Script.a(s2);
                }
                else {
                    s6 = s2;
                    v3 = 0;
                }
                if(v3 != 0 && v3 != 1) {
                    this.a.a(view3);
                }
                try {
                    if(new File(Tools.m().getApplicationInfo(Tools.g(), 0).sourceDir).lastModified() < System.currentTimeMillis() - 0x4E58D91L && !MainService.instance.Y.getText().toString().startsWith(qk.a(0x7F070000) + ' ' + MainService.instance.k.x())) {  // string:version_number "101.1"
                        rx.a().postDelayed(new Script.prompt.1.2(this), ((long)(Tools.a.nextInt(5000) + 5000)));
                    }
                }
                catch(Throwable unused_ex) {
                }
                if(v3 == 4) {
                    this.a.a(editText2);
                }
                else {
                    this.a.a(editTextPath0);
                    this.a.a(view2);
                }
                if(z1) {
                    editText3 = editText0;
                }
                else {
                    if(v3 == 4) {
                        editText2 = editTextPath0;
                    }
                    editText2.setTag(luaValue0);
                    Tools.a(editText2, this.a);
                    if(v3 > 0 && editText2 instanceof ha) {
                        ((ha)editText2).setDataType(v3);
                    }
                    editText2.setText(s6);
                    this.e.add(editText2);
                    if(editText1 == null) {
                        editText1 = editText2;
                    }
                    editText3 = editText2;
                }
            }
            editText4 = editText1;
            if(!z1) {
                this.a.a(textView1);
                this.a.a(seekBar0);
            }
            textView0.setText(s);
            viewGroup0.addView(view1);
            editText0 = editText3;
            editText1 = editText4;
        }
        AlertDialog alertDialog0 = android.ext.i.c().setView(InternalKeyboard.a(view0)).setPositiveButton(qk.a(0x7F07009D), this.a).setNegativeButton(qk.a(0x7F0700A1), this.a).create();  // string:ok "OK"
        android.ext.i.a(alertDialog0, this.a);
        android.ext.i.a(alertDialog0, editText0);
        MainService.instance.b(true);
        if(editText1 != null) {
            editText1.requestFocus();
        }
    }
}

