package android.ext;

class nf implements Runnable {
    final MainService a;
    private final String b;
    private final CharSequence c;

    nf(MainService mainService0, String s, CharSequence charSequence0) {
        this.a = mainService0;
        this.b = s;
        this.c = charSequence0;
        super();
    }

    @Override
    public void run() {
        if(this.b != null) {
            this.a.A.setText(this.b);
        }
        if(this.c != null) {
            this.a.y.setText(this.c);
        }
        this.a.x.setVisibility(8);
    }
}

