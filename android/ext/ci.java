package android.ext;

class ci implements cv {
    final ch a;

    ci(ch ch0) {
        this.a = ch0;
        super();
    }

    @Override  // android.ext.cv
    public void a(int v) {
        StringBuilder stringBuilder0;
        if((v & 1) == 0) {
            stringBuilder0 = null;
        }
        else {
            stringBuilder0 = new StringBuilder();
            stringBuilder0.append(qk.a(0x7F070348));  // string:hide_1_warn "You selected the first item. Freezing values can cause severe 
                                                      // lags in the game."
        }
        if((v & 8) != 0) {
            if(stringBuilder0 == null) {
                stringBuilder0 = new StringBuilder();
            }
            else {
                stringBuilder0.append("\n\n");
            }
            stringBuilder0.append(qk.a(0x7F070349));  // string:hide_4_warn "You selected the fourth item. Some features will not work: __speedhack__, 
                                                      // __unrandomizer__, __allocate_page__."
        }
        if(stringBuilder0 != null) {
            i.a(i.c().setMessage(stringBuilder0.toString()).setPositiveButton(0x7F07009D, null));  // string:ok "OK"
        }
    }
}

