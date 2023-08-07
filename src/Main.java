import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Calendar date1 = Calendar.getInstance();
        System.out.println("date1은 "+ toString(date1) + date1.get(Calendar.DAY_OF_WEEK)+"요일이고,");
    }
    public static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+"년 "+ (date.get(Calendar.MONTH)+1) +"월 " + date.get(Calendar.DATE) + "일 ";
	}
}