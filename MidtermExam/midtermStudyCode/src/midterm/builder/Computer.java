package midterm.builder;

public class Computer {
    private final String CPU;
    private final String RAM;
    private final String Storage;
    private final String graphicCard;

    private Computer(ComputerBuilder builder) {
        CPU = builder.CPU;
        RAM = builder.RAM;
        Storage = builder.Storage;
        graphicCard = builder.graphicCard;
    }

    @Override
    public String toString() {
        return "Computer [CPU : " + CPU + ", RAM : " + RAM + ", Storage : " + Storage + ", graphicCard : " + graphicCard + "]";
    }

    public static class ComputerBuilder{
        private String CPU;
        private String RAM;
        private String Storage;
        private String graphicCard;

        public ComputerBuilder(String cpu, String ram) {
            this.CPU = cpu;
            this.RAM = ram;
        }

        public ComputerBuilder setStorage(String storage) {
            this.Storage = storage;
            return this;
        }

        public ComputerBuilder setGraphicCard(String graphicCard) {
            this.graphicCard = graphicCard;
            return this;
        }

        public Computer builder() {
            return new Computer(this);
        }
    }
}
