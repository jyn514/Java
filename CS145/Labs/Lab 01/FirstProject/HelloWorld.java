/**
 * Written by Joshua Nelson and John Michael
 */

import java.util.Scanner;

public class HelloWorld {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Hello, World!");

    System.out.println("What is your name?");
    String name = keyboard.nextLine();
    System.out.println("Greetings " + name);

    System.out.println("How many cats do you have?");
    int cats = keyboard.nextInt();
    System.out.println(String.format("How does one live with %s cats?", cats));
    
    keyboard.close();
  }
}
