import java.util.ArrayList;

public class Dishes {
	private String period;
	private ArrayList<Integer> options;
	
	public Dishes() {
		this.period = null;
		this.options = new ArrayList<Integer>();
	}
	
	public void defineObj(String[] op) {
		period = op[0];
		try {
			for (int i = 1; i < op.length; i++)
				options.add(Integer.parseInt(op[i]));
			options.sort(null);
		} catch (Exception e) {
			System.out.println(validOptions());
			options.clear();
		} 
	}
	
	public String showDishes() {
		String result = "";
		int countRepeat;
		
		for (int i = 0; i < options.size(); i++) {
			if(period.equals("morning")) {
				switch(options.get(i)) {
				case 1:
					result += "eggs";
					break;
				case 2:
					result += "toast";
					break;
				case 3:
					result += "coffee";
					countRepeat = repeatTimes(i);
					if(countRepeat > 1)
						result += "(x" + countRepeat + ")";
					i += countRepeat - 1;
					break;
				default:
					System.out.println(validOptions());
					result += "error";
					break;
				}
				
			} else if(period.equals("night")) {
				switch(options.get(i)) {
				case 1:
					result += "steak";
					break;
				case 2:
					result += "potato";
					countRepeat = repeatTimes(i);
					if(countRepeat > 1)
						result += "(x" + countRepeat + ")";
					i += countRepeat - 1;
					break;
				case 3:
					result += "wine";
					break;
				case 4:
					result += "cake";
					break;
				default:
					System.out.println(validOptions());
					result += "error";
					break;
				}
			} else {
				return validOptions();
			}
			
			if(i < options.size() - 1)
				result += ", ";
		}
		
		return result;
	}
	
	private Integer repeatTimes(Integer i) {
		Integer j = 1;
		
		while(i + j < options.size() && options.get(i) == options.get(i + j))
			j++;
		
		return j;
	}
	
	public boolean removeRepeated() {
		if(period.equals("morning")) {
			for (int i = 0; i < options.size() - 1; i++) {
				if(options.get(i) < 1 || options.get(i) > 3)
					return false;
				
				if(options.get(i) != 3)
					while(i + 1 < options.size() && options.get(i) == options.get(i + 1))
						options.remove(i + 1);
			}
			return true;
		} else if (period.equals("night")) {
			for (int i = 0; i < options.size() - 1; i++) {
				if(options.get(i) < 1 || options.get(i) > 4)
					return false;
				
				if(options.get(i) != 2) 
					while(i + 1 < options.size() && options.get(i) == options.get(i + 1))
						options.remove(i + 1);
			}
			return true;
		} else {
			return false;
		}
	}

	public String validOptions() {
		String str;
		
		str = "Valid options:\n";
		str += "morning: entrée(1) - eggs;  side(2) - Toast;  drink(3) - coffee; dessert(4) - none\n";
		str += "  night: entrée(1) - steak; side(2) - potato; drink(3) - wine;   dessert(4) - cake";
		
		return str;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}
	
	
}