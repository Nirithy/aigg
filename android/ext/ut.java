package android.ext;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

class ut extends uq {
    final TextView p;
    final LinearLayout q;
    final TextView r;
    final ImageView s;

    ut(View view0, uu uu0) {
        super(view0, uu0);
        this.p = (TextView)view0.findViewById(0x7F0B0072);  // id:addr_item_value
        this.q = (LinearLayout)view0.findViewById(0x7F0B0073);  // id:addr_item_info
        this.r = (TextView)view0.findViewById(0x7F0B0074);  // id:addr_item_type
        this.s = Config.a(((ImageView)view0.findViewById(0x7F0B0076)));  // id:addr_item_remove
        this.s.setOnClickListener(uu0);
        this.s.setOnLongClickListener(uu0);
    }
}

