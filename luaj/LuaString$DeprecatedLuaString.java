package luaj;

class LuaString.DeprecatedLuaString extends LuaString {
    public LuaString.DeprecatedLuaString(byte[] arr_b, int v, int v1) {
        super(arr_b, v, v1, null);
    }

    @Override  // luaj.LuaValue
    public boolean Q() {
        return true;
    }
}

