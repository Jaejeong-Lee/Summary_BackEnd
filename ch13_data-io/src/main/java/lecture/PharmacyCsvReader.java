package lecture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PharmacyCsvReader {
    public static List<Pharmacy> readCsv(String filePath) {

        // list 생성
        List<Pharmacy> pharmacies = new ArrayList<>();

        // BufferedReader 사용해서 문자열 읽기 -> 보조 스트림
        // FileReader
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null ) {

                // 첫줄 (헤더) 무시
                if(isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // csv 데이터는 콤마(,)로 구분
                // 값자체가 콤마일 수 있으므로, "" 으로 묶어준 값이면 하나로 처리시킴
                String[] field = parseCsvLine(line);
//                System.out.println("field = " + Arrays.toString(field));

                if(field.length <14 ){
                    System.out.println(" 잘못된 라인 " + line);
                    continue;
                }

                pharmacies.add(new Pharmacy(field));

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pharmacies;
    }

    private static String[] parseCsvLine(String line) {
        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();
        // 큰 따옴표 처리되어 있으면 하나로 보는 작업
        // 큰 따옴표 상태 확인용 변수 선언
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            /* 큰 따옴표 만났을 때 */
            if (c=='"') {
                inQuotes = !inQuotes; // 큰따옴표의 상태 반전
                // 처음 만나면 true되었다가 다시 만나면 false되면서 자동으로 닫힐 거니까

                /* 문자가 , 일때 && 현재 inQuotes가 true가 아닐때 */
            } else if (c == ',' && !inQuotes) {
                // current.toString : (StringBuilder)에 쌓인 문자를 문자열로 반환
                result.add(current.toString().trim());
                current.setLength(0); // 초기화

                /* 나머지 문자일 때 */
            } else {
                // append로 문자값을 추가할 수 있음
                // 쉼표도 문자열로 바꾸고 값에 포함시킴.
                current.append(c);
            }
        }
        // 마지막 필드 추가
        result.add(current.toString().trim());
        return result.toArray(String[]::new);
    }
}
