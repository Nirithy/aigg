package android.ext;

import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ListAdapter;

class ms implements View.OnClickListener {
    final MainService a;
    private ListAdapter[] b;
    private final pj[][] c;

    ms(MainService mainService0, pj[][] arr2_pj) {
        this.a = mainService0;
        this.c = arr2_pj;
        super();
        this.b = new ListAdapter[arr2_pj.length];
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        int v;
        switch(this.a.X.getId()) {
            case 0x7F0B00E3: {  // id:search_page
                v = 0;
                break;
            }
            case 0x7F0B00E7: {  // id:memory_editor_page
                v = 2;
                break;
            }
            case 0x7F0B00EB: {  // id:saved_page
                v = 1;
                break;
            }
            default: {
                return;
            }
        }
        if(this.b[v] == null) {
            ListAdapter[] arr_listAdapter = this.b;
            arr_listAdapter[v] = new mt(this, MainService.context, this.c[v]);
        }
        i.a(i.a(Tools.o()).setAdapter(this.b[v], new mu(this, this.c, v)));
    }
}

