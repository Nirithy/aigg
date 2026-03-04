package android.ext;

import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

class mo implements TabHost.OnTabChangeListener {
    final MainService a;

    mo(MainService mainService0) {
        this.a = mainService0;
        super();
    }

    @Override  // android.widget.TabHost$OnTabChangeListener
    public void onTabChanged(String s) {
        int v = 8;
        boolean z = false;
        MainService mainService0 = MainService.instance;
        int v1 = mainService0.r();
        mainService0.r.setVisibility((v1 < 1 ? 8 : 0));
        mainService0.s.setVisibility((v1 == 3 ? 8 : 0));
        mainService0.z.setVisibility((v1 == 1 ? 0 : 8));
        mainService0.v.setVisibility((v1 == 3 ? 0 : 8));
        TextView textView0 = mainService0.w;
        if(v1 == 2) {
            v = 0;
        }
        textView0.setVisibility(v);
        mainService0.s();
        mainService0.X = mainService0.o.getCurrentView();
        Tools.f(mainService0.M);
        mainService0.E();
        ConfigListAdapter configListAdapter0 = this.a.aq;
        if(configListAdapter0 != null) {
            if(v1 == 0) {
                z = true;
            }
            configListAdapter0.a(z);
        }
    }
}

