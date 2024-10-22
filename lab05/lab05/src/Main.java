// 2024-10-22 1분반 최재우 32184682

import arthropod.builder.Arthropod;
import arthropod.factory.ArthropodFactory;
import arthropod.factory.ArthropodType;
import arthropod.factory.MetamorphosisType;
import arthropod.factory.RespirationType;
import arthropod.manager.ArthropodClassification;
import arthropod.manager.ArthropodClassifier;
import arthropod.manager.ArthropodImporter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        // CSV 파일에서 Arthropod 데이터를 불러옴
        List<ArthropodClassifier> classifiers = ArthropodImporter.loadCSV("arthropods.csv");

        // 모든 Arthropod 데이터 출력
        System.out.println("\n\n\n 모든 Arthropod 출력 시작\n\n\n");

        for (ArthropodClassifier classifier : classifiers) {
            System.out.println(classifier);
        }

        System.out.println("\n\n\n 모든 Arthropod 출력 종료\n\n\n");

        // Beetle 테스트 - Builder로 객체 생성 및 분류
        System.out.println("\n\n\n Beetle test 출력 시작\n\n\n");

        System.out.println("\n Builder 로 생성하고 classify 하기 \n");

        ArthropodClassification classification = new ArthropodClassification(classifiers);
        Arthropod beetle = new Arthropod.ArthropodBuilder()
                .setBodyRegions(3)
                .setPairsOfAntennae(1)
                .setRespiration(RespirationType.TRACHEAL)
                .setMetamorphosis(MetamorphosisType.COMPLETE)
                .setPairsOfWing(2)
                .setNumberOfLegs(6)
                .setDistinction("hard exoskeleton and elytra (wing covers)")
                .build();

        System.out.println(beetle);
        System.out.println(" => Arthropod Type : " + classification.classify(beetle));

        // 직접 특징을 전달하여 classify
        System.out.println("\n 생성하지 않고, classify 하기 \n");

        ArthropodType arthropodType = classification.classify(3, 1, RespirationType.TRACHEAL, MetamorphosisType.COMPLETE, 2, 6, "who am i?");
        System.out.println(" => Arthropod Type : " + arthropodType);

        System.out.println("\n\n\n Beetle test 출력 종료\n\n\n");

        // Crab 테스트 - Factory로 객체 생성 및 출력
        System.out.println("\n\n\n Crab test 출력 시작\n\n\n");

        Arthropod crab = ArthropodFactory.create(ArthropodType.CRUSTACEA);
        System.out.println(crab);

        System.out.println("\n\n\n Crab test 출력 종료\n\n\n");

        // DIPLOPODA 테스트
        System.out.println("\n\n\n DIPLOPODA test 출력 시작\n\n\n");

        Arthropod arthropodToClassify = new Arthropod.ArthropodBuilder()
                .setBodyRegions(2)
                .setPairsOfAntennae(1)
                .setRespiration(RespirationType.TRACHEAL)
                .setMetamorphosis(MetamorphosisType.NONE)
                .setPairsOfWing(0)
                .setNumberOfLegs(100)
                .setDistinction("2 pairs legs per seg")
                .build();

        Optional<ArthropodClassifier> matchingClassifier = classifiers.stream().filter(classifier -> classifier.matches(arthropodToClassify)).findFirst();
        System.out.println(matchingClassifier);

        System.out.println("\n\n\n DIPLOPODA test 출력 종료\n\n\n");

        // 모든 Arthropod 메소드 테스트
        System.out.println("\n\n\n 모든 메소드 테스트 ... \n\n\n");

        List<Arthropod> arthropods = classifiers.stream().map(classifier -> classifier.getArthropod()).collect(Collectors.toList());

        for (Arthropod arthropod : arthropods) {
            System.out.println(arthropod);
            System.out.println(" => Arthropod Type: " + classification.classify(arthropod));
        }
    }
}
