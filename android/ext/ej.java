package android.ext;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;

class ej implements DialogInterface.OnClickListener {
    final ConfigListAdapter a;
    private final EditTextSpeeds b;

    ej(ConfigListAdapter configListAdapter0, EditTextSpeeds editTextSpeeds0) {
        this.a = configListAdapter0;
        this.b = editTextSpeeds0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface0, int v) {
        String s = this.b.getText().toString().trim();
        iw.a(s, 16);
        MainService.instance.ab.a(s);
    }
}

