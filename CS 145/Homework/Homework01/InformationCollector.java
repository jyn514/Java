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
      
      print("Welcome to Information Collector 9001. It's over 9000!");
      
      print("Enter your name: ");
      name = keyboard.next();
      
      print("Enter your age: ");
      age = keyboard.nextInt();
      
      print("Enter your height in meters:");
      height = keyboard.nextFloat();
      
      print("Enter your blood type:");
      bloodType = keyboard.next();
      
      print("Are you a cat person? (true/false):");
      catPerson = keyboard.nextBoolean();
      
      print("Are you a dog person? (true/false) :");
      dogPerson = keyboard.nextBoolean();
      
      print("Are you an evil reptilian shape shifter? (true/false):");
      reptilianShapeShifter = keyboard.nextBoolean();
      
      print("How much gold is buried on your property? (in kilograms):");
      gold = keyboard.nextFloat();
	  
      System.out.println();
      
      System.out.println(String.format("Name: %s\nAge: %d years old\nHeight: %fm\nBlood Type: %s\nCat Person: %b\nDog Person: %b\nReptilian Shape Shifter: %b\nAmount of Gold buried: %fkg",
                          name, age, height, bloodType, catPerson, dogPerson, reptilianShapeShifter, gold));
  }

}
