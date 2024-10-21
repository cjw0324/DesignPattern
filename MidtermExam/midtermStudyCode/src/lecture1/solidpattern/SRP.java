package lecture1.solidpattern;

public class SRP {
    public String generateReport() {
        return "Report data";
    }

    public void saveReport(String data) {
        //파일에 저장하는 비즈니스 로직
        System.out.println("save report");
    }
}

