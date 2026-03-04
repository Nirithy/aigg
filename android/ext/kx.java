package android.ext;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class kx implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnShowListener, View.OnClickListener, View.OnLongClickListener {
    boolean a;
    private EditText b;
    private RadioGroup c;
    private CheckBox d;
    private AlertDialog e;
    private qh f;
    private qx[] g;
    private static int h;

    static {
        kx.h = -1;
    }

    public kx(qh qh0, qx[] arr_qx) {
        int v = 1;
        super();
        this.a = false;
        if(qh0 == null) {
            i.a(i.c().setCustomTitle(Tools.d(0x7F0700C1)).setMessage(qk.a(0x7F0700BD)).setNegativeButton(qk.a(0x7F07009D), null));  // string:load_list "Load list"
            return;
        }
        if(arr_qx != null && arr_qx.length == 0) {
            i.a(i.c().setMessage(qk.a(0x7F070143)).setNegativeButton(qk.a(0x7F07009D), null));  // string:empty_save "The saved list is empty. There is nothing to save."
            return;
        }
        MainService.instance.k.i();
        this.f = qh0;
        this.g = arr_qx;
        View view0 = android.fix.i.a(0x7F040015, null);  // layout:save
        ((TextView)view0.findViewById(0x7F0B000E)).setText(qk.a((arr_qx == null ? 0x7F0701A4 : 0x7F0701A3)));  // id:message
        EditTextPath editTextPath0 = (EditTextPath)view0.findViewById(0x7F0B000F);  // id:file
        this.b = editTextPath0;
        editTextPath0.setText(qd.a("save-path", "-list", ".txt"));
        editTextPath0.setDataType(4);
        if(arr_qx != null) {
            v = 2;
        }
        editTextPath0.setPathType(v);
        view0.findViewById(0x7F0B000B).setTag(editTextPath0);  // id:path_selector
        if(arr_qx == null) {
            view0.findViewById(0x7F0B005F).setVisibility(0);  // id:load_stuff
        }
        else {
            view0.findViewById(0x7F0B005D).setVisibility(0);  // id:save_stuff
        }
        RadioGroup radioGroup0 = (RadioGroup)view0.findViewById(0x7F0B0060);  // id:mode
        this.c = radioGroup0;
        if(kx.h > 0) {
            radioGroup0.check(kx.h);
        }
        ((RadioButton)view0.findViewById(0x7F0B0061)).setText(qk.a(0x7F07002C));  // id:mode_0
        ((RadioButton)view0.findViewById(0x7F0B0062)).setText(qk.a(0x7F07002D));  // id:mode_1
        ((RadioButton)view0.findViewById(0x7F0B0063)).setText(qk.a(0x7F07002E));  // id:mode_2
        CheckBox checkBox0 = (CheckBox)view0.findViewById(0x7F0B005E);  // id:as_text
        this.d = checkBox0;
        Tools.j(checkBox0);
        checkBox0.setOnLongClickListener(this);
        AlertDialog.Builder alertDialog$Builder0 = i.c().setView(InternalKeyboard.c(view0, false)).setPositiveButton(qk.a((arr_qx == null ? 0x7F07008C : 0x7F0700AF)), this).setNegativeButton(qk.a(0x7F0700A1), null);  // string:save "Save"
        if(arr_qx == null && MainService.instance.an.getCount() != 0) {
            alertDialog$Builder0.setNeutralButton(qk.a(0x7F0701A5), this);  // string:append "Append"
        }
        AlertDialog alertDialog0 = alertDialog$Builder0.create();
        this.e = alertDialog0;
        i.a(alertDialog0, this);
        i.a(alertDialog0, this);
        i.a(alertDialog0, editTextPath0);
    }

    private static String a(String s) [...] // 潜在的解密器

    public static void a() {
        File file0 = ty.b("tmp").getParentFile();
        if(file0.exists()) {
            String[] arr_s = file0.list();
            if(arr_s != null) {
                for(int v = 0; v < arr_s.length; ++v) {
                    String s = arr_s[v];
                    if(s != null && !s.endsWith("_preferences.xml") && s.endsWith(".xml")) {
                        String s1 = s.substring(0, s.length() - 4);
                        if(!s1.equals("null_preferences") && !s1.equals("DefaultStorage")) {
                            la.a(("Try convert \'" + s1 + "\'."));
                            if(kx.b(s1)) {
                                la.a(("All ok - remove \'" + s1 + "\'."));
                                new File(file0, s).delete();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(int v, String s, int v1) {
        int v5;
        int v4;
        File file0 = new File(s);
        if(file0.exists()) {
            BufferedReader bufferedReader0 = new BufferedReader(new FileReader(file0));
            SavedListAdapter savedListAdapter0 = MainService.instance.an;
            if((v1 & 8) == 0) {
                savedListAdapter0.c();
            }
            int v2 = 0;
            int v3 = 0;
            while(true) {
                try {
                label_8:
                    String s1 = bufferedReader0.readLine();
                    if(s1 == null) {
                        break;
                    }
                    v4 = v2 + 1;
                    if(v4 == 1) {
                        try {
                            v5 = Integer.parseInt(s1) == v ? 1 : 0;
                            v3 = v5;
                            v2 = 1;
                            goto label_8;
                        }
                        catch(Throwable throwable0) {
                            la.b(("Failed parse pid: \'" + s1 + '\''), throwable0);
                        }
                        v2 = 1;
                        goto label_8;
                    }
                    String[] arr_s = s1.split("\\|");
                    if(arr_s.length < 10) {
                        la.b(("Failed parse line: \'" + s1 + "\' " + arr_s.length));
                        goto label_51;
                    }
                    try {
                        qx qx0 = new qx(ps.a(arr_s[1], 16), ps.a(arr_s[3], 16), Integer.parseInt(arr_s[2], 16), arr_s[0], ((v1 & 1) == 0 ? arr_s[4].equals("1") : false), Byte.parseByte(arr_s[5]), ps.a(arr_s[6], 16), ps.a(arr_s[7], 16));
                        long v6 = ps.a(arr_s[10], 16);
                        if(v3 == 0) {
                            qs qs0 = RegionList.b(qx0.b);
                            if(qs0 != null && qs0.a().equals(arr_s[8]) && qs0.d().equals(arr_s[9]) && qx0.b == qs0.b + v6) {
                                la.a(("ASLR: " + Long.toHexString(qx0.b) + " ??? " + Long.toHexString(qs0.b + v6) + "; " + arr_s[8] + ' ' + arr_s[9] + ' ' + Long.toHexString(v6) + "; " + qs0.a() + ' ' + qs0.d()));
                            }
                            else {
                                qs qs1 = RegionList.a(arr_s[8], arr_s[9], v6);
                                if(qs1 != null) {
                                    long v7 = qs1.b + v6;
                                    la.a(("Fix: " + Long.toHexString(qx0.b) + " -> " + Long.toHexString(v7) + "; " + arr_s[8] + ' ' + arr_s[9] + ' ' + Long.toHexString(v6) + "; " + qs1.a() + ' ' + qs1.d()));
                                    qx0.b = v7;
                                }
                            }
                        }
                        if((v1 & 2) != 0) {
                            qx0.p();
                        }
                        savedListAdapter0.a(qx0, 0, false);
                        v2 = v4;
                        goto label_8;
                    }
                    catch(Throwable throwable1) {
                        la.b(("Failed parse line: \'" + s1 + '\''), throwable1);
                    }
                }
                catch(OutOfMemoryError outOfMemoryError0) {
                    la.b("OOM on load list", outOfMemoryError0);
                    break;
                }
            label_51:
                v2 = v4;
            }
            bufferedReader0.close();
            savedListAdapter0.notifyDataSetChanged();
            savedListAdapter0.d();
            if(v3 == 0 && (v1 & 4) == 0) {
                i.a(i.c().setCustomTitle(Tools.d(0x7F0700C1)).setMessage(qk.a(0x7F0700C2)).setNegativeButton(qk.a(0x7F07009D), null));  // string:load_list "Load list"
            }
        }
    }

    public static void a(int v, qx[] arr_qx, String s, int v1) {
        long v3;
        String s2;
        String s1;
        File file0 = new File(s);
        File file1 = file0.getParentFile();
        if(file1 != null) {
            file1.mkdirs();
        }
        boolean z = (v1 & 1) != 0;
        FileWriter fileWriter0 = new FileWriter(file0);
        if(!z) {
            fileWriter0.write(v + "\n");
        }
        for(int v2 = 0; v2 < arr_qx.length; ++v2) {
            qx qx0 = arr_qx[v2];
            if(qx0 != null) {
                qs qs0 = RegionList.b(qx0.b);
                if(qs0 != null && qs0.d().length() != 0) {
                    s1 = qs0.a();
                    s2 = qs0.d();
                    v3 = qx0.b - qs0.b;
                }
                else {
                    s1 = "";
                    s2 = "";
                    v3 = 0L;
                }
                StringBuilder stringBuilder0 = new StringBuilder();
                if(z) {
                    stringBuilder0.append(RegionList.a(qx0.b));
                    stringBuilder0.append("; ");
                    stringBuilder0.append(qx0.g());
                    stringBuilder0.append("; ");
                    stringBuilder0.append("Var #00000000");
                    stringBuilder0.append("; ");
                    stringBuilder0.append(qx0.h());
                    stringBuilder0.append("; ");
                    stringBuilder0.append(qx0.n());
                }
                else {
                    stringBuilder0.append("Var #00000000");
                    stringBuilder0.append('|');
                    stringBuilder0.append(Long.toHexString(qx0.b));
                    stringBuilder0.append('|');
                    stringBuilder0.append(Integer.toHexString(qx0.d));
                    stringBuilder0.append('|');
                    stringBuilder0.append(Long.toHexString(qx0.c));
                    stringBuilder0.append('|');
                    stringBuilder0.append(((char)(qx0.f ? 49 : 0x30)));
                    stringBuilder0.append('|');
                    stringBuilder0.append(((int)qx0.g));
                    stringBuilder0.append('|');
                    stringBuilder0.append(Long.toHexString(qx0.h));
                    stringBuilder0.append('|');
                    stringBuilder0.append(Long.toHexString(qx0.i));
                    stringBuilder0.append('|');
                    stringBuilder0.append(kx.a(s1));
                    stringBuilder0.append('|');
                    stringBuilder0.append(kx.a(s2));
                    stringBuilder0.append('|');
                    stringBuilder0.append(Long.toHexString(v3));
                }
                stringBuilder0.append("\n");
                fileWriter0.write(stringBuilder0.toString());
            }
        }
        fileWriter0.close();
    }

    private static boolean b(String s) {
        try {
            SharedPreferences sharedPreferences0 = MainService.instance.a(s, 0);
            int v = sharedPreferences0.getInt("size", 0);
            qx[] arr_qx = new qx[v];
            for(int v1 = 0; true; ++v1) {
                if(v1 >= v) {
                    int v2 = sharedPreferences0.getInt("pid", 0);
                    for(int v3 = 0; true; ++v3) {
                        if(v3 >= 10) {
                            return false;
                        }
                        String s1 = qd.a(null, "save-path");
                        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(s));
                        String s2 = v3 == 0 ? "" : ((int)(v3 + 45));
                        File file0 = new File(s1, stringBuilder0.append(s2).append(".txt").toString());
                        if(!file0.exists()) {
                            try {
                                kx.a(v2, arr_qx, file0.getAbsolutePath(), 0);
                                if(file0.exists()) {
                                    return true;
                                }
                            }
                            catch(IOException iOException0) {
                                la.b("Failed save saved list", iOException0);
                            }
                        }
                    }
                }
                try {
                    arr_qx[v1] = new qx(sharedPreferences0.getLong(v1 + "-address", 0L), sharedPreferences0.getLong(v1 + "-data", 0L), sharedPreferences0.getInt(v1 + "-flags", 4), sharedPreferences0.getString(v1 + "-name", null), sharedPreferences0.getBoolean(v1 + "-freeze", false), ((byte)sharedPreferences0.getInt(v1 + "-freezeType", 0)), sharedPreferences0.getLong(v1 + "-freezeFrom", 0L), sharedPreferences0.getLong(v1 + "-freezeTo", 0L));
                }
                catch(Exception exception1) {
                    la.b(("Failed load item: " + v1), exception1);
                }
            }
        }
        catch(Exception exception0) {
            la.b("Failed load saved list", exception0);
            return false;
        }
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        Button button0 = ((AlertDialog)dialogInterface0).getButton(v);
        if(button0 != null) {
            this.onClick(button0);
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        int v = 0;
        EditText editText0 = this.b;
        if(view0 != null && editText0 != null) {
            String s = editText0.getText().toString().trim();
            if(Tools.o(s)) {
                boolean z = this.g == null;
                if(!z || Tools.b(s)) {
                    iw.a(s, 4);
                    if(z) {
                        MainService.instance.i();
                        RadioGroup radioGroup0 = this.c;
                        if(radioGroup0 != null) {
                            int v1 = radioGroup0.getCheckedRadioButtonId();
                            kx.h = v1;
                            switch(v1) {
                                case 0x7F0B0062: {  // id:mode_1
                                    v = 2;
                                    break;
                                }
                                case 0x7F0B0063: {  // id:mode_2
                                    break;
                                }
                                default: {
                                    v = 3;
                                }
                            }
                            if(view0.getTag() instanceof Integer) {
                                v |= 8;
                            }
                            try {
                                kx.a(this.f.f, s, v);
                                Tools.a(this.e);
                                qm qm0 = MainService.instance.h;
                                if(qm0 != null) {
                                    qm0.write("gg.loadList(");
                                    Script.Consts.a(qm0, s);
                                    qm0.write(", ");
                                    Script.Consts.a(qm0, qm0.a.e, v);
                                    qm0.write(")\n");
                                    return;
                                }
                            }
                            catch(IOException iOException0) {
                                la.b("Failed load list", iOException0);
                                Tools.b(iOException0.getMessage());
                                return;
                            }
                        }
                    }
                    else {
                        CheckBox checkBox0 = this.d;
                        if(checkBox0 != null) {
                            try {
                                if(checkBox0.isChecked()) {
                                    v = 1;
                                }
                                kx.a(this.f.f, this.g, s, v);
                                Tools.a(this.e);
                                qm qm1 = MainService.instance.h;
                                if(qm1 != null) {
                                    if(this.a) {
                                        qm1.write("\nlocal prev = gg.getListItems()\n");
                                        qm1.write("gg.clearList()\n");
                                        qm1.write("local t = ");
                                        ek.a(qm1, true);
                                        qm1.write("gg.addListItems(t)\n");
                                        qm1.write("t = nil\n");
                                    }
                                    qm1.write("gg.saveList(");
                                    Script.Consts.a(qm1, s);
                                    qm1.write(", ");
                                    Script.Consts.a(qm1, qm1.a.f, v);
                                    qm1.write(")");
                                    if(this.a) {
                                        qm1.write("\ngg.clearList()\n");
                                        qm1.write("gg.addListItems(prev)\n");
                                        qm1.write("prev = nil\n");
                                    }
                                    qm1.write("\n");
                                    return;
                                }
                            }
                            catch(IOException iOException1) {
                                la.b("Failed save list", iOException1);
                                Tools.b(iOException1.getMessage());
                                return;
                            }
                        }
                    }
                }
            }
        }
        try {
        }
        catch(IOException iOException0) {
            la.b("Failed load list", iOException0);
            Tools.b(iOException0.getMessage());
        }
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialogInterface0) {
        EditText editText0 = this.b;
        if(editText0 != null) {
            qd.a(editText0.getText().toString(), "save-path", "-list", ".txt");
        }
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        if(view0 != null && view0.getId() == 0x7F0B005E) {  // id:as_text
            i.a(i.c().setMessage(qk.a(0x7F070258)).setNegativeButton(qk.a(0x7F07009D), null));  // string:as_text_help "Saves the list in text format, convenient for human read. Loading 
                                                                                                // of this format is not supported."
            return true;
        }
        return false;
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, null, this);
        Tools.a(dialogInterface0, -3, -3, this);
    }
}

