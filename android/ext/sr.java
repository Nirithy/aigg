package android.ext;

import android.text.Editable;
import android.widget.EditText;

class sr implements Runnable {
    private final EditText a;

    sr(EditText editText0) {
        this.a = editText0;
        super();
    }

    @Override
    public void run() {
        Editable editable0 = this.a.getText();
        if(editable0.length() > 0) {
            try {
                editable0.replace(0, 1, editable0.subSequence(0, 1), 0, 1);
            }
            catch(Throwable throwable0) {
                la.a(throwable0);
            }
            this.a.selectAll();
        }
    }
}

