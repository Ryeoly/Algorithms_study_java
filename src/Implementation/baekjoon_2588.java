package Implementation;
import java.util.*;
public class baekjoon_2588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		char[] a = sc.next().toCharArray();
		
		System.out.println(b*(a[2]-'0'));
		System.out.println(b*(a[1]-'0'));
		System.out.println(b*(a[0]-'0'));
		int c = Integer.parseInt(String.valueOf(a));
		System.out.println(b*c);

	}

}
