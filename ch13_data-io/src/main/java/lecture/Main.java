package lecture;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Pharmacy> pharmacies = PharmacyCsvReader.readCsv("약국목록.csv");

        // 데이터 출력 (확인용)
//        for (Pharmacy p : pharmacies) {
//            System.out.println(p);
//        }

        // 요양기관명,종별코드,종별코드명,시도코드,시도코드명,시군구코드,시군구코드명,읍면동,우편번호,주소,전화번호,개설일자,좌표(X),좌표(Y)

        // 경기에 위치한 약국 걸러내기
        // 전화번호 필드가 빈 약국만 걸러내기
        // 개설날짜가 2025년도인 약국만 조회하기
        List<Pharmacy> filteredPharmacy = pharmacies.stream()
                .filter(pharm -> pharm.getCityCode().equals("310000"))
                .filter(p -> p.getPhone().isBlank())
                .filter(p -> p.getOpenDate() != null && p.getOpenDate().startsWith("2025"))
                .toList();

        System.out.println("filteredPharmacy 개수 : " + filteredPharmacy.toArray().length);

    }
}
