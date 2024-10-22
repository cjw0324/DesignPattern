// 2024-10-22 1분반 최재우 32184682

package arthropod.manager;

import arthropod.builder.Arthropod;
import arthropod.factory.ArthropodFactory;
import arthropod.factory.ArthropodType;
import arthropod.factory.MetamorphosisType;
import arthropod.factory.RespirationType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// ArthropodImporter는 CSV 파일에서 데이터를 읽어와 Arthropod 객체를 생성하고 이를 ArthropodClassifier로 관리하는 클래스
public class ArthropodImporter {

    private static ArthropodFactory factory;

    // 생성자에서 ArthropodFactory 초기화
    public ArthropodImporter() {
        this.factory = new ArthropodFactory();
    }

    // CSV 파일을 읽어 ArthropodClassifier 리스트로 변환
    public static List<ArthropodClassifier> loadCSV(String filename) {
        List<ArthropodClassifier> classifiers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            // 첫 번째 줄은 CSV 헤더이므로 건너뜀
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // CSV 필드를 Arthropod 객체의 속성으로 변환
                String type = fields[0];
                int bodyRegions = parseInteger(fields[1]);
                int antennae = parseInteger(fields[2]);
                RespirationType respiration = parseRespiration(fields[3]);
                MetamorphosisType metamorphosis = parseMetamorphosis(fields[4]);
                int wings = parseInteger(fields[5]);
                int legs = parseInteger(fields[6]);
                String distinction = fields.length > 7 ? fields[7] : "Unknown";

                // Arthropod 객체 생성
                Arthropod arthropod = factory.create(bodyRegions, antennae, respiration, metamorphosis, wings, legs, distinction);

                // ArthropodClassifier에 Arthropod 및 ArthropodType 설정
                ArthropodType arthropodType = ArthropodType.valueOf(type.toUpperCase());
                ArthropodClassifier classifier = new ArthropodClassifier(arthropodType, arthropod);

                // ArthropodClassifier 리스트에 추가
                classifiers.add(classifier);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return classifiers;
    }

    // 문자열을 정수로 변환하는 헬퍼 메서드 (Unknown 값은 -1 반환)
    private static int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1; // Unknown 처리
        }
    }

    // 문자열을 RespirationType 열거형으로 변환하는 헬퍼 메서드
    private static RespirationType parseRespiration(String value) {
        try {
            return RespirationType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // Unknown 처리
        }
    }

    // 문자열을 MetamorphosisType 열거형으로 변환하는 헬퍼 메서드
    private static MetamorphosisType parseMetamorphosis(String value) {
        try {
            return MetamorphosisType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // Unknown 처리
        }
    }
}
