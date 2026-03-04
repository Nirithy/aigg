package android.ext;

import android.view.View.OnLongClickListener;
import android.view.View;
import android.widget.ImageView;

public class ph extends pj implements View.OnLongClickListener {
    private final pf a;

    public ph(pf pf0) {
        super(0x7F070249, 0x7F020030);  // string:back "Back"
        this.a = pf0;
    }

    @Override  // android.ext.pj
    public ImageView a(boolean z) {
        ImageView imageView0 = super.a(z);
        imageView0.setOnLongClickListener(this);
        return imageView0;
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        this.a.c();
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        this.a.b();
        return true;
    }
}

