public class PV8Z1test {

  static final int maxN = 25;
  static final int maxR = 20;

  static int fPrekoDef(int n, int r) {
    if (n >= r) {
      if (n % 5 == 0) {
        return Math.abs(fPrekoDef(n - r, r) - gPrekoDef(n - 1, r));
      } else {
        return -gPrekoDef(n - 3, r) + fPrekoDef(n - 1, r);
      }
    } else {
      return 3 * r - 2;
    }
  }

  static int gPrekoDef(int n, int r) {
    if (n >= r) {
      if ((n + r) % 6 == 0) {
        return gPrekoDef(n - r, r) + fPrekoDef(n - 2, r) * gPrekoDef(n - r + 1, r);
      } else if ((n + r) % 6 == 1) {
        return fPrekoDef(n - r, r) + gPrekoDef(n - 2, r) * fPrekoDef(n - r + 1, r);
      } else {
        return Math.max(fPrekoDef(n - r + 2, r), gPrekoDef(n - r + 1, r));
      }
    } else {
      return (int) Math.pow(-1, n) - n;
    }
  }

  static int ff(int[] f, int[] g, int i, int n, int r) {
    if (i > n) {
      return f[r];
    } else {
      //f 
      if (i % 5 == 0) {
        f[r] = Math.abs(f[0] - g[r - 1]);
      } else {
        f[r] = -g[r - 3] + f[r - 1];
      }

      // g
      if ((i + r) % 6 == 0) {
        g[r] = g[0] + f[r - 2] * g[1];
      } else if ((i + r) % 6 == 1) {
        g[r] = f[0] + g[r - 2] * f[1];
      } else {
        g[r] = Math.max(f[2], g[1]);
      }

      for (int j = 0; j < r; j++) {
        f[j] = f[j + 1];
        g[j] = g[j + 1];
      }
    }
    return ff(f, g, i + 1, n, r);
  }

  static int fAcu(int n, int r) {
    int f[] = new int[maxR + 1];
    int g[] = new int[maxR + 1];
    if (n < r) {
      return 3 * r - 2;
    } else {
      for (int i = 0; i < r; i++) {
        f[i] = 3 * r - 2;
        g[i] = (int) Math.pow(-1, i) - i;
      }
      return ff(f, g, r, n, r);
    }
  }

  public static int fIter(int n, int r) {
    if (n < r)
      return 3 * r - 2;

    int[] f = new int[r + 1];
    int[] g = new int[r + 1];

    for (int i = 0; i < r; i++) {
      f[i] = 3 * r - 2;
      g[i] = (int) Math.pow(-1, i) - i;
    }

    for (int i = r; i <= n; i++) {

      if (i % 5 == 0) {
        f[r] = Math.abs(f[0] - g[r - 1]);
      } else {
        f[r] = -g[r - 3] + f[r - 1];
      }

      if ((i + r) % 6 == 0) {
        g[r] = g[0] + f[r - 2] * g[1];
      } else if ((i + r) % 6 == 1) {
        g[r] = f[0] + g[r - 2] * f[1];
      } else {
        g[r] = Math.max(f[2], g[1]);
      }

      for (int j = 0; j < r; j++) {
        f[j] = f[j + 1];
        g[j] = g[j + 1];
      }

    }
    return f[r];
  }

  public static void main(String[] args) {
    int n, r;
    do {
      n = Svetovid.in.readInt("Unesite n ( 0<=n<=25 )");
    } while (!(0 <= n && n <= 25));
    do {
      r = Svetovid.in.readInt("Unesite n ( 5<=n<=20 )");
    } while (!(5 <= r && r <= 20));

    Svetovid.out.println("Resenje preko definicje je" + fPrekoDef(n, r));
    Svetovid.out.println("Resenje preko aku parametra je" + fAcu(n, r));
    Svetovid.out.println("Resenje preko aku parametra je" + fIter(n, r));

  }
}
