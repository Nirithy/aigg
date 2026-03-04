package android.ext;

import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.c.b;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.fix.ListView;
import android.fix.TextView;
import android.fix.i;
import android.text.format.DateFormat;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

class py implements DialogInterface.OnClickListener, View.OnClickListener, AdapterView.OnItemClickListener {
    ListView a;
    final PathSelector b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private File f;
    private ArrayAdapter g;
    private AlertDialog h;
    private int i;
    private EditText j;
    private EditText k;
    private int l;
    private int m;
    private int n;

    private py(PathSelector pathSelector0) {
        this.b = pathSelector0;
        super();
        this.l = Tools.c(0x7F0A0020, 0xFF005500);  // color:file_lua
        this.m = Tools.c(0x7F0A0021, 0xFF000055);  // color:file_txt
        this.n = Tools.c(0x7F0A0022, 0xFF005555);  // color:file_lasm
    }

    py(PathSelector pathSelector0, py py0) {
        this(pathSelector0);
    }

    private void a() {
        this.f = this.f.getParentFile();
        if(this.f == null) {
            this.f = new File("/");
        }
    }

    private void a(int v) {
        this.a.setSelection(v);
        this.a.post(new pz(this, v));
    }

    private void a(File file0, boolean z) {
        ArrayAdapter arrayAdapter0 = this.g;
        int v = arrayAdapter0.getCount();
        String s = file0.getAbsolutePath().toLowerCase(Locale.US);
        int v1 = 0;
        for(int v2 = 0; true; v2 = v3) {
            if(v1 >= v) {
                v1 = v2;
                break;
            }
            File file1 = (File)arrayAdapter0.getItem(v1);
            if(file0.equals(file1)) {
                break;
            }
            int v3 = z != PathSelector.a(file1) || s.compareTo(file1.getAbsolutePath().toLowerCase(Locale.US)) <= 0 ? v2 : v1;
            ++v1;
        }
        this.a(v1);
    }

    private void a(String s) {
        this.f = new File(this.f, s);
    }

    private void a(boolean z) {
        this.c.setTag((z ? null : this.c));
        this.c.setImageDrawable(Tools.b((z ? 0x7F02004C : 0x7F02004B)));  // drawable:ic_sort_name_white_24dp
    }

    public View a(int v, View view0, ViewGroup viewGroup0) {
        boolean z1;
        long v2;
        long v1;
        File file0;
        if(view0 == null) {
            view0 = i.from(this.b.getContext()).inflate(0x7F040010, null);  // layout:path_item
            qc qc0 = new qc();
            qc0.a = (TextView)view0.findViewById(0x7F0B0051);  // id:name
            qc0.b = (TextView)view0.findViewById(0x7F0B0052);  // id:date
            qc0.c = (TextView)view0.findViewById(0x7F0B0053);  // id:size
            qc0.d = Config.a(((ImageView)view0.findViewById(0x7F0B0050)));  // id:icon
            view0.setTag(qc0);
        }
        try {
            file0 = (File)this.g.getItem(v);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            la.b(("Failed get item: " + v), indexOutOfBoundsException0);
            file0 = null;
        }
        File file1 = file0 == null ? new File(this.f, "???") : file0;
        qc qc1 = (qc)view0.getTag();
        String s = file1.getName();
        if(s.endsWith(".lua")) {
            view0.setBackgroundColor(this.l);
        }
        else if(s.endsWith(".txt")) {
            view0.setBackgroundColor(this.m);
        }
        else if(s.endsWith(".lasm")) {
            view0.setBackgroundColor(this.n);
        }
        else {
            view0.setBackgroundColor(0);
        }
        qc1.a.setText(s);
        try {
            boolean z = PathSelector.a(file1);
            v1 = z ? -1L : file1.length();
            v2 = file1.lastModified();
            z1 = z;
        }
        catch(Throwable throwable0) {
            la.b(("Failed get info: " + file1.getAbsolutePath()), throwable0);
            v2 = -1L;
            v1 = -1L;
            z1 = false;
        }
        qc1.d.setImageResource((z1 ? 0x7F020026 : 0x7F020023));  // drawable:ic_folder_outline_white_24dp
        qc1.c.setText((v1 < 0L ? "" : Tools.a(this.b.getContext(), v1)));
        TextView textView0 = qc1.b;
        CharSequence charSequence0 = v2 > 0L ? DateFormat.format("yyyy-MM-dd kk:mm:ss", v2) : "";
        textView0.setText(charSequence0);
        return view0;
    }

    private void b() {
        this.d.setText(this.f.getAbsolutePath());
        String[] arr_s = PathSelector.b(this.f);
        this.b(arr_s == null);
        ArrayList arrayList0 = PathSelector.a(this.i, this.f, (arr_s == null ? b.a : arr_s), null, this.c.getTag() == null);
        this.g.clear();
        this.g.setNotifyOnChange(false);
        for(Object object0: arrayList0) {
            this.g.add(((qb)object0).a);
        }
        this.g.notifyDataSetChanged();
        this.g.setNotifyOnChange(true);
    }

    private void b(String s) {
        android.ext.EditText editText0 = new android.ext.EditText(Tools.e());
        this.k = editText0;
        editText0.setText(s);
        android.ext.i.a(android.ext.i.c().setCustomTitle(Tools.b(qk.a(0x7F0702D1), this.f.getAbsolutePath() + "/...")).setView(InternalKeyboard.c(editText0, false)).setNegativeButton(qk.a(0x7F0700A1), null).setPositiveButton(qk.a(0x7F07009D), this));  // string:folder_new "New folder"
    }

    private void b(boolean z) {
        int v = 0;
        this.e.setVisibility((z ? 0 : 8));
        ListView listView0 = this.a;
        if(z) {
            v = 8;
        }
        listView0.setVisibility(v);
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        String s2;
        if(dialogInterface0 == this.h) {
            String s = this.f.getAbsolutePath();
            if(this.i == 2) {
                String s1 = new File(this.j.getText().toString()).getName();
                if(s1 == null || s1.length() == 0) {
                    s1 = "file.txt";
                }
                s2 = s + "/" + s1;
            }
            else {
                s2 = s;
            }
            this.j.setText(s2);
            return;
        }
        EditText editText0 = this.k;
        if(editText0 != null) {
            String s3 = editText0.getText().toString().trim();
            if(s3.length() > 0) {
                File file0 = new File(this.f, s3);
                if(file0.exists()) {
                    if(PathSelector.a(file0)) {
                        Tools.a(0x7F0702D2);  // string:folder_exists "This folder already exists"
                    }
                    else {
                        Tools.a(0x7F0702D3);  // string:folder_file "There is a file with that name"
                    }
                    this.b(s3);
                    return;
                }
                if(!file0.mkdirs()) {
                    Tools.a(0x7F0702D4);  // string:folder_failed "Failed to create folder"
                    this.b(s3);
                    return;
                }
                iw.a(s3, 4);
                this.b();
                return;
            }
            Tools.a(0x7F0702D4);  // string:folder_failed "Failed to create folder"
            this.b(s3);
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        boolean z = false;
        switch(view0.getId()) {
            case 0x7F0B0054: {  // id:add
                this.b("");
                return;
            }
            case 0x7F0B0055: {  // id:sort
                boolean z1 = this.c.getTag() != null;
                PathSelector.a = z1;
                this.a(z1);
                this.b();
                this.a(0);
                return;
            }
            case 0x7F0B0056: {  // id:up
                File file1 = this.f;
                this.a();
                this.b();
                this.a(file1, true);
                return;
            }
            default: {
                Object object0 = this.b.getTag();
                if(!(object0 instanceof EditTextPath)) {
                    return;
                }
                this.j = (EditTextPath)object0;
                View view1 = i.a(0x7F040011, null);  // layout:path_selector
                this.d = (TextView)view1.findViewById(0x7F0B000A);  // id:path
                Config.a(((ImageView)view1.findViewById(0x7F0B0054))).setOnClickListener(this);  // id:add
                ImageView imageView0 = (ImageView)view1.findViewById(0x7F0B0055);  // id:sort
                this.c = imageView0;
                Config.a(imageView0).setOnClickListener(this);
                this.a(PathSelector.a);
                Config.a(((ImageView)view1.findViewById(0x7F0B0056))).setOnClickListener(this);  // id:up
                this.e = (TextView)view1.findViewById(0x7F0B0057);  // id:failed
                ListView listView0 = (ListView)view1.findViewById(0x7F0B0058);  // id:files
                this.a = listView0;
                qa qa0 = new qa(this, this.b.getContext(), new ArrayList());
                this.g = qa0;
                listView0.setAdapter(qa0);
                listView0.setOnItemClickListener(this);
                this.i = ((EditTextPath)object0).getPathType();
                File file0 = new File(((EditTextPath)object0).getText().toString());
                this.f = file0;
                while(!PathSelector.a(this.f)) {
                    this.a();
                }
                this.b();
                if(this.i == 0) {
                    z = true;
                }
                this.a(file0, z);
                AlertDialog.Builder alertDialog$Builder0 = android.ext.i.c().setView(view1).setNegativeButton(qk.a(0x7F0700A1), null);  // string:cancel "Cancel"
                if(this.i != 1) {
                    alertDialog$Builder0.setPositiveButton(qk.a(0x7F07009D), this);  // string:ok "OK"
                }
                AlertDialog alertDialog0 = alertDialog$Builder0.create();
                this.h = alertDialog0;
                android.ext.i.c(alertDialog0);
            }
        }
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        File file0;
        if(v >= 0 && v < this.g.getCount()) {
            try {
                file0 = (File)this.g.getItem(v);
            }
            catch(Exception exception0) {
                la.b(("Failed get Item: " + v), exception0);
                return;
            }
            if(file0 != null) {
                if(PathSelector.a(file0)) {
                    this.a(file0.getName());
                    this.b();
                    this.a(0);
                    return;
                }
                if(this.i != 0) {
                    this.j.setText(file0.getAbsolutePath());
                    Tools.a(this.h);
                }
            }
        }
    }
}

