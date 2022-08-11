public class Main {
  public static void main(String[] args) {
    //test Decimal to Binary
    System.out.println("======== Decimal to Binary ========");
    System.out.println(Conversion.decimalToBinary(44));
    System.out.println(Conversion.decimalToBinary(128));
    System.out.println(Conversion.decimalToBinary(13075));

    //convert binary to decimals
    System.out.println("");
    System.out.println("======== Binary to Decimal ========");
    tryConvertToDecimal("1010");
    tryConvertToDecimal("111");
    tryConvertToDecimal("00011");
    tryConvertToDecimal("00 111"); // note: this should throw a BinaryFormatException

  }

  //helper method that prints binary output and handles exceptions by printing to stderr
  private static void tryConvertToDecimal(String binary){
    try{
      int outputString = Conversion.binaryToDecimal(binary);
      System.out.println(outputString);
    }catch (BinaryFormatException be){
      System.err.println("BinaryFormatException caught {"+be.getMessage()+"}");
    }
  }




}
