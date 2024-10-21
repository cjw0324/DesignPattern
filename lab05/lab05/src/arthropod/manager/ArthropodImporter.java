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

public class ArthropodImporter {

    private static ArthropodFactory factory;

    public ArthropodImporter() {
        this.factory = new ArthropodFactory();
    }

    public static List<ArthropodClassifier> loadCSV(String filename) {
        List<ArthropodClassifier> classifiers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            // 첫 번째 줄은 CSV 헤더이므로 건너뜀
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // 각 필드를 읽고 적절한 형식으로 변환 (숫자와 문자열, enum 등)
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

                // ArthropodClassifier에 Arthropod 및 ArthropodType을 연동
                ArthropodType arthropodType = ArthropodType.valueOf(type.toUpperCase());
                ArthropodClassifier classifier = new ArthropodClassifier(arthropodType, arthropod);

                classifiers.add(classifier);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return classifiers;
    }

    // 문자열을 정수로 변환하는 헬퍼 메서드 (Unknown일 경우 -1 반환)
    private static int parseInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1; // Unknown 처리
        }
    }

    // RespirationType 변환 헬퍼 메서드
    private static RespirationType parseRespiration(String value) {
        try {
            return RespirationType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // Unknown 처리
        }
    }

    // MetamorphosisType 변환 헬퍼 메서드
    private static MetamorphosisType parseMetamorphosis(String value) {
        try {
            return MetamorphosisType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // Unknown 처리
        }
    }
}
