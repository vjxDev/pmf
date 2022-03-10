/*
  Za n=7 i r=5 rez f_n=-22
  Za n=25 i r=10 rez f_n=-119494
  Za n=17 i r=5 rez f_n=-1190
*/

public class Zad3 {

  public static int fDef(int n, int r) {
    if (n >= r) {
      if (n <= 9)
        return fDef(n - r + 3, r) + gDef(n - r + 2, r) - 5 * fDef(n - r, r);
      else
        return -2 * fDef(n - 1, r) + gDef(n - 1, r) - 4 * gDef(n - r + 1, r) + gDef(n - r, r);
    } else {
      return r - n;
    }
  }

  public static int gDef(int n, int r) {
    if (n >= r) {
      if (n % 5 == 0)
        return -(gDef(n - r + 1, r)) + fDef(n - 2, r);
      else
        return 3 * fDef(n - r + 2, r) - 4 * (gDef(n - 2, r) + fDef(n - r, r));
    } else {
      return r + n;
    }
  }

  public static int fIter(int n, int r) {
    if (n < r)
      return r - n;
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    for (int i = 0; i < r; i++) {
      f[i] = r - i;
      g[i] = r + i;
    }
    for (int i = r; i <= n; i++) {
      if (i > 9)
        f[r] = -2 * f[r - 1] + g[r - 1] - 4 * g[1] + g[0];
      else
        f[r] = f[3] + g[2] - 5 * f[0];

      if (i % 5 == 0)
        g[r] = -g[1] + f[r - 2];
      else
        g[r] = 3 * f[2] - 4 * (g[r - 2] + f[0]);

      for (int j = 0; j < r; j++) {
        f[j] = f[j + 1];
        g[j] = g[j + 1];
      }
    }
    return f[r];
  }

  public static int fg(int[] f, int[] g, int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      for (i = r; i <= n; i++) {
        if (i > 9)
          f[r] = -2 * f[r - 1] + g[r - 1] - 4 * g[1] + g[0];
        else
          f[r] = f[3] + g[2] - 5 * f[0];

        if (i % 5 == 0)
          g[r] = -g[1] + f[r - 2];
        else
          g[r] = 3 * f[2] - 4 * (g[r - 2] + f[0]);

        for (int j = 0; j < r; j++) {
          f[j] = f[j + 1];
          g[j] = g[j + 1];
        }
      }
    }
    return fg(f, g, i + 1, n, r);
  }

  public static int fRek(int n, int r) {
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];
    if (n < r)
      return r - n;
    else {
      for (int i = 0; i < r; i++) {
        f[i] = r - i;
        g[i] = r + i;
      }
    }
    return fg(f, g, r, n, r);
  }

  static final int nMin = 0, nMax = 30, rMin = 5, rMax = 15;

  public static void main(String[] args) {
    int n, r;
    do {
      n = Svetovid.in
          .readInt("Unesite n takvo da je manje ili jednako od " + nMax + " i vece ili jednako od " + nMin + ": ");
    } while (nMin > n && nMax < n);

    do {
      r = Svetovid.in
          .readInt("Unesite r takvo da je manje ili jednako od " + rMax + " i vece ili jednako od " + rMin + ": ");
    } while (rMin > r && rMax < r);
    for (int i = nMin; i <= nMax; i++) {
      for (int j = rMin; j <= rMax; j++) {
        if (fIter(i, j) != fDef(i, j) || fIter(i, j) != fRek(i, j)) {
          Svetovid.out.println("" + i + "|" + j);

        }
      }
    }

    Svetovid.out.println("Po difiniciji: " + fDef(n, r));
    Svetovid.out.println("Po akumulirajucim: " + fRek(n, r));
    Svetovid.out.println("Po iteraciji: " + fIter(n, r));
  }
}
