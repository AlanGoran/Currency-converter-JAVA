import java.util.*;
import java.io.*;
import java.io.IOException;

public class CurrencyConverter {
	
	public static void main(String[] args){
		System.out.println("Welcome to the currency converter!");
		while(true){
			String[] splittedinput = inputSeparation(getInput());
			Integer size = checkInputSize(splittedinput);
			if (size == 2)
				sekConverter(splittedinput);
			else if (size == 3)
				otherConverter(splittedinput);
			else
				System.out.println("Wrong input. Input should be in format: currency amount [currency]");
		}
	}
	
	public static String getInput(){
		Scanner tgb = new Scanner(System.in);
		System.out.print("Enter your conversion: ");
		String input = tgb.nextLine();
		String upperInput = input.toUpperCase();
		return upperInput;
	}

	public static String[] inputSeparation(String input){
		String[] splittedinput = input.split(" ");
		return splittedinput;
	}

	public static  Integer checkInputSize(String[] splittedinput){
		Integer size = splittedinput.length;
		return size;
	}

	public static Double convertStringToDouble(String value){
		Double amount = Double.parseDouble(value);
		return amount;
	}

	public static String getData(String curr){
		try{
			Scanner file = new Scanner(new File("valutor.txt"));
			String line = null;
			while(file.hasNextLine()){
				line = file.nextLine();
				String[] splittedline = inputSeparation(line);
				if(curr.equals(splittedline[0]))
					return splittedline[1];
			}

		}
		catch(Exception e){
			e.printStackTrace();
		} 
		return null;	
	}
	
	public static Integer sekConverter(String[] splittedinput){
		Double amount1 = convertStringToDouble(splittedinput[1]);
		String currencyvalue = getData(splittedinput[0]);
		if (currencyvalue == null){
			System.out.println("The currency "+splittedinput[0]+" isn't available!");
		}
		else{
			Double amount2 = convertStringToDouble(currencyvalue);
			Double answer = amount1*amount2;
			System.out.println(splittedinput[1]+" "+splittedinput[0]+" = "+answer+" SEK");
		}
		return null;
	}

	public static Integer otherConverter(String[] splittedinput){
		Double amount = convertStringToDouble(splittedinput[1]);
		String currencyvalue1 = getData(splittedinput[0]);
		String currencyvalue2 = getData(splittedinput[2]);
		if (currencyvalue1 == null)
			System.out.println("The currency "+splittedinput[0]+" isn't available!");
		else if (currencyvalue2 == null)
			System.out.println("The currency "+splittedinput[2]+" isn't available!");
		else{
			Double amount1 = convertStringToDouble(currencyvalue1);
			Double amount2 = convertStringToDouble(currencyvalue2);
			Double answer = amount1*amount/amount2;
			System.out.println(splittedinput[1]+" "+splittedinput[0]+" = "+answer+" "+splittedinput[2]);
		}
	return null;

	}
}