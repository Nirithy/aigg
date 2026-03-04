package android.ext;

import android.text.Editable;

class iv {
    Editable a;
    int b;

    public iv(Editable editable0) {
        this.a = editable0;
        this.b = 1;
        while(true) {
            if(this.b >= editable0.length()) {
                return;
            }
            switch(editable0.charAt(this.b)) {
                case 9: 
                case 0x20: {
                    ++this.b;
                    break;
                }
                default: {
                    return;
                }
            }
        }
    }

    void a(int v) {
        int v1 = 0;
        while(v1 < v * 2) {
            ++this.b;
        label_3:
            while(this.b < this.a.length()) {
                switch(this.a.charAt(this.b)) {
                    case 9: 
                    case 0x20: {
                        ++this.b;
                        continue;
                    }
                    default: {
                        break label_3;
                    }
                }
            }
            ++v1;
        }
    }

    void a(int v, String s) {
        int v1 = this.b;
        this.a(v);
        if(this.b <= this.a.length()) {
            this.a.replace(v1, this.b, s);
        }
        this.b = s.length() - (this.b - v1) + this.b;
    }

    void a(String s) {
        if(this.b <= this.a.length()) {
            this.a.insert(this.b, s);
        }
        this.b += s.length();
    }
}

