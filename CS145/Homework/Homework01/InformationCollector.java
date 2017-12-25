/**
 * Created by Joshua Nelson 
 */

import java.util.Scanner;

public class InformationCollector {
  
  static Scanner keyboard = new Scanner(System.in);
  
  public static void main(String[] args) { 
      String name;
      int age;
      float height;
      String bloodType;
      boolean catPerson;
      boolean dogPerson;
      boolean reptilianShapeShifter;
      float gold;
      
      System.out.println("Welcome to Information Collector 9001. It's over 9000!");
      
      System.out.println("Enter your name: ");
      name = keyboard.next();
      
      System.out.println("Enter your age: ");
      age = keyboard.nextInt();
      
      System.out.println("Enter your height in meters:");
      height = keyboard.nextFloat();
      
      System.out.println("Enter your blood type:");
      bloodType = keyboard.next();
      
      System.out.println("Are you a cat person? (true/false):");
      catPerson = keyboard.nextBoolean();
      
      System.out.println("Are you a dog person? (true/false) :");
      dogPerson = keyboard.nextBoolean();
      
      System.out.println("Are you an evil reptilian shape shifter? (true/false):");
      reptilianShapeShifter = keyboard.nextBoolean();
      
      System.out.println("How much gold is buried on your property? (in kilograms):");
      gold = keyboard.nextFloat();
	  
      System.out.println();
      
      System.out.println(String.format("Name: %s\nAge: %d years old\nHeight: %fm\nBlood Type: %s\nCat Person: %b\nDog Person: %b\nReptilian Shape Shifter: %b\nAmount of Gold buried: %fkg",
                          name, age, height, bloodType, catPerson, dogPerson, reptilianShapeShifter, gold));
  }

}
