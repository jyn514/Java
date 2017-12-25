import java.util.Random;

public class CubeScrambler {
  private static final String SIDES = "UDFBLR"; // up down front back left right
  private static final String MODIFIERS = "'2";
  
  private static Random rand = new Random();

  public static void main(String[] args) {
    System.out.println(makeScramble(12));
  }
  
  static String makeScramble(int length) { // length of scramble
    StringBuilder result = new StringBuilder();
    
    char lastSide = '0'; // hacky
    
    for (int i = 0; i < length; i++) {
      char side = getSide(lastSide);
      lastSide = side;
      
      result.append(side);
      
      if (rand.nextInt(3) != 0) { // 2/3 chance
        result.append(MODIFIERS.charAt(rand.nextInt(2)));
      }
      
      result.append(' ');
    }
    
    return result.toString();
  }

  static char getSide(char lastSide) {
    char side = SIDES.charAt(rand.nextInt(SIDES.length()));
    if (side == lastSide) {
      return getSide(lastSide);
    }
    return side;
  }
}
