package arthropod.factory;

public enum ArthropodType {
    ARACHNIDA, CHILOPODA, DIPLOPODA, CRUSTACEA, ODONATA, ORTHOPTERA, DIPTERA, COLEOPTERA, LEPIDOPTERA, HYMENOPTERA, UNKNOWN;

    public static ArthropodType getArthropodType(String name) {
        return ArthropodType.getArthropodType(name);
    }
}
