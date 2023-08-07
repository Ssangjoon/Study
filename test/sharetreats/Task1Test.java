package sharetreats;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test extends beforeTest{
    @DisplayName("input값 검증(특수 문자로 인한 실패)")
    @Test
    void testValidation1(){
        String input = "claIm ABcde 1231 2312 123@";
        assertFalse(validation(input));
    }
    @DisplayName("input값 검증(30자 이상 입력일 경우 실패)")
    @Test
    void testValidation2(){
        String input = "claIm ABcde 1231 2312 123claIm ABcde 1231 2312 123claIm ABcde 1231 2312 123";
        assertFalse(validation(input));
    }

    @DisplayName("check 명령문 실행 실패")
    @Test
    void testExcuteCheckFail(){
        String input = "check 123 312 123";
        Queue<String> orders = createOrderQueue(input);
        String command = orders.poll();

        assertFalse(testExcution(command, orders));
    }
    @DisplayName("claim 명령문 실행 실패")
    @Test
    void testExcuteClaimFail(){
        String input = "claIm ABcde 1231 2312 123";
        Queue<String> orders = createOrderQueue(input);
        String command = orders.poll();

        assertFalse(testExcution(command, orders));
    }
    @DisplayName("check 명령문 실행 성공")
    @Test
    void testExcuteCheckSuccess(){
        String input = "check "+productCodes.get(0);
        Queue<String> orders = createOrderQueue(input);
        String command = orders.poll();

        assertTrue(testExcution(command, orders));
    }
    @DisplayName("claim 명령문 실행 성공")
    @Test
    void testExcuteClaimSuccess(){
        String input = "claIm      "+storeCode+" "+productCodes.get(0);
        Queue<String> orders = createOrderQueue(input);
        String command = orders.poll();

        assertTrue(testExcution(command, orders));
    }
    @DisplayName("claim 명령문 실행 성공")
    @Test
    void testExcuteHelmpSuccess(){
        String input = "help";
        Queue<String> orders = createOrderQueue(input);
        String command = orders.poll();

        assertTrue(testExcution(command, orders));
    }

    boolean validation(String input){
        if(input.length() > MAX_INPUT_LENGTH){
            System.out.println(MAX_INPUT_LENGTH + "자 미만으로 입력하세요.");
            return false;
        }

        if (!input.matches("[0-9a-zA-Z\\s]+")) {
            System.out.println("유효한 입력이 아닙니다.");
            return false;
        }
        return true;
    }

    private static Queue<String> createOrderQueue(String input) {
        input = input.replaceAll("\\s+", " "); // 공백이 여러개일 경우 하나로 치환
        Queue<String> orders = new ArrayDeque<>();

        if (input.contains(" ")) {
            orders = Stream.of(input.split(" "))
                    .collect(Collectors.toCollection(() -> new ArrayDeque<>()));
        } else {
            orders.offer(input);
        }

        return orders;
    }

    boolean testExcution(String command, Queue<String> orders){
        StringBuilder inputProductCodeBuilder = new StringBuilder();
        switch (command.toUpperCase()) {
            case "CHECK":
                System.out.println("CHECK 실행");

                for (int i = 0; i < orders.size();) {
                    inputProductCodeBuilder.append(orders.poll()); // 상품코드
                }

                if(productCodes.contains(inputProductCodeBuilder.toString())){
                    System.out.println("========교환 가능합니다.========");
                    return true;
                }else {
                    System.out.println("========교환 불가능한 상품코드 입니다.========");
                    return false;
                }

            case "HELP":
                System.out.println("===================================");
                System.out.println("교환 코드를 입력하세요. 예시 : ");
                System.out.println("Check 132 421 122");
                System.out.println("HELP");
                System.out.println("claIm ABcde 1231 2312 123");
                System.out.println("===================================");
                return true;

            case "CLAIM":
                System.out.println("CLAIM 실행");

                // 상품 교환 할때 어떤 상점에서 교환하였는지 상점코드 알아야함
                String inputStoreCode = orders.poll(); // 상점 코드 추출
                for (int i = 0; i < orders.size();) {
                    inputProductCodeBuilder.append(orders.poll()); // 상품코드
                }

                if (!storeCode.equals(inputStoreCode)){
                    System.out.println("상점 코드가 일치하지 않습니다.");
                    return false;
                } else if (productCodes.contains(inputProductCodeBuilder.toString())){
                    System.out.println("========교환 가능합니다.========");
                    if(productCodes.remove(inputProductCodeBuilder.toString())){
                        System.out.println("교환 완료.");
                        return true;
                    }
                } else {
                    System.out.println("========교환 불가능한 상품코드 입니다.========");
                    System.out.println("교환 실패");
                    return false;
                }

                break;

            default:
                System.out.println("지원되지 않는 명령문입니다.");
                return false;
        }
        return false;
    }

}