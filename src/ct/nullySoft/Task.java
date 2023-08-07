package ct.nullySoft;

public class Task {
    public static void main(String[] args) {
        // 시분초를 나타내는 문자열?과 초를 나타내는 정수형 을 인자로 받는 메서드,
        // 둘을 더한 결과를 뱉는 메서드를 구현하라
        // execute('190730', 700) -> 231910

        // 10000000 -> 10,000,000 로 반환하는 메서드 구현하라
        System.out.println(execute2(10000000));
    }
    public static String execute(String timeString, int secondsToAdd) {
        int hours = Integer.parseInt(timeString.substring(0, 2));
        int minutes = Integer.parseInt(timeString.substring(2, 4));
        int seconds = Integer.parseInt(timeString.substring(4, 6));

        // 시간, 분, 초를 초 단위로 변환
        int totalSeconds = hours * 3600 + minutes * 60 + seconds;

        // 주어진 초를 더함
        totalSeconds += secondsToAdd;

        // 초를 시간, 분, 초 형식으로 변환
        hours = totalSeconds / 3600;
        minutes = (totalSeconds % 3600) / 60;
        seconds = (totalSeconds % 3600) % 60;

        // 시간, 분, 초를 문자열 형식으로 조합
        String result = String.format("%02d%02d%02d", hours, minutes, seconds);

        return result;
    }
    private static String execute2(int num){
        String numberString = String.valueOf(num);
        int length = numberString.length();

        if(length <=3){
            return numberString;
        }

        StringBuilder formattedNumber = new StringBuilder();
        int commaCount = (length - 1) /3;

        for (int i = 0; i < length; i++) {
            formattedNumber.append(numberString.charAt(i));

            if((length - i - 1) % 3 == 0 && commaCount >0){
                formattedNumber.append(",");
                commaCount--;
            }
        }

        return formattedNumber.toString();
    }

}
