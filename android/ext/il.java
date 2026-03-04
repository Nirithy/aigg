package android.ext;

import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;

class il implements SeekBar.OnSeekBarChangeListener {
    final ik a;
    private final TextView b;

    il(ik ik0, TextView textView0) {
        this.a = ik0;
        this.b = textView0;
        super();
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
        this.b.setText(v + 1);
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar0) {
    }

    @Override  // android.widget.SeekBar$OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar0) {
    }
}

