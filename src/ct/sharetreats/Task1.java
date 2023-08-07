package ct.sharetreats;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    private static final int CODE_LENGTH = 9;
    private static final int STORE_CODE_LENGTH = 6;
    private static final int NUMBER_OF_CODES = 20;
    private static final int MAX_INPUT_LENGTH = 30;
    private static List<String> productCodes = new ArrayList<>();
    private static String storeCode;

    public static void main(String[] args) {

        // 상품 코드, 상점 코드 생성
        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_CODES; i++) {
            String productCode = generateProductCode(random); // 상품 코드 생성
            productCodes.add(productCode);
        }
        storeCode = generateStoreCode(random); // 상점 코드 생성

        // 상품, 상점 코드 생성 -end

        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("===================================");
        System.out.println("교환 코드를 입력하세요. 예시 : ");
        System.out.println("Check 132 421 122");
        System.out.println("HELP");
        System.out.println("claIm ABcde 1231 2312 123");
        System.out.println("===================================");

        // 모든 상품코드를 교환 할때 까지 반복한다.
        while (productCodes.size() > 0){

            // 상품 코드는 10개가 준비되면 고객에게 10개까지 제공됨
            System.out.println("상품 코드 갯수 : " + productCodes.toArray().length);
            productCodes.stream().limit(10).forEach(code -> System.out.println("상품 코드 : " + code));
            System.out.println("");
            System.out.println("상점 코드 : " + storeCode);

            // 입력받기(공백이 여러개일 경우 하나로 치환)
            input = scan.nextLine().replaceAll("\\s+", " ");

            // input값 검증
            // 0~9, a~z, A~Z, SPACE 까지의 문자를 무작위로 입력 가능 (최대 30자까지)

            if(input.length() > MAX_INPUT_LENGTH){
                System.out.println(MAX_INPUT_LENGTH + "자 미만으로 입력하세요.");
                return;
            }

            if (!input.matches("[0-9a-zA-Z\\s]+")) {
                System.out.println("유효한 입력이 아닙니다.");
                return;
            }

            // input 가공하기
            Queue<String> orders = new ArrayDeque<>();
            if (input.contains(" ")){
                orders = Stream.of(input.split(" "))
                                .collect(Collectors.toCollection(() -> new ArrayDeque<>()));
            } else { // HELP일 경우 공백이 없으므로 split으로 처리하지 않는다.
                orders.offer(input);
            }

            String command = orders.poll().toString(); // queue에서 명령문만 추출
            System.out.println("명령문 : " + command);
            System.out.println("상품코드 : " +orders.toString());
            System.out.println("======> input 가공 success");

            // CHECK, HELP, CLAIM 에 따른 요청 처리와 응답
            StringBuilder inputProductCodeBuilder = new StringBuilder();
            if(!command.isEmpty() && !command.equals("")){
                excution(command,orders);
            }
        }

    }


    private static String generateProductCode(Random random) {
        // 0~9 자연수(양의정수) 글자로 이루어진 9문자의 상품코드
        // 상품 코드는 9개의 숫자 문자열로 구성된 총 20개를 개발자가 임의로 제공.
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int code = random.nextInt(10);
            codeBuilder.append(code);
        }

        return codeBuilder.toString();
    }
    private static String generateStoreCode(Random random) {
        StringBuilder storeCodeBuilder = new StringBuilder();
        // A~Z,a~z 까지의 대,소 영문자만 6문자로 이루어진 상점코드
        for (int i = 0; i < STORE_CODE_LENGTH; i++) {

            // 영문자 생성
            char randomChar = (char) (random.nextInt(26) + 'A');
            boolean isLowerCase = random.nextBoolean();

            // 무작위 대소문자 바꿈
            if (isLowerCase) {
                randomChar = Character.toLowerCase(randomChar);
            }

            storeCodeBuilder.append(randomChar);
        }

        return storeCodeBuilder.toString();
    }

    private static boolean excution(String command, Queue<String> orders){
        StringBuilder inputProductCodeBuilder = new StringBuilder();
        switch (command.toUpperCase()) {
            case "CHECK":
                // 상품 코드 사용 전에 교환 가능한지 여부를 확인 가능하며(결과 안내),
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
                    // 한번 교환 이루어진다면 해당 상품코드로 상품 교환 불가
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
