class booleanOps {
  public boolean sleepIn(boolean weekday, boolean vacation) {
    return !weekday || vacation;
  }

  public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    return aSmile == bSmile;
  }

  public int sumDouble(int a, int b) {
    if (a == b) {
      return 4 * a;
    } else {
      return a + b;
    }
  }

  //introduces class Math
  public int diff21(int n) {
    if (n > 21) {
      return 2 * Math.abs(21 - n);
    } else {
      return Math.abs(21 - n);
    }
  }

  public boolean makes10(int a, int b) {
    return a == 10 || b == 10 || a + b == 10;
  }

  public boolean nearHundred(int n) {
    return Math.abs(100 - n) <= 10 || Math.abs(200 - n) <= 10;
  }

  public boolean posNeg(int a, int b, boolean negative) {
    if (negative) {
      return a < 0 && b < 0;
    } else {
      return a < 0 && b > 0 || a > 0 && b < 0;
    }
  }
}