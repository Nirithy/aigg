package android.ext;

import android.os.Build.VERSION;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

class jh implements Runnable {
    final HotPoint a;

    jh(HotPoint hotPoint0) {
        this.a = hotPoint0;
        super();
    }

    @Override
    public void run() {
        this.a.h = this.a.findViewById(0x7F0B0020);  // id:hot_frame
        this.a.h.setOnClickListener(MainService.instance);
        this.a.g = (ImageView)this.a.findViewById(0x7F0B0021);  // id:hot_point_icon
        this.a.i = this.a.findViewById(0x7F0B0022);  // id:progress_layout
        this.a.j = (TextView)this.a.findViewById(0x7F0B0023);  // id:progress_bar_text
        this.a.k = (ProgressBar)this.a.findViewById(0x7F0B0024);  // id:progress_bar
        this.a.l = (ProgressBar)this.a.findViewById(0x7F0B0025);  // id:progress_bar_stage
        this.a.m = (TextView)Tools.d(this.a.findViewById(0x7F0B0027));  // id:speed_text
        this.a.n = (ImageView)this.a.findViewById(0x7F0B0026);  // id:speed_inc
        this.a.o = (ImageView)this.a.findViewById(0x7F0B001F);  // id:speed_dec
        this.a.n.setOnClickListener(this.a);
        this.a.o.setOnClickListener(this.a);
        this.a.m.setOnLongClickListener(this.a);
        if(Build.VERSION.SDK_INT >= 11) {
            this.a.m.addOnLayoutChangeListener(new ji(this));
        }
        this.a.a(2, -1L, 1L, 0, 1, "");
        this.a.j();
        this.a.k();
    }
}

