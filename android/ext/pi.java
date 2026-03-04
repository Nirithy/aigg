package android.ext;

import android.view.View.OnLongClickListener;
import android.view.View;
import android.widget.ImageView;

public class pi extends pj implements View.OnLongClickListener {
    private final pf a;

    public pi(pf pf0) {
        super(0x7F07024A, 0x7F020031);  // string:forward "Forward"
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
        this.a.d();
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        this.a.b();
        return true;
    }
}

