package android.ext;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.fix.Button;
import android.fix.j;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;

public class SystemSpinner extends Button implements DialogInterface.OnClickListener, View.OnClickListener {
    protected int b;
    protected DialogInterface.OnClickListener c;
    protected j d;

    public SystemSpinner(Context context0) {
        super(context0);
        this.d = null;
    }

    public SystemSpinner(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.d = null;
    }

    public SystemSpinner(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.d = null;
    }

    protected void a() {
        j j0 = this.d;
        int v = j0.size();
        CharSequence[] arr_charSequence = new CharSequence[v];
        for(int v1 = 0; v1 < v; ++v1) {
            arr_charSequence[v1] = (CharSequence)j0.valueAt(v - 1 - v1);
        }
        i.a(i.a(this.getContext()).setSingleChoiceItems(arr_charSequence, v - 1 - j0.indexOfKey(this.b), this));
    }

    public int getSelected() {
        return this.b;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.setSelected(this.d.keyAt(this.d.size() - 1 - v));
        Tools.a(dialogInterface0);
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(this.d != null && this.d.size() != 0) {
            this.a();
        }
    }

    public void setData(j j0) {
        if(j0 != null) {
            this.d = j0;
            int v = j0.size();
            if(v != 0) {
                this.b = j0.keyAt(v - 1);
                this.setOnClickListener(this);
            }
        }
    }

    public void setOnItemSelectedListener(DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        this.c = dialogInterface$OnClickListener0;
    }

    public void setSelected(int v) {
        j j0 = this.d;
        if(j0 != null) {
            CharSequence charSequence0 = (CharSequence)j0.get(v);
            if(charSequence0 == null) {
                if(j0.size() == 1) {
                    charSequence0 = (CharSequence)j0.valueAt(0);
                    v = j0.keyAt(0);
                }
                else {
                    charSequence0 = "???";
                }
            }
            this.setText(charSequence0);
            this.b = v;
            if(this.c != null) {
                this.c.onClick(null, v);
            }
        }
    }
}

