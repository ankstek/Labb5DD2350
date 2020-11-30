import java.awt.event.KeyAdapter;

public class HeuristicSolver {
    public HeuristicSolver(){
        init();

    }

    private InstanceParser init(){

        InstanceParser parser = new InstanceParser(new Kattio(System.in,System.out));


        return parser;
    }



    public static void main(String[] args){

    }
}
