package android.ext;

import android.view.View;

class ay implements Runnable {
    final ar a;
    private final int b;

    ay(ar ar0, int v) {
        this.a = ar0;
        this.b = v;
        super();
    }

    @Override
    public void run() {
        int v = 0;
        View view0 = (View)this.a.j.get();
        if(view0 != null) {
            View view1 = view0.findViewById(0x7F0B0031);  // id:loader
            if(view1 != null) {
                view1.setVisibility((this.b == 0 ? 0 : 8));
            }
            View view2 = view0.findViewById(0x7F0B0032);  // id:installer
            if(view2 != null) {
                view2.setVisibility((this.b == 1 ? 0 : 8));
            }
            View view3 = view0.findViewById(0x7F0B0035);  // id:starter
            if(view3 != null) {
                if(this.b != 2) {
                    v = 8;
                }
                view3.setVisibility(v);
            }
            if(this.b == 2) {
                if(view1 != null) {
                    Tools.d(view1);
                }
                if(view2 != null) {
                    Tools.d(view2);
                }
            }
        }
    }
}

