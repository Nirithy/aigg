package android.ext;

import android.view.View.OnClickListener;
import android.view.View;

class eh implements View.OnClickListener {
    final ConfigListAdapter a;
    private final EditTextSpeeds b;

    eh(ConfigListAdapter configListAdapter0, EditTextSpeeds editTextSpeeds0) {
        this.a = configListAdapter0;
        this.b = editTextSpeeds0;
        super();
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        this.b.setText("0.000000001;0.00000001;0.0000001;0.000001;0.00001;0.0001;0.001;0.002;0.005;0.01;0.02;0.05;0.1;0.2;0.5;0.6;0.75;0.9;1;1.2;1.3;1.5;2;3;4;5;6;9;12;15;20;30;60;120;180;300;600;1200;2400;3600");
    }
}

