package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import java.io.File;

class Script.ScriptThread.1 implements DialogInterface.OnClickListener {
    final Script.ScriptThread a;

    Script.ScriptThread.1(Script.ScriptThread script$ScriptThread0) {
        this.a = script$ScriptThread0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        File file0 = (File)this.a.a.b;
        if(!Tools.b(file0)) {
            return;
        }
        MainService.instance.a(file0.getAbsolutePath(), this.a.a.e, this.a.a.f);
    }
}

