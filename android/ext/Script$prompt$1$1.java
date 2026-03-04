package android.ext;

import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;

class Script.prompt.1.1 implements SeekBar.OnSeekBarChangeListener {
    final Script.prompt.1 a;
    private final TextView b;
    private final int c;

    Script.prompt.1.1(Script.prompt.1 script$prompt$10, TextView textView0, int v) {
        this.a = script$prompt$10;
        this.b = textView0;
        this.c = v;
        super();
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        this.b.setText(Integer.toString(this.c + v));
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar0) {
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar0) {
    }
}

