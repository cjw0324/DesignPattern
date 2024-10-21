package arthropod.manager;

import arthropod.builder.Arthropod;
import arthropod.factory.ArthropodType;
import arthropod.factory.MetamorphosisType;
import arthropod.factory.RespirationType;

import java.util.List;

public class ArthropodClassification {
    private List<ArthropodClassifier> classifiers;


    // 생성자 - 분류 기준을 포함한 ArthropodClassifier 리스트를 받음
    public ArthropodClassification(List<ArthropodClassifier> classifiers) {
        this.classifiers = classifiers;
    }

    // Arthropod 객체의 특징에 따라 ArthropodType을 분류하여 반환
    public ArthropodType classify(Arthropod arthropod) {

        System.out.println("분류를 위해 받은 Arthropod 출력 시작");
        System.out.println(arthropod);
        System.out.println("분류를 위해 받은 Arthropod 출력 종료");
        for (ArthropodClassifier classifier : classifiers) {
            if (classifier.matches(arthropod.getBodyRegions(), arthropod.getPairsOfAntennae(), arthropod.getRespiration(), arthropod.getMetamorphosis(), arthropod.getPairsOfWing(),
                    arthropod.getNumberOfLegs())) {
                return classifier.getArthropodType();  // 일치하는 타입 반환
            }
        }
        return ArthropodType.UNKNOWN;  // 일치하는 항목이 없으면 UNKNOWN 반환
    }

    // 특징들을 기준으로 ArthropodType을 분류 (직접 전달된 특징들을 기준으로 분류)
    public ArthropodType classify(int bodyRegions, int pairsOfAntennae, RespirationType respiration,
                                  MetamorphosisType metamorphosis, int pairsOfWing, int numberOfLegs, String distinction) {
        Arthropod arthropod = new Arthropod.ArthropodBuilder()
                .setBodyRegions(bodyRegions)
                .setPairsOfAntennae(pairsOfAntennae)
                .setRespiration(respiration)
                .setMetamorphosis(metamorphosis)
                .setPairsOfWing(pairsOfWing)
                .setNumberOfLegs(numberOfLegs)
                .setDistinction(distinction)
                .build();

        return classify(arthropod);  // 생성된 Arthropod 객체를 기반으로 분류
    }


}
