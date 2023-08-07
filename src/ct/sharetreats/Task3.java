package ct.sharetreats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {
//    회사내의 각 부서의 직원수를 파악해주는 서비스.
        // 입력 받기
        Scanner scanner = new Scanner(System.in);

        Map<String, String> departmentMap = new HashMap<>();
        List<Map<String, String>> departmentList = new ArrayList<>();

        // 여러 줄 입력 받기
        System.out.println("부서인원정보를 작성해주세요");
        printInputInstructions(); // 안내 메시지

        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("done")) {
            String[] inputParts = line.split(",");

            String department = inputParts[0].trim().toUpperCase();
            String departmentSize = inputParts[1].trim();
            if (inputParts.length == 2 && !department.isEmpty() && !departmentSize.isEmpty()) {
                if(!department.matches("[A-Z\\s]+")){
                    System.out.println("부서명은 영문자로 기입해주세요.");
                    continue;
                } else if (!departmentSize.matches("[0-9\\s]+")) {
                    System.out.println("부서인원은 숫자로만 기입해주세요");
                    continue;
                } else if(Integer.parseInt(departmentSize) < 0 || Integer.parseInt(departmentSize) > 1000){
                    System.out.println("부서인원은 1명 부터 1000명사이 입니다.");
                    continue;
                }
                departmentMap.put(department, departmentSize);
            } else {
                System.out.println("부서인원정보를 형식에 맞게 입력하여 주세요");
                printInputInstructions();
            }
            departmentList.add(new HashMap<>(departmentMap)); // departmentMap 복사하여 departmentList에 추가
        }

        System.out.println("부서명과 인원수:");
        for (Map<String, String> department : departmentList) {
            for (Map.Entry<String, String> entry : department.entrySet()) {
                String dept = entry.getKey();
                String size = entry.getValue();
                System.out.println("부서명: " + dept + " ,인원수: " + size);
            }
        }
        if(departmentList.isEmpty()){
            System.out.println("회사내의 각 부서는 1개 이상입니다.");
        }

        printInputRelationInstructions();
        line = scanner.nextLine();


//    인원수는 최소 0명에서 1000명.
//    1개의 하위 부서는 1개의 상위 부서만
//    부서간의 관계는 ">" 로 표시.
//    예를 들어 * >A > B 는 A 가 상위 부서, B 는 A의 하위 부서입니다.

        // 출력 표현하기
//    최 상위 부서(다른 부서에 포함되지 않는 부서)별로 해당 부서와 하위부서 내의 모든 직원수를 합한 수를 제공.
//    출력은 다음과 같이 표현합니다.
//    [최상위 부서명],[총 인원]
//    예시)
//    AS, 1000
//
//    3. "비지니스 팀 요구사항"에 충족되는지 확인하는 테스트 케이스가 필요합니다.
//    각 케이스 별 고객의 입력과 개발자가 예상하는 결과를 이용하여 모든 테스트를 통과해야 합니다.
    }
    private static void printInputInstructions(){
        System.out.println("[부서명],[인원]");
        System.out.println("예시)");
        System.out.println("DEV, 0");
        System.out.println("AS, 10");
        System.out.println("QA, 990");
        System.out.println("입력을 마치려면 'done'을 입력하세요.");
    }
    private static void printInputRelationInstructions(){
        System.out.println("부서 구성도를 작성해주세요");
        System.out.println("[부서명]>[부서명]");
        System.out.println("예시)");
        System.out.println("* > AS");
        System.out.println("AS > DEV");
        System.out.println("AS > QA");
    }

}
