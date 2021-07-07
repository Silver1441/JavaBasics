package task1.service.builder;

import java.util.ArrayList;
import java.util.List;

public class IdBuilder {
    public static List<Integer> listId = new ArrayList<>();

    public static int getNewId() {
        if (listId.isEmpty()) {
            listId.add(100);
        } else {
            listId.add(listId.get(listId.size() - 1) + 1);
        }
        return listId.get(listId.size() - 1);
    }
}
