package android.ext;

import luaj.LuaLong;
import luaj.LuaTable;
import luaj.ap;

final class Script.getSelectedElements extends Script.ApiFunction {
    final Script d;

    Script.getSelectedElements(Script script0) {
        this.d = script0;
        super();
    }

    @Override  // android.ext.Script$ApiFunction
    String a() {
        return "gg.getSelectedElements() -> table || string with error";
    }

    @Override  // android.ext.Script$ApiFunction
    public ap d(ap ap0) {
        ow ow0 = MainService.instance.K;
        boolean[] arr_z = ow0.a();
        ap ap1 = new LuaTable();
        int v = 1;
        int v1 = 0;
        while(v1 < arr_z.length) {
            try {
                if(arr_z[v1]) {
                    goto label_9;
                }
            }
            catch(IndexOutOfBoundsException unused_ex) {
            }
            goto label_13;
            try {
            label_9:
                ((LuaTable)ap1).b(v, LuaLong.b(ow0.a(v1)));
            }
            catch(IndexOutOfBoundsException unused_ex) {
            }
            ++v;
        label_13:
            ++v1;
        }
        return ap1;
    }

    @Override  // android.ext.Script$ApiFunction
    protected int m_() {
        return 0;
    }
}

