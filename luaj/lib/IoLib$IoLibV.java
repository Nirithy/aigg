package luaj.lib;

import java.io.IOException;
import luaj.ap;
import luaj.n;

final class IoLib.IoLibV extends VarArgFunction {
    public IoLib a;
    private IoLib.File b;
    private boolean c;
    private ap d;

    public IoLib.IoLibV() {
    }

    public IoLib.IoLibV(IoLib.File ioLib$File0, String s, int v, IoLib ioLib0) {
        this.b = ioLib$File0;
        this.ak = s;
        this.aj = v;
        this.a = ioLib0;
    }

    public IoLib.IoLibV(IoLib.File ioLib$File0, String s, int v, IoLib ioLib0, boolean z, ap ap0) {
        this(ioLib$File0, s, v, ioLib0);
        this.c = z;
        this.d = ap0.ae();
    }

    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        String s;
        try {
            switch(this.aj) {
                case 0: {
                    return this.a.y(ap0.g());
                }
                case 1: {
                    return this.a.S();
                }
                case 2: {
                    return this.a.z(ap0.g());
                }
                case 3: {
                    return this.a.b(ap0);
                }
                case 4: {
                    return this.a.e(ap0.r(1), ap0.c(2, "r"));
                }
                case 5: {
                    return this.a.C(ap0.g());
                }
                case 6: {
                    return this.a.a(ap0.r(1), ap0.c(2, "r"));
                }
                case 7: {
                    return this.a.c(ap0);
                }
                case 8: {
                    return this.a.T();
                }
                case 9: {
                    return this.a.D(ap0.g());
                }
                case 10: {
                    return this.a.d(ap0);
                }
                case 11: {
                    return this.a.E(ap0.g());
                }
                case 12: {
                    return this.a.L(ap0.g());
                }
                case 13: {
                    return this.a.e(ap0);
                }
                case 14: {
                    return this.a.c(ap0.g(), ap0.e_(2));
                }
                case 15: {
                    return this.a.b(ap0.g(), ap0.c(2, "cur"), ap0.d(3, 0));
                }
                case 16: {
                    return this.a.a(ap0.g(), ap0.r(2), ap0.d(3, 0x2000));
                }
                case 17: {
                    return this.a.d(ap0.g(), ap0.e_(2));
                }
                case 18: {
                    return this.a.a(this.b, this.c, this.d);
                }
                default: {
                    return IoLib.IoLibV.x;
                }
            }
        }
        catch(IOException iOException0) {
            if(this.aj == 18) {
                IoLib.IoLibV.a((iOException0.getMessage() == null ? iOException0.toString() : iOException0.getMessage()), iOException0);
            }
            return IoLib.a(iOException0, this.aj);
        }
        catch(n n0) {
            if(this.aj < IoLib.b.length) {
                s = "io." + IoLib.b[this.aj];
            }
            else if(this.aj < IoLib.b.length + IoLib.c.length) {
                s = "file:" + IoLib.b[this.aj - IoLib.b.length];
            }
            else {
                s = this.aj == 18 ? "(io.lines iterator)" : n0.c;
            }
            n n1 = new n(n0.a, s, n0.b);
            n1.initCause(n0);
            throw n1;
        }
    }
}

