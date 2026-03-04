package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import java.io.File;

class ln implements DialogInterface.OnClickListener {
    private final File a;

    ln(File file0) {
        this.a = file0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        this.a.delete();
        if(v != 0) {
            return;
        }
        Config.a(0x7F0B00BA).d = 1;  // id:selinux
        Config.c();
        ar.h();
    }
}

