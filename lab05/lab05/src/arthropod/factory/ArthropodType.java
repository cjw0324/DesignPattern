// 2024-10-22 1분반 최재우 32184682

package arthropod.factory;

public enum ArthropodType {
    // 다양한 Arthropod의 종류를 정의
    ARACHNIDA, CHILOPODA, DIPLOPODA, CRUSTACEA, ODONATA, ORTHOPTERA, DIPTERA, COLEOPTERA, LEPIDOPTERA, HYMENOPTERA, UNKNOWN;

    // 주어진 이름에 해당하는 ArthropodType을 반환
    public static ArthropodType getArthropodType(String name) {
        try {
            return ArthropodType.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN;  // 잘못된 이름일 경우 UNKNOWN 반환
        }
    }
}
