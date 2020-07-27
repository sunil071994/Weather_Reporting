package genericUtilities;

import java.util.List;

public class CommonMethods {
	
	public boolean compareWeatherObjects(List<Double> list1,List<Double> list2){
		boolean result = true;
		
		if(Math.abs(list1.get(0)-list2.get(0)) >=2){
			System.out.println("variance logic fail for temperature and temperature difference is "+Math.abs(list1.get(0)-list2.get(0)) );
			result=false;
		}
		if(Math.abs(list1.get(0)-list2.get(0)) >=10){
			System.out.println("variance logic fail for humidity and humidity difference is "+Math.abs(list1.get(1)-list2.get(1)) );
			result=false;
		}
		
		return result;
	}

		public double stringToDoubleConversion(String string){
			
			String str= string.replaceAll("[^0-9,.]", "");
			
			return Double.parseDouble(str);
			
			
		}
	
}
