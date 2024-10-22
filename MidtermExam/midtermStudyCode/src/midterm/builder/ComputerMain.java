package midterm.builder;

public class ComputerMain {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("i7", "32gb").builder();
        System.out.println(computer);

        computer = new Computer.ComputerBuilder("i5", "16gb").setStorage("2TB").setGraphicCard("RTX 4080ti").builder();
        System.out.println(computer);
    }
}
