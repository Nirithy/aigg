package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import java.util.ArrayList;
import java.util.List;

class kw implements DialogInterface.OnClickListener {
    final ItemContextMenu a;
    private final List b;
    private final ArrayList c;
    private final d d;

    kw(ItemContextMenu itemContextMenu0, List list0, ArrayList arrayList0, d d0) {
        this.a = itemContextMenu0;
        this.b = list0;
        this.c = arrayList0;
        this.d = d0;
        super();
    }

    private Long a() {
        return this.a.b == 3 && this.d != null ? this.d.b : null;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        if(v < 0 || v >= this.b.size()) {
            la.c(("Unknown index in menu: " + v + " for " + this.b.size()));
            return;
        }
        switch(((int)(((Integer)this.b.get(v))))) {
            case 0x7F020010: {  // drawable:ic_calculator_white_24dp
                new OffsetCalculator(this.a()).a(((String)this.c.get(v)));
                break;
            }
            case 0x7F020015: {  // drawable:ic_code_braces_white_24dp
                w.a(((String)this.c.get(v)));
                break;
            }
            case 0x7F020016: {  // drawable:ic_content_copy_white_24dp
                Tools.a(((String)this.c.get(v)));
                break;
            }
            case 0x7F020019: {  // drawable:ic_cursor_mover_white_24dp
                b.a(((String)this.c.get(v)));
                break;
            }
            case 0x7F02002A: {  // drawable:ic_forward_white_24dp
                MainService.instance.a(this.a(), ((String)this.c.get(v)), Tools.c(0x7F07024E) + ": (" + this.d + ')');  // string:from_context "From the context menu:"
                break;
            }
            case 0x7F020040: {  // drawable:ic_pointer_white_24dp
                new qe().a(((String)this.c.get(v)));
                break;
            }
            case 0x7F020046: {  // drawable:ic_search_nearby_white_24dp
                MainService.instance.Q.b(((String)this.c.get(v)));
                break;
            }
            default: {
                la.c(("Unknown icon in menu: " + Integer.toHexString(((int)(((Integer)this.b.get(v)))))));
            }
        }
        if(dialogInterface0 != null) {
            Tools.a(dialogInterface0);
        }
    }
}

