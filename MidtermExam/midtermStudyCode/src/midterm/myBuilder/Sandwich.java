package midterm.myBuilder;

public class Sandwich {
    private final String bread;
    private final String ham;
    private final String sausage;
    private final String sauce;

    private Sandwich(SandwichBuilder sandwichBuilder) {
        this.bread = sandwichBuilder.bread;
        this.ham = sandwichBuilder.ham;
        this.sausage = sandwichBuilder.sausage;
        this.sauce = sandwichBuilder.sauce;
    }

    @Override
    public String toString() {
        return "bread : " + bread + " ,ham : " + ham + " ,sausage : " + sausage + " ,sauce : " + sauce;
    }

    public static class SandwichBuilder {
        private final String bread;
        private final String ham;
        private String sausage;
        private String sauce;

        public SandwichBuilder(String bread, String ham){
            this.bread = bread;
            this.ham = ham;
        }

        public SandwichBuilder setSausage(String sausage) {
            this.sausage = sausage;
            return this;
        }

        public SandwichBuilder setSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Sandwich sandwichBuilder() {
            return new Sandwich(this);
        }

    }
}
