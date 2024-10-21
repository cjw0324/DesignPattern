package lecture6.builder;

public class Computer {
    private final String CPU;
    private final String RAM;

    private final String storage;
    private final String graphicCard;
    private final String powerSupply;

    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicCard = builder.graphicCard;
        this.powerSupply = builder.powerSupply;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM +
                ", Storage=" + storage +
                ", GraphicsCard=" + graphicCard +
                ", PowerSupply=" + powerSupply + "]";
    }

    public static class ComputerBuilder {
        private String CPU;
        private String RAM;

        private String storage;
        private String graphicCard;
        private String powerSupply;

        public ComputerBuilder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGraphicCard(String graphicCard) {
            this.graphicCard = graphicCard;
            return this;
        }

        public ComputerBuilder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
