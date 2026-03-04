package android.ext;

import android.widget.ImageView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;

class ee implements SeekBar.OnSeekBarChangeListener {
    final ConfigListAdapter a;
    private final SeekBar b;
    private final SeekBar c;
    private final SeekBar d;
    private final TextView e;
    private final ImageView f;

    ee(ConfigListAdapter configListAdapter0, SeekBar seekBar0, SeekBar seekBar1, SeekBar seekBar2, TextView textView0, ImageView imageView0) {
        this.a = configListAdapter0;
        this.b = seekBar0;
        this.c = seekBar1;
        this.d = seekBar2;
        this.e = textView0;
        this.f = imageView0;
        super();
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        int v1 = this.b.getProgress();
        int v2 = this.c.getMax() == this.c.getProgress() ? -1 : this.c.getProgress();
        int v3 = this.d.getProgress();
        this.a.a(((float)(10 - v1)) / 10.0f, v2, this.e, this.f, v3);
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar0) {
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar0) {
    }
}

