// 2024-10-22 1분반 최재우 32184682

package arthropod.builder;

import arthropod.factory.MetamorphosisType;
import arthropod.factory.RespirationType;

public class Arthropod {
    private int bodyRegions;  // 곤충의 몸 부위 수
    private int pairsOfAntennae;  // 곤충의 더듬이 쌍 수
    private RespirationType respiration;  // 곤충의 호흡 방식
    private MetamorphosisType metamorphosis;  // 곤충의 변태 방식
    private int pairsOfWing;  // 곤충의 날개 쌍 수
    private int numberOfLegs;  // 곤충의 다리 수

    // Optional
    private String distinction;  // 곤충의 특징 설명

    // Arthropod 생성자, 각 필드를 초기화
    public Arthropod(int bodyRegions, int pairsOfAntennae, RespirationType respiration, MetamorphosisType metamorphosis, int pairsOfWing, int numberOfLegs, String distinction) {
        this.bodyRegions = bodyRegions;
        this.pairsOfAntennae = pairsOfAntennae;
        this.respiration = respiration;
        this.metamorphosis = metamorphosis;
        this.pairsOfWing = pairsOfWing;
        this.numberOfLegs = numberOfLegs;
        this.distinction = distinction;
    }

    // Builder 패턴을 사용한 생성자
    private Arthropod(ArthropodBuilder builder) {
        this.bodyRegions = builder.bodyRegions;
        this.pairsOfAntennae = builder.pairsOfAntennae;
        this.respiration = builder.respiration;
        this.metamorphosis = builder.metamorphosis;
        this.pairsOfWing = builder.pairsOfWing;
        this.numberOfLegs = builder.numberOfLegs;
        this.distinction = builder.distinction;
    }

    // Getter 메서드들 (각 필드 값 반환)
    public int getBodyRegions() {
        return bodyRegions;
    }

    public int getPairsOfAntennae() {
        return pairsOfAntennae;
    }

    public RespirationType getRespiration() {
        return respiration;
    }

    public MetamorphosisType getMetamorphosis() {
        return metamorphosis;
    }

    public int getPairsOfWing() {
        return pairsOfWing;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public String getDistinction() {
        return distinction;
    }

    // Arthropod 객체를 문자열로 표현 (각 필드 값 출력)
    @Override
    public String toString() {
        return "Arthropod: " +
                "\nBody Regions: " + (bodyRegions >= 0 ? bodyRegions : "Unknown") +
                "\nAntennae: " + (pairsOfAntennae >= 0 ? pairsOfAntennae : "Unknown") +
                "\nRespiration: " + (respiration != null ? respiration : "Unknown") +
                "\nMetamorphosis: " + (metamorphosis != null ? metamorphosis : "Unknown") +
                "\nWings: " + (pairsOfWing >= 0 ? pairsOfWing : "Unknown") +
                "\nLegs: " + (numberOfLegs >= 0 ? numberOfLegs : "Unknown") +
                "\nDistinction: " + (distinction != null ? distinction : "Unknown");
    }

    // Builder 클래스
    public static class ArthropodBuilder{
        private int bodyRegions;  // 곤충의 몸 부위 수
        private int pairsOfAntennae;  // 곤충의 더듬이 쌍 수
        private RespirationType respiration;  // 곤충의 호흡 방식
        private MetamorphosisType metamorphosis;  // 곤충의 변태 방식
        private int pairsOfWing;  // 곤충의 날개 쌍 수
        private int numberOfLegs;  // 곤충의 다리 수
        private String distinction;  // 곤충의 특징 설명

        // 생성자 초기화
        public ArthropodBuilder() {

        }

        // Builder 메서드들 (각 필드를 설정하고 자기 자신 반환)
        public ArthropodBuilder setBodyRegions(int bodyRegions) {
            this.bodyRegions = bodyRegions;
            return this;
        }

        public ArthropodBuilder setPairsOfAntennae(int pairsOfAntennae) {
            this.pairsOfAntennae = pairsOfAntennae;
            return this;
        }

        public ArthropodBuilder setRespiration(RespirationType respiration) {
            this.respiration = respiration;
            return this;
        }

        public ArthropodBuilder setMetamorphosis(MetamorphosisType metamorphosis) {
            this.metamorphosis = metamorphosis;
            return this;
        }

        public ArthropodBuilder setPairsOfWing(int pairsOfWing) {
            this.pairsOfWing = pairsOfWing;
            return this;
        }

        public ArthropodBuilder setNumberOfLegs(int numberOfLegs) {
            this.numberOfLegs = numberOfLegs;
            return this;
        }

        public ArthropodBuilder setDistinction(String distinction) {
            this.distinction = distinction;
            return this;
        }

        // Arthropod 객체 생성 (Builder 패턴의 핵심)
        public Arthropod build() {
            return new Arthropod(this);
        }
    }
}
