package packageName;
import java.util.Arrays;
public class test{
	public void main(String[] args){
		//Tries to get an input from the user, using getInput method in CurrencyConverter class.
		System.out.println(CurrencyConverter.getInput());
		
		//Tries to seperate different inputted strings.
		inputSeparationTest();

		//Tries to get the size of the array containing the elements of the input.
		checkInputSizeTest();

		//Tries to convert the inputted amount from string to double.
		if (convertStringToDoubleTest())
			System.out.println("Convertion to Double is correct");
		else
			System.out.println("Convertion to Double is NOT correct");

		//Tries to get the course for the inputted currency.
		System.out.println(CurrencyConverter.getData("USD"));
		

	}
	public void inputSeparationTest(){
		String str = "USD 12 JPY";
		String[] seperatedstr = CurrencyConverter.inputSeparation(str);

		System.out.println(seperatedstr[0]);
		System.out.println(seperatedstr[1]);
		System.out.println(seperatedstr[2]);
	}

	public void checkInputSizeTest(){
		String[] arr1 = new String[2];
		String[] arr2 = new String[3];
		arr1[0] = "USD";
		arr1[1] = "12";
		arr2[0] = "USD";
		arr2[1] = "12";
		arr2[2] = "JPY";
 		System.out.println("The inputted array has "+CurrencyConverter.checkInputSize(arr1) + " elements.");
		System.out.println("The inputted array has "+CurrencyConverter.checkInputSize(arr2)+" elements.");
	}

	public boolean convertStringToDoubleTest(){
		Double dbl1 = CurrencyConverter.convertStringToDouble("12");
		Double dbl2 = CurrencyConverter.convertStringToDouble("12.5");
		try {
			Double mult = dbl1*dbl2;
			return true;
		}
		catch(Exception e){
			return false;}

	//public boolean getDataTest(){
	//	String course1 = CurrencyConverter.getData("USD 12");
	//	String course2 = CurrencyConverter.getData("USD 12 JPY");
		}
}