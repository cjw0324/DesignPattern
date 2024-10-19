package arthropod.manager;

import arthropod.builder.Arthropod;
import arthropod.factory.ArthropodType;
import arthropod.factory.MetamorphosisType;
import arthropod.factory.RespirationType;

// 파일명: ArthropodClassifier.java
public class ArthropodClassifier {
    private ArthropodType arthropodType;
    private Arthropod arthropod;

    public ArthropodClassifier(ArthropodType arthropodType, Arthropod arthropod) {
        this.arthropodType = arthropodType;
        this.arthropod = arthropod;
    }

    public boolean matches(Arthropod otherArthropod) {
        return arthropod.getBodyRegions() == otherArthropod.getBodyRegions()
                && arthropod.getPairsOfAntennae() == otherArthropod.getPairsOfAntennae()
                && arthropod.getRespiration() == otherArthropod.getRespiration()
                && arthropod.getMetamorphosis() == otherArthropod.getMetamorphosis()
                && arthropod.getPairsOfWing() == otherArthropod.getPairsOfWing()
                && arthropod.getNumberOfLegs() == otherArthropod.getNumberOfLegs();
    }

    public boolean matches(int bodyRegions, int antennae, RespirationType respiration, MetamorphosisType metamorphosis, int wings, int legs) {
        return arthropod.getBodyRegions() == bodyRegions &&
                arthropod.getPairsOfAntennae() == antennae &&
                arthropod.getRespiration() == respiration &&
                arthropod.getMetamorphosis() == metamorphosis &&
                arthropod.getPairsOfWing() == wings &&
                arthropod.getNumberOfLegs() == legs;
    }

    public ArthropodType getArthropodType() {
        return arthropodType;
    }

    public Arthropod getArthropod() {
        return arthropod;
    }

    @Override
    public String toString() {
        return "ArthropodClassifier [arthropodType=" + arthropodType + ", arthropod=" + arthropod + "]";
    }
}
