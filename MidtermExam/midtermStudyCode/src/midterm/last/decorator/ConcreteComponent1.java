package midterm.last.decorator;

public class ConcreteComponent1 extends Component {

    public ConcreteComponent1() {

    }
    @Override
    public String getDescription() {
        return "this is concrete component 1";
    }

    @Override
    public int cost() {
        return 1;
    }
}
