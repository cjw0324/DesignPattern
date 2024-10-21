package lecture6.builder;

import org.codehaus.groovy.transform.SourceURIASTTransformation;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder("Intel i5", "16GB").build();
        System.out.println(computer);

        Computer gamingComputer = new Computer.ComputerBuilder("AMD 5700X3D", "32GB")
                .setStorage("2TB").setGraphicCard("NVDIA RTX 4080").setPowerSupply("800W").build();
        System.out.println(gamingComputer);
    }
}
