import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
 
	public static void main(String[] args) throws IOException{
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26]; // 영문자의 개수는 26개임
		String s = br.readLine();
        
        // 대문자 범위(십진수) : 65~90
        // 소문자 범위(십진수) : 97~122
        // 아래와 같이 직접 문자를 넣어도 됨
		for (int i = 0; i < s.length(); i++) {
			if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
				arr[s.charAt(i) - 97]++;
			} else {
				arr[s.charAt(i) - 65]++;
			}
		}
		int max = -1;
		char ch = '?';
		for (int i = 0; i < 26; i++) {
 
			if (arr[i] > max) {
				max = arr[i];
				ch = (char) (i + 65);
			} 
			else if (arr[i] == max) {
				ch = '?';
			}
		}
		System.out.print(ch);
	}
 
}