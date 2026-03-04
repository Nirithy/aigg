package android.ext;

import android.widget.Button;

class sd implements Runnable {
    final TimeJumpPanel a;

    sd(TimeJumpPanel timeJumpPanel0) {
        this.a = timeJumpPanel0;
        super();
    }

    @Override
    public void run() {
        this.a.e = (Button)this.a.findViewById(0x7F0B0147);  // id:time_jump_last
        this.a.f = (Button)this.a.findViewById(0x7F0B0146);  // id:time_jump
        this.a.e.setOnClickListener(this.a);
        this.a.f.setOnClickListener(this.a);
        this.a.j();
        HotPoint hotPoint0 = MainService.instance.l;
        float f = hotPoint0.getLayoutAlpha();
        this.a.setLayoutAlpha(f);
        int v = hotPoint0.getSizePx();
        this.a.setMinSize(v);
    }
}

