package exercises;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class Calculator {

    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

   public static final int FIRST_Number = 2;
   public static final int SECOND_Number = 3;

   Calculator calculator = new Calculator();
   private int correctExpectedResult = 5;
   private int incorrectExpectedResult = 6;

   @Test
   public void testCase1(){
   int actualResult = calculator.add(FIRST_Number,SECOND_Number);
   assertTrue(correctExpectedResult==actualResult);


   }

   @Test
    public void testCase2(){
       int actualResult = calculator.add(FIRST_Number,SECOND_Number);
       assertFalse(incorrectExpectedResult==actualResult);

   }

   @Test
    public void testCase3(){
       int actualResult = calculator.add(FIRST_Number,SECOND_Number);
       assertEquals(actualResult,correctExpectedResult);
   }
}
