package android.ext;

import java.io.File;
import luaj.lib.IoLib.File;
import luaj.lib.IoLib;

final class Script.IoLibSafe extends IoLib {
    final Script a;

    Script.IoLibSafe(Script script0) {
        this.a = script0;
        super();
    }

    @Override  // luaj.lib.IoLib
    protected IoLib.File a(String s, char c) {
        if(this.a.a(s, c == 0x72)) {
            File file0 = new File(Tools.l(), "empty.txt");
            file0.createNewFile();
            IoLib.File ioLib$File0 = super.a(file0.getAbsolutePath(), c);
            file0.delete();
            return ioLib$File0;
        }
        return super.a(s, c);
    }
}

