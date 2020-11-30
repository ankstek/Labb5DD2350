

public class InstanceParser {




    public InstanceParser(Kattio io){
        int numActor = io.getInt();
        int numRoles = io.getInt();
        int numScenes = io.getInt();

        SolutionInstance instance = new SolutionInstance(numActor,numRoles,numScenes);

        for (int i = 0; i < numRoles; i++) {
            int a = io.getInt();
            for(int j = 0; j < a; j++){
                instance.addRole(i, io.getInt());
            }
        }

        for (int i = 0; i < numScenes; i++) {
            int a = io.getInt();
            for(int j = 0; j < a; j++){
                instance.addScene(i, io.getInt());
            }
        }
    }




}
