package android.ext;

import android.view.View.OnClickListener;
import android.view.View;

class ip implements View.OnClickListener {
    final io a;
    private final RegionList b;

    ip(io io0, RegionList regionList0) {
        this.a = io0;
        this.b = regionList0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        int v;
        switch(view0.getId()) {
            case 0x7F0B0120: {  // id:cb
                v = 16;
                break;
            }
            case 0x7F0B0121: {  // id:ps
                v = 0x40000;
                break;
            }
            case 0x7F0B0122: {  // id:xa
                v = 0x4000;
                break;
            }
            default: {
                v = 8;
            }
        }
        this.b.a(this.b, v);
    }
}

