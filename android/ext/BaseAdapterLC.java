package android.ext;

import android.view.View.OnLongClickListener;
import android.view.View;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;

public abstract class BaseAdapterLC extends BaseAdapter implements View.OnLongClickListener {
    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        if(view0 != null) {
            ListView listView0 = Tools.k(view0);
            if(listView0 != null) {
                int v = listView0.getPositionForView(view0);
                if(v != -1) {
                    AdapterView.OnItemLongClickListener adapterView$OnItemLongClickListener0 = listView0.getOnItemLongClickListener();
                    if(adapterView$OnItemLongClickListener0 != null) {
                        adapterView$OnItemLongClickListener0.onItemLongClick(listView0, view0, v, this.getItemId(v));
                    }
                    return true;
                }
            }
        }
        return false;
    }
}

