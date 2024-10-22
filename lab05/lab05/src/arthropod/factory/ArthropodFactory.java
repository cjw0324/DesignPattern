// 2024-10-22 1분반 최재우 32184682

package arthropod.factory;

import arthropod.builder.Arthropod;

public class ArthropodFactory {

    // ArthropodType을 기반으로 기본 Arthropod 객체 생성
    // ArthropodType에 따라 해당 Arthropod 객체를 생성
    public static Arthropod create(ArthropodType arthropodType) {
        switch (arthropodType) {
            case ARACHNIDA:
                return new Arthropod(2, 0, RespirationType.BOOK_LUNGS, MetamorphosisType.NONE, 0, 8, "Arachnida");
            case CHILOPODA:
                return new Arthropod(2, 1, RespirationType.TRACHEAL, MetamorphosisType.NONE, 0, 30, "1 pair of legs per segment");
            case DIPLOPODA:
                return new Arthropod(2, 1, RespirationType.TRACHEAL, MetamorphosisType.NONE, 0, 100, "2 pairs of legs per segment");
            case CRUSTACEA:
                return new Arthropod(2, 2, RespirationType.GILLS, MetamorphosisType.VARIABLE, 0, 10, "Crustacea");
            case ODONATA:
                return new Arthropod(3, 1, RespirationType.TRACHEAL, MetamorphosisType.INCOMPLETE, 2, 6, "wings membranous");
            case ORTHOPTERA:
                return new Arthropod(3, 1, RespirationType.TRACHEAL, MetamorphosisType.INCOMPLETE, 2, 6, "hind legs enlarged");
            case DIPTERA:
                return new Arthropod(3, 1, RespirationType.TRACHEAL, MetamorphosisType.COMPLETE, 1, 6, "Diptera");
            case COLEOPTERA:
                return new Arthropod(3, 1, RespirationType.TRACHEAL, MetamorphosisType.COMPLETE, 2, 6, "hard exoskeleton and elytra");
            case LEPIDOPTERA:
                return new Arthropod(3, 1, RespirationType.TRACHEAL, MetamorphosisType.COMPLETE, 2, 6, "wings scaly");
            case HYMENOPTERA:
                return new Arthropod(3, 1, RespirationType.TRACHEAL, MetamorphosisType.COMPLETE, 2, 6, "wings membranous");
            default:
                // ArthropodType.UNKNOWN이거나 일치하지 않는 타입인 경우 UNKNOWN 타입 생성
                return new Arthropod(-1, -1, null, null, -1, -1, "Unknown Arthropod");
        }
    }

    // Builder 패턴을 사용해 Arthropod 객체를 동적으로 생성
    public static Arthropod create(int bodyRegions, int pairsOfAntennae, RespirationType respiration, MetamorphosisType metamorphosis, int pairsOfWing, int numberOfLegs, String distinction) {
        return new Arthropod.ArthropodBuilder()
                .setBodyRegions(bodyRegions)
                .setPairsOfAntennae(pairsOfAntennae)
                .setRespiration(respiration)
                .setMetamorphosis(metamorphosis)
                .setPairsOfWing(pairsOfWing)
                .setNumberOfLegs(numberOfLegs)
                .setDistinction(distinction)
                .build();
    }
}
