import java.util.ArrayList;
import java.util.HashMap;

public class SolutionInstance {

    // Roller Hashmap <int, (Antalet skådespelare)[0] sorted list>
    HashMap<Integer, ArrayList<Integer>> rolls;
    // Scener Hashmap <int, (Totalt antal roller)[] Sorted list>
    HashMap<Integer, ArrayList<Integer>> scenes;

    int totalActorNum = 0;
    int totalRoleNum = 0;
    int initialActors;
    int initialRoles;
    int initialScene;

    public SolutionInstance(int initialActors, int initialRoles, int initialScene) {
        this.initialActors = initialActors;
        this.initialRoles = initialRoles;
        this.initialScene = initialScene;

        rolls = new HashMap<Integer, ArrayList<Integer>>();
        scenes = new HashMap<Integer, ArrayList<Integer>>();
    }

    public void addRole(int roleId, int actorId) {
        if (rolls.containsKey(roleId)) {
            rolls.get(roleId).add(0, rolls.get(roleId).get(0) + 1);
            rolls.get(roleId).add(actorId);
        } else {
            rolls.put(roleId, new ArrayList<Integer>(actorId));
            rolls.get(roleId).add(0, 1);
        }
        scenes.get(roleId).add(actorId);
        totalActorNum++;
    }

    //TODO test branch predictor.
    public void addScene(int sceneId, int roleId) {
        if (scenes.containsKey(sceneId)) {
            scenes.get(sceneId).add(0, scenes.get(sceneId).get(0) + 1);
        } else {
            scenes.put(sceneId, new ArrayList<Integer>());
            scenes.get(sceneId).add(0, 1);
        }
        scenes.get(sceneId).add(roleId);
        totalRoleNum++;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();

        //The first 3 values.
        sb.append(this.initialActors)
                .append("\n")
                .append(this.initialRoles)
                .append("\n")
                .append(this.initialScene)
                .append("\n");

        for(int i = 1; i < rolls.size(); i++){
            sb.append(rolls.get(0));
            for(Integer actor: rolls.get(i)){
                sb.append(" ");
                sb.append(actor);
            }
        }

        for(int i = 1; i < scenes.size(); i++){
            sb.append(scenes.get(0));
            for(Integer scenes: scenes.get(i)){
                sb.append(" ");
                sb.append(scenes);
            }
        }


        return sb.toString();
    }
}
