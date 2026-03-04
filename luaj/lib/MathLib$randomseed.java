package luaj.lib;

import java.util.Random;
import luaj.LuaValue;

class MathLib.randomseed extends OneArgFunction {
    final MathLib.random a;

    MathLib.randomseed(MathLib.random mathLib$random0) {
        this.a = mathLib$random0;
    }

    @Override  // luaj.lib.OneArgFunction
    public LuaValue a(LuaValue luaValue0) {
        this.a.a = new Random(MathLib.b(this, 1, luaValue0));
        return MathLib.randomseed.x;
    }
}

