package ct.acrofuture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class T1 {
    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("1622025203 REQUEST 10003 192.168.0.1");
        logs.add("1622025205 REQUEST 10003 192.168.0.1");
        logs.add("1622025209 REQUEST 10003 192.168.0.1");
        logs.add("1622025211 RESPONSE 10003");
        logs.add("1622025212 RESPONSE 10003");
        logs.add("1622025215 RESPONSE 10003");

        Map<String, Integer> requestCounts = new HashMap<>();
        Map<String, Long> requestMap = new HashMap<>();
        Map<String, Long> responseMap = new HashMap<>();
        List<Map<String, Long>> requestTimes = new ArrayList<>();
        List<Map<String, Long>> responseTimes = new ArrayList<>();

        for (String log : logs) {
            String[] parts = log.split(" ");

            long timestamp = Long.parseLong(parts[0]);
            String logType = parts[1];
            String id = parts[2];

            if (logType.equals("REQUEST")) {
                String ip = parts[3];
                requestCounts.put(ip, requestCounts.getOrDefault(ip, 0) + 1);
                requestMap.put(id, timestamp);
                requestTimes.add(requestMap);
            } else if(logType.equals("RESPONSE")) {
                if (requestMap.containsKey(id)) {
                    long requestTime = requestMap.get(id);
                    long responseTime = timestamp - requestTime;
                    responseMap.put(id, responseTime);
                    responseTimes.add(responseMap);
                } else {
                    responseMap.put(id, -1L); // 실패로 표시
                    responseTimes.add(responseMap);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : requestCounts.entrySet()) {
            String ip = entry.getKey();
            int requestCount = entry.getValue();
            System.out.println(ip + " (" + requestCount + ")");
        }
        for (Map<String, Long> response: responseTimes){
            for (Map.Entry<String, Long> entry : response.entrySet()) {
                String id = entry.getKey();
                long responseTime = entry.getValue();
                Map<String, Long> requestTime = null;
                // 요청 시간 조회
                for (Map<String, Long> request: requestTimes){
                    if (request.containsKey(id)) {
                        requestTime = request;
                    }
                }

                if (responseTime != -1L) {
                    System.out.println(id + " " + requestTime.get(id) + " " + responseTime);
                } else {
                    System.out.println(id + " " + requestTime.get(id) + "FAIL");
                }
            }
        }

    }

}
