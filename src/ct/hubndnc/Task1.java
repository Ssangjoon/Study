package ct.hubndnc;


import java.util.*;

public class Task1 {
    // a는1, b는3, c는5로 찍었다.
    static final int A = 1;
    static final int B = 3;
    static final int C = 5;
    public static void main(String[] args) {
        // 배열을 생성합니다..
        List<AnswerSheet> sheets = new ArrayList<>();
        sheets.add(new AnswerSheet(1,5));
        sheets.add(new AnswerSheet(3,3));
        sheets.add(new AnswerSheet(2,4));

        // 입력받은 배열에 맞게 점수를 출력합니다.
        Map<Character, Integer> resultScore =  calScore(sheets);
        System.out.println(resultScore);

        // 가장 큰 수를 찾습니다.
        int maxScore = Collections.max(resultScore.values());

        StringBuilder output = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : resultScore.entrySet()) {
            if (entry.getValue() == maxScore) {
                if (output.length() > 0) {
                    output.append(", ");
                }
                output.append(entry.getKey()).append(":").append(entry.getValue());
            }
        }
        System.out.println(output);
    }

    private static Map<Character, Integer> calScore(List<AnswerSheet> sheets){

        Map<Character, Integer> result = new HashMap<>();

        for (AnswerSheet sheet :sheets){
            //
            switch (sheet.getAnswer()){
                case A: result.put('a',result.getOrDefault('a',0) + sheet.score);
                break;
                case B: result.put('b',result.getOrDefault('b',0) + sheet.score);
                break;
                case C: result.put('c',result.getOrDefault('c',0) + sheet.score);
                break;
            }
        }
        return result;
    }

    private static class AnswerSheet{
        int answer;
        int score;

        public AnswerSheet(int answer, int score) {
            this.answer = answer;
            this.score = score;
        }

        public int getAnswer() {
            return answer;
        }

    }

}
