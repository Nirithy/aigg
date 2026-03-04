package android.ext;

import android.content.Context;
import android.fix.LinearLayout;
import android.fix.i;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MemoryRange extends LinearLayout implements View.OnClickListener {
    private Runnable a;
    private int b;
    private Button c;
    private View d;
    private EditText e;
    private EditText f;
    private View g;
    private EditText h;
    private CheckBox i;
    private CheckBox j;
    private EditText k;

    public MemoryRange(Context context0) {
        super(context0);
        this.a = null;
        this.b = 0;
        this.c = null;
    }

    public MemoryRange(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = null;
        this.b = 0;
        this.c = null;
    }

    public MemoryRange(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = null;
        this.b = 0;
        this.c = null;
    }

    public MemoryRange(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(context0, attributeSet0, v, v1);
        this.a = null;
        this.b = 0;
        this.c = null;
    }

    public static long a(int v, EditText editText0, String s, EditText editText1, String s1) {
        if(v == 0) {
            editText1 = editText0;
        }
        String s2 = re.c(editText1.getText().toString().trim());
        if(s2.length() != 0) {
            s = s2;
        }
        else if(v != 0) {
            s = s1;
        }
        String s3 = re.c(editText0.getText().toString().trim());
        boolean z = s3.contains("?");
        if(z) {
            s = s3.replace("?", (v == 0 ? "0" : "F"));
            if(v != 0) {
                editText1.setText(s);
            }
        }
        try {
            long v1 = ps.a(s, 16);
            if(v == 0 && z) {
                iw.a(s3, 1);
            }
            iw.a(s, 1);
            return v1;
        }
        catch(NumberFormatException numberFormatException0) {
            editText1.requestFocus();
            throw numberFormatException0;
        }
    }

    public long a(int v) {
        long v3;
        long v2;
        switch(this.b) {
            case 1: {
                long v1 = MemoryRange.a(v, this.e, "0", this.f, "-1");
                if(v == 0) {
                    Config.d = v1;
                }
                else {
                    Config.e = v1;
                }
                Config.c();
                return v1;
            }
            case 2: {
                String s = re.c(this.h.getText().toString().trim());
                try {
                    v2 = ps.a(s, 16);
                    iw.a(s, 1);
                }
                catch(NumberFormatException numberFormatException0) {
                    this.h.requestFocus();
                    throw numberFormatException0;
                }
                if((v == 0 ? this.i : this.j).isChecked()) {
                    String s1 = re.c(this.k.getText().toString().trim());
                    try {
                        v3 = ps.a(s1, 16);
                        iw.a(s1, 1);
                    }
                    catch(NumberFormatException numberFormatException1) {
                        this.k.requestFocus();
                        throw numberFormatException1;
                    }
                    Config.f = v3;
                    Config.c();
                    if(v == 0) {
                        v3 = -v3;
                    }
                    return v3 + v2;
                }
                return v2;
            }
            default: {
                return v == 0 ? 0L : -1L;
            }
        }
    }

    public void a() {
        if(this.c != null) {
            return;
        }
        i.a(0x7F04000D, this);  // layout:memory_range
        this.c = (Button)this.findViewById(0x7F0B0046);  // id:range
        this.d = this.findViewById(0x7F0B0047);  // id:range_row
        this.e = (EditText)this.findViewById(0x7F0B0003);  // id:memory_from
        this.e.setDataType(1);
        this.findViewById(0x7F0B0004).setTag(this.e);  // id:region_from
        this.f = (EditText)this.findViewById(0x7F0B0008);  // id:memory_to
        this.f.setDataType(1);
        this.findViewById(0x7F0B0009).setTag(this.f);  // id:region_to
        this.e.setText("00000000");
        this.f.setText("00000000");
        this.g = this.findViewById(0x7F0B0048);  // id:nearby_row
        this.h = (EditText)this.findViewById(0x7F0B0049);  // id:address
        this.h.setDataType(1);
        this.i = (CheckBox)this.findViewById(0x7F0B004A);  // id:before
        this.j = (CheckBox)this.findViewById(0x7F0B004B);  // id:after
        this.k = (EditText)this.findViewById(0x7F0B004C);  // id:distance
        this.k.setDataType(1);
        this.k.setText("0");
        this.c.setOnClickListener(this);
        InternalKeyboard.a(this.e, 1);
        this.b();
    }

    private void b() {
        int v2;
        int v = 0;
        int v1 = this.b;
        Button button0 = this.c;
        if(v1 == 1) {
            v2 = 0x7F0701A7;  // string:only_memory "Only within the memory range:"
        }
        else {
            v2 = v1 == 2 ? 0x7F070351 : 0x7F07025B;  // string:nearby "Nearby:"
        }
        button0.setText(qk.a(v2));
        this.d.setVisibility((v1 == 1 ? 0 : 8));
        View view0 = this.g;
        if(v1 != 2) {
            v = 8;
        }
        view0.setVisibility(v);
    }

    public int getType() {
        return this.b;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        this.setType((this.b + 1) % 3);
    }

    public void setAddress(String s) {
        this.h.setText(s);
    }

    public void setType(int v) {
        int v1 = this.b;
        this.b = v;
        this.b();
        Runnable runnable0 = this.a;
        if(v1 != v && runnable0 != null) {
            runnable0.run();
        }
    }

    public void setTypeChangeListener(Runnable runnable0) {
        this.a = runnable0;
    }
}

