package midterm.factory.mycode;
public class AvanteComponentFactory implements ComponentFactory{
    public String createEngine(){
        return "직렬 4기통";
    }

    public String createOption1(){
        return "차선 보조";
    }

    public String createOption2(){
        return "N 패키지";
    }
}
