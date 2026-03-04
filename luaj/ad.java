package luaj;

interface ad {
    int a(int arg1);

    ad a(ad arg1);

    ad a(ae arg1);

    ad a(ae arg1, LuaValue arg2);

    ae a();

    ae a(LuaValue arg1);

    int b(int arg1);

    ad b(ad arg1);

    boolean b(LuaValue arg1);

    ad u_();
}

