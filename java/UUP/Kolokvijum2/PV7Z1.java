public class PV7Z1 {
  static final int granica = 40;

  static int fRec1(int n) {
    if (n == 0) {
      return 1;

    } else if (n == 1) {
      return 3;

    } else if (n == 2) {
      return 2;
    } else {

      if (n % 2 == 1) {
        return fRec1(n - 1) - 2 * fRec1(n - 2);
      } else {
        return fRec1(n - 2) + 3 * fRec1(n - 3);
      }
    }
  }

  static int ff(int f_1, int f_2, int f_3, int i, int n) {
    if (i > n)
      return f_1;
    else if (i % 2 == 1)
      return ff(f_1 - 2 * f_2, f_1, f_2, i + 1, n);
    else
      return ff(f_2 + 3 * f_3, f_1, f_2, i + 1, n);
  }

  static int fRec2(int n) {
    if (n == 0) {
      return 1;

    } else if (n == 1) {
      return 3;

    } else if (n == 2) {
      return 2;
    } else {
      return ff(2, 3, 1, 3, n);
    }
  }

  static int fIter(int n) {
    int fn, f_3 = 1, f_2 = 3, f_1 = 2;
    if (n == 0) {
      fn = f_3;
    } else if (n == 1) {
      fn = f_2;
    } else if (n == 2) {
      fn = f_1;
    } else {
      fn = 0;
      for (int i = 3; i < n; i++) {
        if (i % 2 == 1)
          fn = f_1 - 2 * f_2;
        else
          fn = f_2 + 3 * f_3;
      }
    }
    return fn;
  }

  public static void main(String[] args) {

    for (int i = 0; i < granica; i++) {
      Svetovid.out.println(fRec1(i) + "|" + fRec2(i) + "|" + fIter(i));
    }
  }
}
