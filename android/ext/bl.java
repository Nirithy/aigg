package android.ext;

import android.app.AlertDialog;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import android.fix.i;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class bl implements DialogInterface.OnShowListener, View.OnClickListener {
    volatile AlertDialog a;
    final TextView b;
    final ProgressBar c;
    final TextView d;
    final View e;
    final ProgressBar f;
    final TextView g;
    final TextView h;
    final TextView i;
    final View j;
    long k;
    long l;
    long m;
    final Runnable n;

    public bl() {
        this.k = -1L;
        this.l = -1L;
        this.m = -1L;
        this.n = new bm(this);
        this.j = i.a(0x7F040019, null);  // layout:service_busy_dialog
        this.b = (TextView)this.j.findViewById(0x7F0B000E);  // id:message
        this.c = (ProgressBar)this.j.findViewById(0x7F0B0024);  // id:progress_bar
        this.d = (TextView)this.j.findViewById(0x7F0B0023);  // id:progress_bar_text
        this.e = this.j.findViewById(0x7F0B0077);  // id:stage_layout
        this.f = (ProgressBar)this.j.findViewById(0x7F0B0025);  // id:progress_bar_stage
        this.g = (TextView)this.j.findViewById(0x7F0B0078);  // id:progress_bar_stage_text
        this.h = (TextView)this.j.findViewById(0x7F0B0079);  // id:found_count
        this.i = (TextView)this.j.findViewById(0x7F0B007A);  // id:time
        this.j.findViewById(0x7F0B007B).setOnClickListener(this);  // id:help_speed_up
    }

    public void a(CharSequence charSequence0, long v, long v1, int v2, int v3, long v4, String s) {
        if(!this.a()) {
            return;
        }
        if(rx.c()) {
            this.b(charSequence0, v, v1, v2, v3, v4, s);
            return;
        }
        rx.a(new bo(this, charSequence0, v, v1, v2, v3, v4, s));
    }

    public boolean a() {
        return this.a != null;
    }

    public boolean a(boolean z) {
        AlertDialog alertDialog0 = this.a;
        if(alertDialog0 != null) {
            android.ext.i.c(alertDialog0);
            if(z) {
                la.a("Show busy dialog not first time", new RuntimeException());
                return true;
            }
        }
        else if(z) {
            rx.a(new bn(this));
            return true;
        }
        return true;
    }

    void b(CharSequence charSequence0, long v, long v1, int v2, int v3, long v4, String s) {
        if(charSequence0 != null) {
            this.b.setText(charSequence0);
        }
        if(v >= 0L && v1 != 0L) {
            this.c.setIndeterminate(false);
            this.c.setMax(((int)v1));
            this.c.setProgress(((int)v));
            this.d.setText(s);
        }
        else {
            this.d.setText(s);
            this.c.setIndeterminate(true);
        }
        if(v2 >= 0) {
            if(v3 <= 1) {
                this.e.setVisibility(8);
            }
            else {
                this.f.setMax(v3);
                this.f.setProgress(v2);
                String s1 = Tools.a(qk.a(0x7F0700C3), new Object[]{v2, v3});  // string:from "Completed __d__ from __d__ stages"
                this.g.setText(s1);
                this.e.setVisibility(0);
            }
        }
        String s2 = Tools.a(qk.a(0x7F0700C9), new Object[]{v4});  // string:found_count "Found: __d__"
        this.h.setText(s2);
        long v5 = System.currentTimeMillis();
        if(v < 0L) {
            this.k = -1L;
            this.l = -1L;
            this.m = -1L;
        }
        else if(this.m != v1) {
            this.k = v5;
            this.l = v;
            this.m = v1;
        }
        long v6 = this.k >= 0L && v5 - this.k >= 2000L && v - this.l != 0L ? Math.round(((double)(v5 - this.k)) * ((double)(v1 - v)) / ((double)(v - this.l)) / 1000.0) : -1L;
        if(v6 <= 0L) {
            this.i.setText("");
            return;
        }
        String s3 = Tools.c(0x7F070208) + ": " + Tools.a(v6);  // string:time_remaining "Time remaining:"
        this.i.setText(s3);
    }

    public void b(boolean z) {
        AlertDialog alertDialog0 = this.a;
        if(alertDialog0 != null) {
            rx.a().removeCallbacks(this.n);
            Tools.a(alertDialog0);
            if(z) {
                this.a = null;
            }
        }
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        ConfigListAdapter.b(0x7F07020F);  // string:help_speed_up "* How to speed up search:\n\t0. If you are use an Android 
                                          // emulator on a PC (BlueStacks, Droid4X, Andy, NOX, Memu, AMIDuOS, Windroy, AVD, Genymotion, 
                                          // Koplayer, Leapdroid etc.), check that virtualization (VT Technology, Vanderpool 
                                          // Technology, Virtualization Technology, VTx, VT-d, VMX, Virtual Technology, Intel-VT, 
                                          // AMD-V, SVM, IOMMU) is enabled in the PC BIOS.\n\t1. If you have a lot of RAM, then 
                                          // you can store the data there. This greatly speeds up the search. Set the setting 
                                          // \"__data_in_ram__\" to \"__yes__\". In an Android emulator on a PC, this can slow 
                                          // down the search.\n\t2. If you have little RAM, the data will be stored on the memory 
                                          // card. Use a memory card with a high write and read speed.\n\t3. You can also specify 
                                          // the storage of data in the internal memory of the device, if it faster than the 
                                          // memory card. Set the setting \"__set_path__\" to the desired path.\n\t4. On search, 
                                          // select only the desired regions. Avoid slow (\"__slow__\") and dangerous (\"__dangerous__\") 
                                          // regions.\n\t5. You can also specify the limits of the memory range, for search, 
                                          // if you know them. Click the button \"__more__\" in the search dialog and enter the 
                                          // limits.\n\t6. Search for only the desired types of data. The data type \"__type_auto__\" 
                                          // is slow.\n\t7. Disable all possible \"__hide_from_game__\" options.\n\t8. Try using 
                                          // \"__experimental__\" or \"__extended__\" in \"__memory_access__\". These options 
                                          // can lead to unstable work.\n    "
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public void onShow(DialogInterface dialogInterface0) {
        Tools.a(dialogInterface0, -1, 0x7F070215, MainService.instance);  // string:hide "Hide"
        Tools.a(dialogInterface0, -2, 0x7F0B0034, MainService.instance);  // id:abort_button
    }
}

