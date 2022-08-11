import java.util.ArrayDeque;
import java.util.Deque;

public class Conversion {

  private Conversion() {}

  /**
   * Converts a binary string to an integer
   * @param dec the binary string to convert
   * @return the double value of the string
   */
  public static String decimalToBinary(int dec) {
    //convert the decimal to binary using a stack
    Deque<Integer> stack = new ArrayDeque<>();

    //loop until decimal is 0
    while (dec > 0) {

      //push the remainder of the decimal to the stack
      stack.push(dec % 2);

      //divide the decimal by 2
      dec = dec / 2;

    }

    //create a string to hold the binary
    StringBuilder binary = new StringBuilder();
    //loop through the stack and add each digit to the string
    while (!stack.isEmpty()) {
      binary.append(stack.pop());
    }

    //check that the initial decimal is divisible by 4 if not pad start with 0
    if (binary.length() % 4 != 0) {
      binary.insert(0, "0");
    }

    //return the binary string
    return binary.toString();

  }

  /**
   * /** Converts a binary string to a decimal number.
   *
   * @param bin string to convert
   * @return Integer of the base 10 representation of the binary string.
   * @throws BinaryFormatException if input string contains invalid characters
   */
  public static int binaryToDecimal(String bin) throws BinaryFormatException {

    //check that input only contains 1,0 using Regex
    if(!bin.matches("[01]+")){
      throw new BinaryFormatException("invalid characters in binary string");
    }

    //While binary can be converted via simple int Integer.parseInt(bin, 2) doing it the long way for assessment purposes
    //converting using loop and math.pow(2, i)

    //initialize the output value as  0
    int outputDecimal = 0;
    int i = 0;

    //loop through the string digit by digit
    while(i < bin.length()){
      //add the columns value multiplied by the 1/0 to the output,
      // this means if the digit is 1 then the value is 2^i, if the digit is 0 then the value is 0
      outputDecimal += Math.pow(2, i) * Integer.parseInt(bin.substring(bin.length() - 1 - i, bin.length() - i));

      i++;
    }
    return outputDecimal;




  }

}
