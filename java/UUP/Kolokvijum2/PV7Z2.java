public class PV7Z2 {
  static final int granicaGornja = 42;

  static int fRec1(int n) {
    if (n == 0) {
      return 1;
    } else if (n == 1) {
      return 3;
    } else if (n == 2) {
      return 2;
    } else if (n == 3) {
      return 1;
    } else {
      if (n % 10 >= 5) {
        return fRec1(n - 1) + fRec1(n - 3) - (2 * fRec1(n - 4));
      } else {
        return (3 * fRec1(n - 1)) - fRec1(n - 2) - fRec1(n - 4);
      }
    }
  }

  static int ff(int f3, int f2, int f1, int f0, int i, int n) {
    if (i > n) {
      return f3;
    } else {
      if (i % 10 >= 5) {
        return ff(f3 + f1 - 2 * f0, f3, f2, f1, i + 1, n);
      } else {
        return ff(3 * f3 - f2 - f0, f3, f2, f1, i + 1, n);
      }
    }
  }

  static int fRec2(int n) {
    if (n == 0) {
      return 1;
    } else if (n == 1) {
      return 3;
    } else if (n == 2) {
      return 2;
    } else if (n == 3) {
      return 1;
    } else {
      return ff(1, 2, 3, 1, 4, n);
    }
  }

  static int iterativno(int n) {
    int fn, f3 = 1, f2 = 2, f1 = 3, f0 = 1;

    if (n == 0) {
      return f0;
    } else if (n == 1) {
      return f1;
    } else if (n == 2) {
      return f2;
    } else if (n == 3) {
      return f3;
    } else {
      fn = 0;
      for (int i = 4; i <= n; i++) {
        if (i % 10 >= 5) {
          fn = f3 + f1 - 2 * f0;
        } else {
          fn = 3 * f3 - f2 - f0;
        }
        f0 = f1;
        f1 = f2;
        f2 = f3;
        f3 = fn;
      }
    }
    return fn;
  }

  public static void main(String[] args) {
    for (int i = 0; i < granicaGornja; i++) {
      Svetovid.out.println(fRec1(i) + "|" + fRec2(i) + "|" + iterativno(i));
    }
  }
}
