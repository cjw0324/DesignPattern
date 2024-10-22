// 2024-10-22 1분반 최재우 32184682

package arthropod.manager;

import arthropod.builder.Arthropod;
import arthropod.factory.ArthropodType;
import arthropod.factory.MetamorphosisType;
import arthropod.factory.RespirationType;

// ArthropodClassifier는 Arthropod 객체의 특징을 기반으로 ArthropodType을 분류
public class ArthropodClassifier {
    private ArthropodType arthropodType;  // 분류할 Arthropod의 타입 저장
    private Arthropod arthropod;  // Arthropod 객체

    // 생성자 - Arthropod와 ArthropodType을 함께 초기화
    public ArthropodClassifier(ArthropodType arthropodType, Arthropod arthropod) {
        this.arthropodType = arthropodType;
        this.arthropod = arthropod;
    }

    // 두 Arthropod 객체가 같은 특징을 가지는지 비교하여 일치하는지 확인
    public boolean matches(Arthropod otherArthropod) {
        return arthropod.getBodyRegions() == otherArthropod.getBodyRegions()
                && arthropod.getPairsOfAntennae() == otherArthropod.getPairsOfAntennae()
                && arthropod.getRespiration() == otherArthropod.getRespiration()
                && arthropod.getMetamorphosis() == otherArthropod.getMetamorphosis()
                && arthropod.getPairsOfWing() == otherArthropod.getPairsOfWing()
                && arthropod.getNumberOfLegs() == otherArthropod.getNumberOfLegs();
    }

    // 주어진 특징들이 Arthropod의 특징들과 일치하는지 비교
    public boolean matches(int bodyRegions, int antennae, RespirationType respiration, MetamorphosisType metamorphosis, int wings, int legs) {
        return arthropod.getBodyRegions() == bodyRegions &&
                arthropod.getPairsOfAntennae() == antennae &&
                arthropod.getRespiration() == respiration &&
                arthropod.getMetamorphosis() == metamorphosis &&
                arthropod.getPairsOfWing() == wings &&
                arthropod.getNumberOfLegs() == legs;
    }

    // Arthropod의 타입을 반환
    public ArthropodType getArthropodType() {
        return arthropodType;
    }

    // Arthropod 객체를 반환
    public Arthropod getArthropod() {
        return arthropod;
    }

    // 객체 정보를 문자열로 변환
    @Override
    public String toString() {
        return "ArthropodClassifier [arthropodType=" + arthropodType + ", arthropod=" + arthropod + "]";
    }
}
