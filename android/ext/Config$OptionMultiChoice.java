package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class Config.OptionMultiChoice extends cz implements DialogInterface.OnMultiChoiceClickListener, DialogInterface.OnShowListener, AbsListView.OnScrollListener {
    boolean[] k;

    public Config.OptionMultiChoice(int v, int v1, int[] arr_v, int v2, String s, boolean z) {
        super(v, v1, arr_v, v2, s, z);
    }

    public Config.OptionMultiChoice(int v, int v1, int[] arr_v, int v2, String s, boolean z, int v3) {
        this(v, v1, arr_v, v2, s, z);
        this.h = v3;
    }

    protected void a(boolean z) {
        if(this.n == null) {
            int[] arr_v = new int[(z ? 6 : 3)];
            CharSequence[] arr_charSequence = new CharSequence[arr_v.length];
            if(z) {
                arr_v[0] = 1;
                arr_charSequence[0] = qk.a(0x7F07008B) + ", " + qk.a(0x7F070239);  // string:search "Search"
                arr_v[1] = 2;
                arr_charSequence[1] = qk.a(0x7F07008B) + ", " + qk.a(0x7F070238);  // string:search "Search"
                arr_v[2] = 4;
                arr_charSequence[2] = qk.a(0x7F07019C) + ", " + qk.a(0x7F070239);  // string:saved_list "Saved list"
                arr_v[3] = 8;
                arr_charSequence[3] = qk.a(0x7F07019C) + ", " + qk.a(0x7F070238);  // string:saved_list "Saved list"
                arr_v[4] = 16;
                arr_charSequence[4] = qk.a(0x7F07019D) + ", " + qk.a(0x7F070239);  // string:memory_editor "Memory editor"
                arr_v[5] = 0x20;
                arr_charSequence[5] = qk.a(0x7F07019D) + ", " + qk.a(0x7F070238);  // string:memory_editor "Memory editor"
            }
            else {
                arr_v[0] = 1;
                arr_charSequence[0] = qk.a(0x7F07008B);  // string:search "Search"
                arr_v[1] = 2;
                arr_charSequence[1] = qk.a(0x7F07019C);  // string:saved_list "Saved list"
                arr_v[2] = 4;
                arr_charSequence[2] = qk.a(0x7F07019D);  // string:memory_editor "Memory editor"
            }
            this.n = arr_v;
            this.m = arr_charSequence;
            this.l = null;
        }
    }

    @Override  // android.ext.cz
    protected void a(CharSequence[] arr_charSequence) {
        boolean[] arr_z = new boolean[arr_charSequence.length];
        this.k = arr_z;
        int v = this.d;
        for(int v1 = 0; v1 < arr_charSequence.length; ++v1) {
            int v2 = this.b(v1);
            arr_z[v1] = (v & v2) == v2;
            if(Build.VERSION.SDK_INT < 11 && arr_charSequence[v1] instanceof String) {
                arr_charSequence[v1] = Tools.a(arr_charSequence[v1], -1);
            }
        }
        AlertDialog alertDialog0 = i.a(Tools.o()).setCustomTitle(Config.a(this.a, this.h, this.g)).setMultiChoiceItems(arr_charSequence, arr_z, this).setPositiveButton(0x7F07008C, this).setNeutralButton(0x7F07023E, this).setNegativeButton(0x7F0700A1, this).create();  // string:save "Save"
        i.a(alertDialog0, this);
        i.c(alertDialog0);
    }

    @Override  // android.ext.cz
    public boolean a(DialogInterface dialogInterface0, int v) {
        int v1 = 0;
        if(v == -3 || v == -1) {
            boolean[] arr_z = this.k;
            int v2 = this.b;
            if(arr_z != null && v == -1) {
                while(v1 < arr_z.length) {
                    int v3 = this.b(v1);
                    v2 = arr_z[v1] ? v2 | v3 : v2 & ~v3;
                    ++v1;
                }
                this.k = null;
            }
            this.d = v2;
            Config.c();
            Tools.a(dialogInterface0);
            v1 = 1;
        }
        return v1 != 0;
    }

    @Override  // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(DialogInterface dialogInterface0, int v, boolean z) {
        boolean[] arr_z = this.k;
        if(arr_z == null) {
            la.c("", new NullPointerException(this.toString()));
            return;
        }
        try {
            arr_z[v] = z;
        }
        catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
            la.c("", arrayIndexOutOfBoundsException0);
        }
    }

    @Override  // android.widget.AbsListView$OnScrollListener
    public void onScroll(AbsListView absListView0, int v, int v1, int v2) {
        this.onScrollStateChanged(absListView0, 0);
    }

    @Override  // android.widget.AbsListView$OnScrollListener
    public void onScrollStateChanged(AbsListView absListView0, int v) {
        int v2;
        try {
            int v1 = absListView0.getChildCount();
            v2 = 0;
            while(true) {
            label_2:
                if(v2 >= v1) {
                    return;
                }
                try {
                    View view0 = absListView0.getChildAt(v2);
                    if(view0 instanceof CheckedTextView) {
                        ((CheckedTextView)view0).refreshDrawableState();
                    }
                }
                catch(ArrayIndexOutOfBoundsException unused_ex) {
                }
                break;
            }
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
            return;
        }
        ++v2;
        goto label_2;
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        if(Build.VERSION.SDK_INT >= 23 && dialogInterface0 instanceof AlertDialog) {
            ListView listView0 = ((AlertDialog)dialogInterface0).getListView();
            if(listView0 != null) {
                listView0.setOnScrollListener(this);
            }
        }
    }

    @Override  // android.ext.cz
    public String toString() {
        return Tools.c(this.a);
    }
}

