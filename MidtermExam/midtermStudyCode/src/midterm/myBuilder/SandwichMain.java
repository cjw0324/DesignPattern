package midterm.myBuilder;

public class SandwichMain {
    public static void main(String[] args) {
        Sandwich mySandwich = new Sandwich.SandwichBuilder("homil bread", "spam").sandwichBuilder();
        System.out.println(mySandwich);

        mySandwich = new Sandwich.SandwichBuilder("flat bread", "런천미트").setSauce("olive oil").setSausage("킬바사 소시지").sandwichBuilder();
        System.out.println(mySandwich);
    }
}
