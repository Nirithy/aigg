package android.ext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

class db extends gr {
    final ConfigListAdapter a;

    db(ConfigListAdapter configListAdapter0, String s) {
        this.a = configListAdapter0;
        super(s);
    }

    @Override
    public void run() {
        StringBuilder stringBuilder0 = new StringBuilder();
        try {
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(new URL("http://gameguardian.net/version.txt").openStream()));
            String s;
            while((s = bufferedReader0.readLine()) != null) {
                stringBuilder0.append(s);
                stringBuilder0.append('\n');
            }
            bufferedReader0.close();
        }
        catch(Throwable throwable0) {
            la.c("Load changelog", throwable0);
            stringBuilder0.append(throwable0.toString());
        }
        rx.a(new dc(this, stringBuilder0));
    }
}

