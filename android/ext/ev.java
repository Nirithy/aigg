package android.ext;

import java.io.File;

class ev implements Runnable {
    final eu a;
    private final File b;

    ev(eu eu0, File file0) {
        this.a = eu0;
        this.b = file0;
        super();
    }

    @Override
    public void run() {
        i.a(i.c().setMessage(Tools.a(qk.a(0x7F070352), new Object[]{this.b.getAbsolutePath()})).setPositiveButton(qk.a(0x7F070164), new ew(this, this.b)).setNegativeButton(qk.a(0x7F07009D), null));  // string:need_fixer "A problem was detected with this 64-bit virtual space.\n\nTo 
                                                                                                                                                                                                       // fix it:\n\n1. Install the __fixer__ application. (From this dialog, either manually 
                                                                                                                                                                                                       // along the path: \n__s__\n).\n\n2. Add __fixer__ to the virtual space.\n\n3. Run 
                                                                                                                                                                                                       // __fixer__ in virtual space.\n\n4. Remove __fixer__.\n\n5. Restart the __app_name__ 
                                                                                                                                                                                                       // in virtual space."
    }
}

