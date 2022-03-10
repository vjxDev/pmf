public class Zad {

  public static int fDef(int n, int r) {
    if (n < r)
      return (int) Math.pow(n, 2) - r;
    else if ((n - r) % 3 == 0)
      return -gDef(n - r, r) + fDef(n - 1, r) - fDef(n - r + 2, r);
    else
      return -3 * (-gDef(n - 1, r) - 5 * fDef(n - r, r)) + gDef(n - 2, r);
  }

  public static int gDef(int n, int r) {
    if (n >= r)
      return (int) Math.pow(-1, r) * (gDef(n - r + 1, r) - fDef(n - 2, r) * fDef(n - r + 2, r));
    else if (fDef(n, r) % 2 == 0)
      return Math.abs(n - r - 3);
    else
      return -n;
  }

  public static int fIter(int n, int r) {
    if (n < r)
      return (int) Math.pow(n, 2) - r;
    int[] f = new int[r + 1];
    int[] g = new int[r + 1];

    for (int i = 0; i < r; i++) {
      f[i] = (int) Math.pow(i, 2) - r;
      if ((f[i] % 2) == 0) {
        g[i] = Math.abs(i - r - 3);
      } else {
        g[i] = -i;
      }
    }

    for (int i = r; i <= n; i++) {
      if ((i - r) % 3 == 0) {
        f[r] = -g[0] + f[r - 1] - f[2];
      } else {
        f[r] = -3 * (-g[r - 1] - 5 * f[0]) + g[r - 2];
      }

      g[r] = ((int) Math.pow(-1, r)) * (g[1] - (f[r - 2] * f[2]));

      for (int j = 0; j < r; j++) {
        f[j] = f[j + 1];
        g[j] = g[j + 1];
      }
    }

    return f[r];
  }

  public static int fg(int f[], int g[], int i, int n, int r) {
    if (i > n)
      return f[r];
    else {
      for (i = r; i <= n; i++) {
        if ((i - r) % 3 == 0) {
          f[r] = -g[0] + f[r - 1] - f[2];
        } else {
          f[r] = -3 * (-g[r - 1] - 5 * f[0]) + g[r - 2];
        }

        g[r] = ((int) Math.pow(-1, r)) * (g[1] - (f[r - 2] * f[2]));
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
      return (int) Math.pow(n, 2) - r;
    else {
      for (int i = 0; i < r; i++) {
        f[i] = (int) Math.pow(i, 2) - r;
        if ((f[i] % 2) == 0) {
          g[i] = Math.abs(i - r - 3);
        } else {
          g[i] = -i;
        }
      }
      return fg(f, g, r, n, r);
    }
  }

  public static final int nMin = 0, nMax = 30, rMin = 5, rMax = 15;

  public static void main(String[] args) {
    int n, r;
    do {
      n = Svetovid.in.readInt("Unesite n takvo da je manje od " + nMax + " i da je vece od " + nMin + ": ");
    } while (!(nMin <= n && n <= nMax));

    do {
      r = Svetovid.in.readInt("Unesite r takvo da je manje od " + rMax + " i da je vece od " + rMin + ": ");
    } while (!(rMin <= r && r <= rMax));

    Svetovid.out.println("Preko definicije: " + fDef(n, r));
    Svetovid.out.println("Preko akumulirajucih parametara: " + fRek(n, r));
    Svetovid.out.println("Preko iteracionih: " + fIter(n, r));

  }
}
