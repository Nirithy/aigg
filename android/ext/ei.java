package android.ext;

import android.widget.TextView;

class ei implements hd {
    final ConfigListAdapter a;
    private final EditTextSpeeds b;
    private final TextView c;

    ei(ConfigListAdapter configListAdapter0, EditTextSpeeds editTextSpeeds0, TextView textView0) {
        this.a = configListAdapter0;
        this.b = editTextSpeeds0;
        this.c = textView0;
        super();
    }

    public void a() {
        String s;
        int v = 0;
        if(this.b != null && this.c != null) {
            try {
                String s1 = this.b.getText().toString().trim();
                int v1 = this.b.getSelectionStart();
                if(v1 >= 0) {
                    v = v1;
                }
                int v2 = v < s1.length() ? v : s1.length() - 1;
                int v3 = v2 > 0 ? s1.lastIndexOf(59, v2 - 1) : -1;
                if(v3 < 0) {
                    v3 = -1;
                }
                double f = Tools.f(s1.substring(v3 + 1, (s1.indexOf(59, v2) >= 0 ? s1.indexOf(59, v2) : s1.length())));
                if(f > 0.0) {
                    kz kz0 = ky.c(f);
                    s = Tools.a(qk.a(0x7F070176), new Object[]{Tools.a(kz0.b), Tools.a(kz0.a)});  // string:speed_info "__s__ in real time = __s__ in game time"
                }
                else {
                    s = "??";
                }
            }
            catch(NumberFormatException unused_ex) {
                s = "???";
            }
        }
        else {
            s = "?";
        }
        this.c.setText(s);
    }

    @Override  // android.ext.hd
    public void a(EditText editText0, int v, int v1) {
        this.a();
    }

    @Override  // android.ext.hd
    public void a(EditText editText0, CharSequence charSequence0, int v, int v1, int v2) {
        this.a();
    }
}

