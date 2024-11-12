package midterm.last.decorator;

public class ConcreteComponent2 extends Component {
    public ConcreteComponent2() {

    }
    @Override
    public String getDescription() {
        return "this is concrete component 2";
    }

    @Override
    public int cost() {
        return 2;
    }
}
