package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.widget.SeekBar;

class im implements DialogInterface.OnClickListener {
    final ik a;
    private final SeekBar b;

    im(ik ik0, SeekBar seekBar0) {
        this.a = ik0;
        this.b = seekBar0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        try {
            ik.a("0", MainService.a() & 0x7F, 0x20000000, this.b.getProgress() + 1, this.a.h.d(0), this.a.h.d(1), this.a.h.p());
        }
        catch(NumberFormatException numberFormatException0) {
            re.a(numberFormatException0, this.a.h.o());
        }
    }
}

