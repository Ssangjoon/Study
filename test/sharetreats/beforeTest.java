package sharetreats;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class beforeTest {
    final int CODE_LENGTH = 9;
    final int STORE_CODE_LENGTH = 6;
    final int NUMBER_OF_CODES = 20;
    final int MAX_INPUT_LENGTH = 30;
    static String storeCode;
    static List<String> productCodes = new ArrayList<>();
    static Queue<String> orders = new ArrayDeque<>();

    @BeforeAll
    protected void beforeAll(){
        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_CODES; i++) {
            String productCode = generateProductCode(random); // 상품 코드 생성
            productCodes.add(productCode);
        }
        storeCode = generateStoreCode(random); // 상점 코드 생성

    }

    protected String generateProductCode(Random random) {
        // 0~9 자연수(양의정수) 글자로 이루어진 9문자의 상품코드
        // 상품 코드는 9개의 숫자 문자열로 구성된 총 20개를 개발자가 임의로 제공.
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int code = random.nextInt(10);
            codeBuilder.append(code);
        }

        return codeBuilder.toString();
    }
    protected String generateStoreCode(Random random) {
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
}
