 package string;



public class Quiz3 {
	public static void main(String[] args) {
/*
	16자리의 카드번호를 문자열로 입력받아서
	카드번호의 오른쪽끝에서 부터 세어서
	홀수번째는 그대로 두고
	짝수번째는 2를 곱한다
	만약 2를 곱한 숫자가 두자리수이면
	각 자리수를 더해서 한자리 수로 만든다
	이렇게 만들어진 16개의 한자리숫자를 모두 더하여
	그 합이 10으로 나누어 떨어지면 유효한 카드번호
	그렇지 않으면 유효하지 않은 카드번호이다
	(Luhn 알고리즘)
	
	카드번호를 입력받아서 유효성을 검증하는 코드를 작성하세요
	
	(String, char, int, /, %, +)
 */

		String input = "1162-3434-1010-2111";	// 유효
		input = input.replace("-", "");
		int intCh = 0;
		String strCh = "";
		int sum = 0;
		
		for(int i= 0;i < input.length();i++) {
			char ch = input.charAt(i);
			
			if(i % 2 == 0) {
				intCh = (int)((ch-48)*2);
				if(intCh > 10) {
					int n1 = intCh /10;
					int n2 = intCh % 10;
					intCh = n1 + n2;
					strCh += Integer.toString(intCh);
				}else {strCh += Integer.toString(intCh);
				}
				
			}else {
				strCh += ch;
			}
		}
		for(int i = 0; i < strCh.length();i++) {
			char ch = strCh.charAt(i);
			sum += (int)((ch-48));
		}
		if(sum % 10 == 0) System.out.println("유효한 카드입니다.");
		else	System.out.println("유효하지 않은 카드입니다.");
		
		
	
	
	
	
	}
		
}
		
//		홀수는 그대로 짝수는 2배
//		21[12]2-6464-2020-4121
//		2132-6464-2020-4121
		
			// 유효하지 않음
//		홀수는 그대로 짝수는 2배
//		21[12]2-6464-2020-4121

//		2배한 값이 두자리수이면 각 자릿수를 더함
//		2132-6464-2020-4121
		
//		모든 수의 합을 구하여 10으로 나누어떨어지는지 확인
		
