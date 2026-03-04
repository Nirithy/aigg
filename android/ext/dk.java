package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.ListView;

class dk implements DialogInterface.OnClickListener {
    private final String[] a;

    dk(String[] arr_s) {
        this.a = arr_s;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        pj[] arr_pj = MainService.q[v / 2];
        CharSequence[] arr_charSequence = new CharSequence[arr_pj.length];
        Drawable[] arr_drawable = new Drawable[arr_pj.length];
        boolean[] arr_z = new boolean[arr_charSequence.length];
        long v1 = Config.b[v];
        for(int v2 = 0; v2 < arr_charSequence.length; ++v2) {
            CharSequence charSequence0 = Build.VERSION.SDK_INT < 11 ? Tools.a(arr_pj[v2].toString(), -1) : arr_pj[v2].toString();
            arr_charSequence[v2] = charSequence0;
            arr_z[v2] = (1L << v2 & v1) != 0L;
            arr_drawable[v2] = arr_pj[v2].d();
        }
        dl dl0 = new dl(this, arr_z, v);
        AlertDialog alertDialog0 = i.a(Tools.o()).setCustomTitle(Tools.i(this.a[v])).setMultiChoiceItems(arr_charSequence, arr_z, new dm(this, arr_z)).setPositiveButton(qk.a(0x7F07008C), dl0).setNeutralButton(qk.a(0x7F07023E), dl0).setNegativeButton(qk.a(0x7F0700A1), dl0).create();  // string:save "Save"
        ListView listView0 = alertDialog0.getListView();
        if(listView0 != null) {
            Tools.a(listView0, arr_charSequence, arr_drawable, Config.d(), 0x7F090002);  // style:SmallText
        }
        i.c(alertDialog0);
    }
}

