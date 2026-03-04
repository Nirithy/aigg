package android.ext;

class mc implements Runnable {
    @Override
    public void run() {
        if((Config.c & 8L) == 0L) {
            StringBuilder stringBuilder0 = new StringBuilder();
            String[] arr_s = ho.a();
            for(int v = 2; v < arr_s.length; v += 2) {
                String s = arr_s[v];
                if(Tools.e(arr_s[v + 1])) {
                    stringBuilder0.append('\n');
                    stringBuilder0.append(s);
                    stringBuilder0.append(" (");
                    stringBuilder0.append(arr_s[v + 1]);
                    stringBuilder0.append(')');
                }
            }
            if(stringBuilder0.length() != 0) {
                stringBuilder0.append('\n');
                rx.a(lh.a(ar.f, Tools.a(qk.a(0x7F0702A3), new Object[]{stringBuilder0.toString()}), 8L, false));  // string:killers_found "You have installed applications that can forcibly close __app_name__:\n__s__\nTo 
                                                                                                                  // avoid this, delete them, or configure them so that they do not terminate the __app_name__.\n\nIf 
                                                                                                                  // you do not experience problems with the unexpected closing of the __app_name__, 
                                                                                                                  // then no action is required, and you can ignore this message."
            }
        }
    }
}

