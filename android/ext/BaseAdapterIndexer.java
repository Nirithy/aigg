package android.ext;

import android.widget.SectionIndexer;

public abstract class BaseAdapterIndexer extends BaseAdapterLC implements SectionIndexer {
    @Override  // android.widget.SectionIndexer
    public int getPositionForSection(int v) {
        int v1 = this.getCount();
        int v2 = ((int)(((double)v1) / 20.0 * ((double)v))) >= 0 ? ((int)(((double)v1) / 20.0 * ((double)v))) : 0;
        return v2 < v1 ? v2 : v1 - 1;
    }

    @Override  // android.widget.SectionIndexer
    public int getSectionForPosition(int v) {
        int v1 = (int)(((double)v) / (((double)this.getCount()) / 20.0));
        if(v1 < 0) {
            v1 = 0;
        }
        return v1 < 20 ? v1 : 19;
    }

    @Override  // android.widget.SectionIndexer
    public Object[] getSections() {
        Object[] arr_object = new Object[20];
        double f = ((double)this.getCount()) / 20.0;
        for(int v = 0; v < 20; ++v) {
            arr_object[v] = (int)(((double)v) * f);
        }
        return arr_object;
    }
}

