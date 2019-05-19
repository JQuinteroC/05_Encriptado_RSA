
/**
 *
 * @author <a href="https://github.com/JQuinteroC">JQuinteroC</a>
 */
public class RSA extends abs implements primos {

    int fi;
    int z;
    int s;

    @Override
    public int FI(int p, int q) {
        this.fi = ((p - 1) * (q - 1));

        return fi;
    }

    @Override
    public int Z(int p, int q) {
        z = (p * q);

        return z;

    }

    @Override
    public int S(int n) {
        s = 0;
        for (int x = 0; x <= (p*q)+1; x++) {
            if (((n * x) % fi) == 1) {
                s = x;
                break;
            }
        }

        return s;
    }

    @Override
    public int encriptar(int c) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado = (resultado * (c % z)) % z;
        }

        return resultado;
    }

    @Override
    public int desencriptar(int c) {

        int resultado = 1;
        for (int i = 1; i <= s; i++) {
            resultado = (resultado * (c % z)) % z;
        }
        return resultado;
    }

    @Override
    public boolean isPimo(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

abstract class abs {

    int p;
    int q;
    int n;

    public abstract int FI(int p, int q);

    public abstract int Z(int p, int q);

    public abstract int S(int n);

    public abstract int encriptar(int c);

    public abstract int desencriptar(int c);
}

interface primos {

    public boolean isPimo(int n);
}
