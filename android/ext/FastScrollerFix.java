package android.ext;

import android.os.Build.VERSION;
import android.os.Handler;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView;
import android.widget.ListView;

public class FastScrollerFix implements AbsListView.OnScrollListener, Runnable {
    private ListView a;
    private int b;

    public FastScrollerFix(ListView listView0) {
        this.b = 0;
        this.a = listView0;
        FastScrollerFix.b(listView0, false);
        try {
            listView0.setOnScrollListener(this);
        }
        catch(Throwable throwable0) {
            la.a(throwable0);
        }
    }

    public static void a(ListView listView0, boolean z) {
        if(listView0 == null) {
            return;
        }
        listView0.setScrollBarStyle(0x1000000);
        FastScrollerFix.b(listView0, z);
    }

    private static void b(ListView listView0, boolean z) {
        if(listView0 != null) {
            try {
                listView0.setFastScrollEnabled(z);
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
            if(Build.VERSION.SDK_INT >= 11) {
                try {
                    listView0.setFastScrollAlwaysVisible(z);
                }
                catch(Throwable throwable1) {
                    la.a(throwable1);
                }
            }
        }
    }

    @Override  // android.widget.AbsListView$OnScrollListener
    public void onScroll(AbsListView absListView0, int v, int v1, int v2) {
        if(this.b != 0) {
            return;
        }
        Handler handler0 = rx.a();
        handler0.removeCallbacks(this);
        handler0.postDelayed(this, 1000L);
    }

    @Override  // android.widget.AbsListView$OnScrollListener
    public void onScrollStateChanged(AbsListView absListView0, int v) {
        this.b = v;
        Handler handler0 = rx.a();
        handler0.removeCallbacks(this);
        if(v != 0) {
            FastScrollerFix.b(this.a, true);
            return;
        }
        handler0.postDelayed(this, 1000L);
    }

    @Override
    public void run() {
        FastScrollerFix.b(this.a, false);
    }
}

