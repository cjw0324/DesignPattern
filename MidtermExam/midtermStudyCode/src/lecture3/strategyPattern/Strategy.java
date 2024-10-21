package lecture3.strategyPattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Strategy {
    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            temp.add((int) (Math.random()*10));
        }

        Collections.sort(temp);

        System.out.println(temp);
    }
}
