class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int count = 0;
        for(int i = a; i >= 2; i--){
            if(a % i == 0 && b % i == 0 ){
                a /= i;
                b /= i;
            }
        }
        while(b % 2 == 0){
             b = b / 2;
         }
        while(b % 5 == 0){
            b = b / 5;
        }
        if(b == 1){
            answer = 1;
        }else{
            answer = 2;
        }
        return answer;
    }
}