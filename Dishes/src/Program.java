import java.util.Scanner;
import java.util.regex.Pattern;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] aux;
		String scan;
		
		try {
			while(true) {
				scan = sc.nextLine();
				scan = scan.replaceAll(" ", "");
				scan = scan.toLowerCase();
				aux = scan.split(Pattern.quote(","));
				Dishes d = new Dishes();
				d.defineObj(aux);
				if(d.removeRepeated()) 
					System.out.println(d.showDishes());
				else 
					System.out.println(d.validOptions());
			}
		} finally {
			sc.close();
		}
	}

}
