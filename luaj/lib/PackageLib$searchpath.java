package luaj.lib;

import java.io.IOException;
import java.io.InputStream;
import luaj.ap;

public class PackageLib.searchpath extends VarArgFunction {
    final PackageLib a;

    public PackageLib.searchpath(PackageLib packageLib0) {
        this.a = packageLib0;
        super();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        String s = ap0.r(1);
        String s1 = ap0.r(2);
        String s2 = ap0.c(3, ".");
        String s3 = ap0.c(4, "/");
        int v = -1;
        int v1 = s1.length();
        StringBuffer stringBuffer0 = null;
        if(s2.length() > 0) {
            s = s.replace(s2, s3);
        }
        while(true) {
            if(v >= v1) {
                return PackageLib.searchpath.b(PackageLib.searchpath.u, PackageLib.searchpath.m(stringBuffer0.toString()));
            }
            int v2 = v + 1;
            v = s1.indexOf(59, v2) >= 0 ? s1.indexOf(59, v2) : s1.length();
            String s4 = s1.substring(v2, v).replace("?", s);
            InputStream inputStream0 = this.a.g.g.c(s4);
            if(inputStream0 != null) {
                try {
                    inputStream0.close();
                    return PackageLib.searchpath.m(s4);
                }
                catch(IOException unused_ex) {
                    return PackageLib.searchpath.m(s4);
                }
            }
            if(stringBuffer0 == null) {
                stringBuffer0 = new StringBuffer();
            }
            stringBuffer0.append("\n\t" + s4);
        }
    }
}

