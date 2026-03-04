package android.ext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

class qa extends ArrayAdapter {
    final py a;

    qa(py py0, Context context0, List list0) {
        this.a = py0;
        super(context0, list0);
    }

    @Override  // android.ext.ArrayAdapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        return this.a.a(v, view0, viewGroup0);
    }
}

