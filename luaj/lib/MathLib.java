package luaj.lib;

import luaj.LuaDouble;
import luaj.LuaLong;
import luaj.LuaTable;
import luaj.LuaValue;
import luaj.o;

public class MathLib extends TwoArgFunction {
    static double a(LibFunction libFunction0, int v, LuaValue luaValue0) {
        try {
            return luaValue0.x();
        }
        catch(o o0) {
            MathLib.a(v, MathLib.a(libFunction0), o0.getMessage());
            return 0.0;
        }
    }

    static double a(LibFunction libFunction0, int v, LuaValue luaValue0, double f) {
        try {
            return luaValue0.b(f);
        }
        catch(o o0) {
            MathLib.a(v, MathLib.a(libFunction0), o0.getMessage());
            return 0.0;
        }
    }

    // 去混淆评级： 低(20)
    static String a(LibFunction libFunction0) {
        return libFunction0.getClass().getName().replace("luaj.lib.MathLib" + '$', "math.");
    }

    @Override  // luaj.lib.TwoArgFunction
    public LuaValue a(LuaValue luaValue0, LuaValue luaValue1) {
        LuaValue luaValue2 = new LuaTable(0, 0x40);
        ((LuaTable)luaValue2).a("abs", new MathLib.abs());
        ((LuaTable)luaValue2).a("acos", new MathLib.acos());
        ((LuaTable)luaValue2).a("asin", new MathLib.asin());
        MathLib.atan2 mathLib$atan20 = new MathLib.atan2();
        ((LuaTable)luaValue2).a("atan", mathLib$atan20);
        ((LuaTable)luaValue2).a("atan2", mathLib$atan20);
        ((LuaTable)luaValue2).a("ceil", new MathLib.ceil());
        ((LuaTable)luaValue2).a("cos", new MathLib.cos());
        ((LuaTable)luaValue2).a("cosh", new MathLib.cosh());
        ((LuaTable)luaValue2).a("deg", new MathLib.deg());
        ((LuaTable)luaValue2).a("exp", new MathLib.exp());
        ((LuaTable)luaValue2).a("floor", new MathLib.floor());
        ((LuaTable)luaValue2).a("fmod", new MathLib.fmod());
        ((LuaTable)luaValue2).a("frexp", new MathLib.frexp());
        ((LuaTable)luaValue2).a("huge", LuaDouble.b);
        ((LuaTable)luaValue2).a("ldexp", new MathLib.ldexp());
        ((LuaTable)luaValue2).a("log", new MathLib.log());
        ((LuaTable)luaValue2).a("max", new MathLib.max());
        ((LuaTable)luaValue2).a("maxinteger", LuaLong.a);
        ((LuaTable)luaValue2).a("min", new MathLib.min());
        ((LuaTable)luaValue2).a("mininteger", LuaLong.b);
        ((LuaTable)luaValue2).a("modf", new MathLib.modf());
        ((LuaTable)luaValue2).a("pi", 3.141593);
        ((LuaTable)luaValue2).a("pow", new MathLib.pow());
        MathLib.random mathLib$random0 = new MathLib.random();
        ((LuaTable)luaValue2).a("random", mathLib$random0);
        ((LuaTable)luaValue2).a("randomseed", new MathLib.randomseed(mathLib$random0));
        ((LuaTable)luaValue2).a("rad", new MathLib.rad());
        ((LuaTable)luaValue2).a("sin", new MathLib.sin());
        ((LuaTable)luaValue2).a("sinh", new MathLib.sinh());
        ((LuaTable)luaValue2).a("sqrt", new MathLib.sqrt());
        ((LuaTable)luaValue2).a("tan", new MathLib.tan());
        ((LuaTable)luaValue2).a("tanh", new MathLib.tanh());
        ((LuaTable)luaValue2).a("tointeger", new MathLib.tointeger());
        ((LuaTable)luaValue2).a("type", new MathLib.type());
        ((LuaTable)luaValue2).a("ult", new MathLib.ult());
        luaValue1.a("math", luaValue2);
        if(!luaValue1.j("package").F()) {
            luaValue1.j("package").j("loaded").a("math", luaValue2);
        }
        return luaValue2;
    }

    static long b(LibFunction libFunction0, int v, LuaValue luaValue0) {
        try {
            return luaValue0.w();
        }
        catch(o o0) {
            MathLib.a(v, MathLib.a(libFunction0), o0.getMessage());
            return 0L;
        }
    }
}

