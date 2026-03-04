package android.ext;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class qz extends ut {
    final ImageView a;
    final TextView b;

    qz(View view0, uu uu0) {
        super(view0, uu0);
        this.a = Config.a(((ImageView)view0.findViewById(0x7F0B0101)));  // id:freeze
        this.a.setOnClickListener(uu0);
        this.a.setOnLongClickListener(uu0);
        this.b = (TextView)view0.findViewById(0x7F0B0051);  // id:name
    }
}

