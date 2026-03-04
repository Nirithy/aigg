package android.ext;

import android.widget.Filter.FilterResults;
import android.widget.Filter;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;

class pd extends Filter {
    ai a;
    int[] b;
    final ow c;

    private pd(ow ow0) {
        this.c = ow0;
        super();
        this.a = null;
        this.b = null;
    }

    pd(ow ow0, pd pd0) {
        this(ow0);
    }

    private String a(String s) {
        return s.toLowerCase(Locale.US).replace(ps.a, "");
    }

    @Override  // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence0) {
        int[] arr_v;
        ai ai0;
        Filter.FilterResults filter$FilterResults0 = new Filter.FilterResults();
        filter$FilterResults0.values = null;
        try {
            boolean z = (this.c.c & 12) == 0;
            if(charSequence0 != null && charSequence0.length() > 0 && this.c.g()) {
                String s = Tools.l((z ? this.a(charSequence0.toString()) : charSequence0.toString()));
                la.a(("Filter: \'" + s + '\''));
                Pattern pattern0 = Pattern.compile(s, 8);
                if((this.c.c & 0x30) == 0) {
                    ai0 = null;
                }
                else if(this.a == null) {
                    ai ai1 = new ai();
                    this.a = ai1;
                    ai0 = ai1;
                }
                else {
                    ai0 = this.a;
                }
                if((this.c.c & 0x40) == 0) {
                    arr_v = null;
                }
                else if(this.b == null) {
                    int[] arr_v1 = ag.a();
                    this.b = arr_v1;
                    arr_v = arr_v1;
                }
                else {
                    arr_v = this.b;
                }
                int v = (short)this.c.c();
                short[] arr_v2 = new short[v];
                int v2 = 0;
                for(short v1 = 0; true; v1 = (short)(v1 + 1)) {
                    if(v1 >= v) {
                        filter$FilterResults0.values = Arrays.copyOf(arr_v2, v2);
                        return filter$FilterResults0;
                    }
                    String s1 = this.c.a(ai0, arr_v, ((int)v1));
                    if(z) {
                        s1 = this.a(s1);
                    }
                    if(pattern0.matcher(s1).find()) {
                        arr_v2[v2] = v1;
                        ++v2;
                    }
                }
            }
        }
        catch(Throwable throwable0) {
            la.a("Failed filter", throwable0);
            ho.a(Thread.currentThread(), throwable0, false);
        }
        return filter$FilterResults0;
    }

    @Override  // android.widget.Filter
    protected void publishResults(CharSequence charSequence0, Filter.FilterResults filter$FilterResults0) {
        this.c.b = (short[])filter$FilterResults0.values;
        this.c.b();
    }
}

