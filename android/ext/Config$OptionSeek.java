package android.ext;

import android.content.DialogInterface;
import android.fix.i;
import android.view.View;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import java.lang.ref.WeakReference;

public class Config.OptionSeek extends ct implements SeekBar.OnSeekBarChangeListener {
    int k;
    protected WeakReference l;

    public Config.OptionSeek(int v, int v1, int v2, int v3, String s, boolean z) {
        super(v, v1, v3, s, z);
        this.l = new WeakReference(null);
        this.k = v2;
    }

    public Config.OptionSeek(int v, int v1, int v2, int v3, String s, boolean z, int v4) {
        this(v, v1, v2, v3, s, z);
        this.h = v4;
    }

    @Override  // android.ext.ct
    public boolean a(DialogInterface dialogInterface0, int v) {
        SeekBar seekBar0 = (SeekBar)this.l.get();
        if(seekBar0 == null) {
            return false;
        }
        this.d = seekBar0.getProgress();
        Config.c();
        return true;
    }

    protected void b() {
        View view0 = i.a(0x7F04000F, null);  // layout:option_seek
        SeekBar seekBar0 = (SeekBar)view0.findViewById(0x7F0B004F);  // id:seek
        seekBar0.setMax(this.k);
        seekBar0.setProgress(this.d);
        seekBar0.setOnSeekBarChangeListener(this);
        this.l = new WeakReference(seekBar0);
        android.ext.i.c(android.ext.i.c().setCustomTitle(Config.a(this.a, this.h, this.g)).setView(view0).setPositiveButton(0x7F07009D, this).setNegativeButton(0x7F0700A1, null).create());  // string:ok "OK"
    }

    @Override  // android.ext.ct
    public void d() {
        this.b();
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar0) {
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar0) {
    }

    @Override  // android.ext.ct
    public String toString() {
        return Tools.c(this.a);
    }
}

