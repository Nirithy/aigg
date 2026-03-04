package android.ext;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

class iy extends BaseAdapter implements View.OnClickListener, View.OnFocusChangeListener, View.OnLongClickListener {
    static boolean a;
    AlertDialog b;
    final ArrayList c;
    final Context d;
    private boolean e;

    static {
        iy.a = false;
    }

    public iy(Context context0, int v) {
        this.b = null;
        this.e = false;
        this.d = context0;
        iw.c();
        ArrayList arrayList0 = new ArrayList();
        this.c = arrayList0;
        int v1 = iw.b;
        int v2 = 0;
        for(Object object0: iw.a) {
            je je0 = (je)object0;
            if(je0 != null && (je0.b & v) != 0) {
                arrayList0.add(new jc(je0, v2 < v1));
            }
            ++v2;
        }
    }

    private String a(String s) {
        String s1 = s.trim();
        return "...".equals(s1) ? "" : s1;
    }

    private void a(jd jd0) {
        if(jd0.h.b) {
            this.a(jd0, 0x7F02003B, 0x80744294);  // drawable:ic_pin_off_white_24dp
            return;
        }
        this.a(jd0, 0x7F02003C, 0);  // drawable:ic_pin_white_24dp
    }

    private void a(jd jd0, int v, int v1) {
        jd0.d.setImageResource(v);
        jd0.f.setBackgroundColor(v1);
    }

    private void a(je je0, Context context0) {
        EditText editText0 = new EditText(context0);
        editText0.setText(this.a(je0.d));
        AlertDialog alertDialog0 = i.a(context0).setCustomTitle(Tools.i(je0.a)).setView(editText0).setPositiveButton(qk.a(0x7F07009D), new ja(this, je0, editText0)).setNegativeButton(qk.a(0x7F0700A1), null).create();  // string:ok "OK"
        i.a(alertDialog0, new jb(this, editText0));
        i.a(alertDialog0, editText0);
    }

    private void a(View view0, boolean z) {
        if(this.e != z && this.b != null) {
            Window window0 = this.b.getWindow();
            if(window0 != null) {
                Tools.a(window0, view0, z);
                this.e = z;
            }
        }
    }

    void a(je je0, String s, boolean z) {
        je je1;
        Iterator iterator0 = iw.a.iterator();
        while(true) {
            if(!iterator0.hasNext()) {
                je1 = je0;
                break;
            }
            Object object0 = iterator0.next();
            je je2 = (je)object0;
            if(je0.equals(je2)) {
                je1 = je2;
                break;
            }
        }
        String s1 = s.trim();
        if(s1.length() == 0) {
            s1 = "...";
        }
        if(!s1.equals(je1.d)) {
            je1.d = s1;
            if(je0 != je1) {
                je0.d = s1;
            }
            if(z) {
                this.notifyDataSetChanged();
            }
            iw.b();
        }
    }

    @Override  // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    @Override  // android.widget.Adapter
    public Object getItem(int v) {
        return this.c.get(v);
    }

    @Override  // android.widget.Adapter
    public long getItemId(int v) [...] // Inlined contents

    @Override  // android.widget.Adapter
    public View getView(int v, View view0, ViewGroup viewGroup0) {
        View view1;
        int v1 = 0;
        if(view0 != null && view0.getTag() instanceof jd) {
            view1 = view0;
        }
        else {
            view1 = android.fix.i.from(this.d).inflate(0x7F040004, viewGroup0, false);  // layout:history_item
            jd jd0 = new jd();
            jd0.a = (TextView)view1.findViewById(0x7F0B001B);  // id:value
            jd0.b = (TextView)view1.findViewById(0x7F0B001C);  // id:note
            jd0.c = (EditText)view1.findViewById(0x7F0B001D);  // id:note_edit
            jd0.c.addTextChangedListener(new iz(this, jd0));
            Tools.a(jd0.c, this);
            jd0.d = Config.a(((ImageView)view1.findViewById(0x7F0B001A)));  // id:pin
            jd0.d.setOnClickListener(this);
            jd0.d.setOnLongClickListener(this);
            jd0.d.setTag(jd0);
            jd0.e = Config.a(((ImageView)view1.findViewById(0x7F0B001E)));  // id:delete
            jd0.e.setOnClickListener(this);
            jd0.e.setOnLongClickListener(this);
            jd0.e.setTag(jd0);
            jd0.f = view1;
            view1.setTag(jd0);
            view1.setOnLongClickListener(this);
            view1.setOnClickListener(this);
        }
        jd jd1 = (jd)view1.getTag();
        jc jc0 = (jc)this.c.get(v);
        jd1.h = jc0;
        jd1.a.setText(jc0.a.a);
        String s = jc0.a.d;
        jd1.b.setText(s);
        jd1.c.setText(this.a(s));
        jd1.g = v;
        jd1.b.setVisibility((iy.a ? 8 : 0));
        if(!iy.a) {
            v1 = 8;
        }
        jd1.c.setVisibility(v1);
        jd1.e.setVisibility(v1);
        ((ViewGroup)view1).setDescendantFocusability((iy.a ? 0x20000 : 0x60000));
        this.a(jd1);
        return view1;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        int v = 1;
        boolean z = false;
        if(view0 != null) {
            int v1 = view0.getId();
            if(v1 == 0x7F0B0005) {  // id:custom_title
                iy.a = !iy.a;
                if(!iy.a) {
                    this.a(view0, false);
                }
                this.notifyDataSetChanged();
                return;
            }
            jd jd0 = (jd)view0.getTag();
            if(jd0 != null) {
                int v2 = jd0.g;
            alab1:
                switch(v1) {
                    case 0x7F0B001A: {  // id:pin
                        if(!jd0.h.b) {
                            z = true;
                        }
                        jd0.h.b = z;
                        this.a(jd0);
                        String s = jd0.h.a.a;
                        if(!z) {
                            v = 2;
                        }
                        iw.a(s, ((byte)v), jd0.h.a.b);
                        return;
                    label_24:
                        ListView listView0 = Tools.k(view0);
                        if(listView0 != null) {
                            AdapterView.OnItemClickListener adapterView$OnItemClickListener0 = listView0.getOnItemClickListener();
                            if(adapterView$OnItemClickListener0 != null) {
                                adapterView$OnItemClickListener0.onItemClick(listView0, view0, v2, ((long)v2));
                                return;
                            }
                        }
                        break;
                    }
                    case 0x7F0B001E: {  // id:delete
                        je je0 = jd0.h.a;
                        ListIterator listIterator0 = iw.a.listIterator();
                        for(int v3 = 0; true; ++v3) {
                            if(!listIterator0.hasNext()) {
                                break alab1;
                            }
                            if(((je)listIterator0.next()).equals(je0)) {
                                listIterator0.remove();
                                if(v3 < iw.b) {
                                    --iw.b;
                                }
                                this.c.remove(jd0.h);
                                this.notifyDataSetChanged();
                                iw.b();
                                return;
                            }
                        }
                    }
                    default: {
                        goto label_24;
                    }
                }
            }
        }
    }

    @Override  // android.view.View$OnFocusChangeListener
    public void onFocusChange(View view0, boolean z) {
        if(!z && iy.a) {
            return;
        }
        this.a(view0, ((boolean)(iy.a & z)));
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        ViewParent viewParent0;
        jd jd0;
        if(iy.a || view0 == null) {
            return false;
        }
        while(true) {
            if(view0 == null) {
                jd0 = null;
            }
            else {
                Object object0 = view0.getTag();
                if(object0 instanceof jd) {
                    jd0 = (jd)object0;
                }
                else {
                    viewParent0 = view0.getParent();
                    if(viewParent0 instanceof View) {
                        goto label_16;
                    }
                    else {
                        jd0 = null;
                    }
                }
            }
            if(jd0 == null) {
                return false;
            }
            this.a(jd0.h.a, view0.getContext());
            return true;
        label_16:
            view0 = (View)viewParent0;
        }
    }
}

