package android.ext;

import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

public class EditorListener extends pj implements AdapterView.OnItemClickListener {
    private final boolean a;

    public EditorListener() {
        this(false);
    }

    public EditorListener(boolean z) {
        super(0x7F070139, 0x7F02004F);  // string:edit_selected "Edit selected"
        this.a = z;
    }

    @Override  // android.ext.pj
    public void onClick(View view0) {
        new hk(this, null).onClick(view0);
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        new hk(this, null).onItemClick(adapterView0, view0, v, v1);
    }
}

