package luaj.lib;

import luaj.LuaDouble;
import luaj.LuaLong;
import luaj.LuaString;
import luaj.LuaValue;
import luaj.a;
import luaj.ap;

final class StringLib.format extends VarArgFunction {
    @Override  // luaj.lib.VarArgFunction
    public ap a_(ap ap0) {
        LuaString luaString0 = ap0.s(1);
        int v = luaString0.L();
        a a0 = new a(v);
        k k0 = null;
        int v1 = 0;
        int v2 = 1;
        while(v1 < v) {
            int v3 = luaString0.b(v1);
            switch(v3) {
                case 10: {
                    a0.a("\n");
                    ++v1;
                    break;
                }
                case 37: {
                    if(v1 + 1 >= v) {
                        goto label_62;
                    }
                    else if(luaString0.b(v1 + 1) == 37) {
                        v1 += 2;
                        a0.a(37);
                    }
                    else {
                        ++v2;
                        k k1 = new k(ap0, luaString0, v1 + 1);
                        v1 = k1.c + (v1 + 1);
                        switch(k1.b) {
                            case 99: {
                                k1.a(a0, ((byte)ap0.o(v2)));
                                break;
                            }
                            case 65: 
                            case 69: 
                            case 71: 
                            case 97: 
                            case 101: 
                            case 102: 
                            case 103: {
                                k1.a(a0, ap0.m(v2));
                                break;
                            }
                            case 0x71: {
                                LuaValue luaValue0 = ap0.c(v2);
                                switch(luaValue0.e_()) {
                                    case 0: 
                                    case 1: {
                                        a0.a(luaValue0.d_());
                                        break;
                                    }
                                    case 3: {
                                        if(luaValue0 instanceof LuaDouble) {
                                            if(k0 == null) {
                                                k0 = new k(ap0, LuaString.c("%a"), 1);
                                            }
                                            k0.a(a0, luaValue0.x());
                                        }
                                        else if(!(luaValue0 instanceof LuaLong)) {
                                            a0.b(luaValue0);
                                        }
                                        else if(luaValue0.q() == 0x8000000000000000L) {
                                            a0.a("0x8000000000000000");
                                        }
                                        else {
                                            a0.b(luaValue0);
                                        }
                                        break;
                                    }
                                    case 4: {
                                        StringLib.a(a0, ap0.s(v2));
                                        break;
                                    }
                                    default: {
                                        StringLib.format.a(v2, "string.format", "\'" + luaValue0 + "\': value has no literal form");
                                    }
                                }
                                break;
                            }
                            case 0x73: {
                                LuaString luaString1 = BaseLib.y(ap0.c(v2));
                                if(k1.a != -1 || luaString1.L() < 100) {
                                    k1.a(a0, luaString1);
                                }
                                else {
                                    a0.a(luaString1);
                                }
                                break;
                            }
                            case 88: 
                            case 100: 
                            case 105: 
                            case 0x6F: 
                            case 0x75: 
                            case 120: {
                                k1.a(a0, ap0.p(v2));
                                break;
                            }
                            default: {
                                StringLib.format.f(("invalid option \'%" + ((char)k1.b) + "\' to \'string.format\'"));
                            }
                        }
                    }
                    break;
                }
                default: {
                    a0.a(((byte)v3));
                    ++v1;
                }
            }
            continue;
        label_62:
            ++v1;
        }
        return a0.b();
    }
}

