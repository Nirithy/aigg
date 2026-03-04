package android.ext;

import android.widget.Filter.FilterResults;
import android.widget.Filter;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

class hc extends Filter {
    final hb a;

    hc(hb hb0) {
        this.a = hb0;
        super();
    }

    private String a(CharSequence charSequence0) {
        return charSequence0 != null && charSequence0.length() != 0 ? charSequence0.toString() : "/";
    }

    @Override  // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence0) {
        Filter.FilterResults filter$FilterResults0 = new Filter.FilterResults();
        if(charSequence0 != null) {
            String s = this.a(charSequence0);
            File file0 = new File(s);
            boolean z = s.endsWith("/");
            File file1 = z ? file0 : file0.getParentFile();
            String s1 = (z ? "" : file0.getName()).toLowerCase(Locale.US);
            if(file1.exists()) {
                String[] arr_s = PathSelector.b(file1);
                if(arr_s != null && arr_s.length > 0) {
                    ArrayList arrayList0 = PathSelector.a(this.a.b.a, file1, arr_s, s1, true);
                    int v1 = arrayList0.size();
                    if(v1 == 1 && ((qb)arrayList0.get(0)).b.equals(s1)) {
                        v1 = 0;
                    }
                    if(v1 > 0) {
                        File[] arr_file = new File[v1];
                        for(int v = 0; v < v1; ++v) {
                            arr_file[v] = ((qb)arrayList0.get(v)).a;
                        }
                        filter$FilterResults0.values = arr_file;
                        filter$FilterResults0.count = v1;
                    }
                }
            }
        }
        return filter$FilterResults0;
    }

    @Override  // android.widget.Filter
    protected void publishResults(CharSequence charSequence0, Filter.FilterResults filter$FilterResults0) {
        this.a.c = filter$FilterResults0 != null && filter$FilterResults0.values instanceof File[] ? ((File[])filter$FilterResults0.values) : null;
        this.a.notifyDataSetChanged();
    }
}

