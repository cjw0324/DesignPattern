package arthropod.builder;

import arthropod.factory.MetamorphosisType;
import arthropod.factory.RespirationType;

public class Arthropod {
    private int bodyRegions;
    private int pairsOfAntennae;
    private RespirationType respiration;
    private MetamorphosisType metamorphosis;
    private int pairsOfWing;
    private int numberOfLegs;

    //Optional
    private String distinction;

    public Arthropod(int bodyRegions, int pairsOfAntennae, RespirationType respiration, MetamorphosisType metamorphosis, int pairsOfWing, int numberOfLegs, String distinction) {
        this.bodyRegions = bodyRegions;
        this.pairsOfAntennae = pairsOfAntennae;
        this.respiration = respiration;
        this.metamorphosis = metamorphosis;
        this.pairsOfWing = pairsOfWing;
        this.numberOfLegs = numberOfLegs;
        this.distinction = distinction;
    }

    private Arthropod(ArthropodBuilder builder) {
        this.bodyRegions = builder.bodyRegions;
        this.pairsOfAntennae = builder.pairsOfAntennae;
        this.respiration = builder.respiration;
        this.metamorphosis = builder.metamorphosis;
        this.pairsOfWing = builder.pairsOfWing;
        this.numberOfLegs = builder.numberOfLegs;
        this.distinction = builder.distinction;
    }

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

    public static class ArthropodBuilder{
        private int bodyRegions;
        private int pairsOfAntennae;
        private RespirationType respiration;
        private MetamorphosisType metamorphosis;
        private int pairsOfWing;
        private int numberOfLegs;
        private String distinction;

        public ArthropodBuilder() {

        }

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


        public Arthropod build() {
            return new Arthropod(this);
        }
    }
}
