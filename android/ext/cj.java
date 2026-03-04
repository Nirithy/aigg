package android.ext;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.SeekBar;
import java.lang.ref.WeakReference;

class cj extends Config.OptionSeek {
    private WeakReference m;

    cj(int v, int v1, int v2, int v3, String s, boolean z, int v4) {
        super(v, v1, v2, v3, s, z, v4);
        this.m = new WeakReference(null);
    }

    @Override  // android.ext.Config$OptionSeek
    protected void b() {
        super.b();
        SeekBar seekBar0 = (SeekBar)this.l.get();
        if(seekBar0 != null) {
            ImageView imageView0 = new ImageView(seekBar0.getContext());
            imageView0.setImageResource(0x7F02004F);  // drawable:ic_tooltip_edit_white_24dp
            this.m = new WeakReference(imageView0);
            Config.a(imageView0, Config.b(seekBar0.getProgress()));
            ViewParent viewParent0 = seekBar0.getParent();
            if(viewParent0 instanceof ViewGroup) {
                ((ViewGroup)viewParent0).addView(imageView0);
            }
        }
    }

    @Override  // android.ext.Config$OptionSeek
    public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        ImageView imageView0 = (ImageView)this.m.get();
        if(imageView0 == null) {
            return;
        }
        Config.a(imageView0, v * 2 + 24);
    }
}

