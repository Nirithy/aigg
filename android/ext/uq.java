package android.ext;

import android.content.res.Configuration;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

class uq {
    final CheckBox c;
    final TextView d;
    final TextView e;
    final TextView f;
    final TextView g;
    final TextView h;
    final TextView i;
    final TextView j;
    final TextView k;
    final TextView l;
    final View m;
    final int n;
    int o;

    uq(View view0, ur ur0) {
        this.c = (CheckBox)view0.findViewById(0x7F0B006A);  // id:ch
        this.d = (TextView)view0.findViewById(0x7F0B0049);  // id:address
        this.e = (TextView)view0.findViewById(0x7F0B006B);  // id:value_hex
        this.f = (TextView)view0.findViewById(0x7F0B006C);  // id:value_rhex
        this.g = (TextView)view0.findViewById(0x7F0B006D);  // id:value_string
        this.h = (TextView)view0.findViewById(0x7F0B006E);  // id:value_java
        this.i = (TextView)view0.findViewById(0x7F0B006F);  // id:value_arm
        this.j = (TextView)view0.findViewById(0x7F0B0070);  // id:value_thumb
        this.k = (TextView)view0.findViewById(0x7F0B0071);  // id:value_arm8
        this.l = (TextView)view0.findViewById(0x7F0B0075);  // id:addr_item_region
        this.m = view0;
        this.n = MainService.context.getResources().getConfiguration().orientation;
        this.m.setTag(this);
        this.c.setOnCheckedChangeListener(ur0);
        this.c.setOnLongClickListener(ur0);
        this.c.setTag(this);
    }

    void a(boolean z, int v) {
        int v1;
        View view0 = this.m;
        if(z) {
            v1 = 0x80744294;
        }
        else {
            v1 = this.o == v ? 0x80949442 : 0;
        }
        view0.setBackgroundColor(v1);
    }

    boolean a() {
        Configuration configuration0 = MainService.context.getResources().getConfiguration();
        return this.n != configuration0.orientation;
    }
}

