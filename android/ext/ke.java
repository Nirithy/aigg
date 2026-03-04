package android.ext;

import android.view.View.OnClickListener;
import android.view.View;

class ke implements View.OnClickListener {
    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        i.a(i.a(ar.f).setMessage(qk.a(0x7F070159)).setPositiveButton(0x7F07009B, new kf(this)).setNegativeButton(0x7F07009C, null).setCancelable(false), ar.d);  // string:install_cancel_prompt "__app_name__ can be detected when not installed. Do 
                                                                                                                                                                 // you really want to cancel?"
    }
}

