import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        HashSet<Integer> keys = new HashSet<>();
        keys.add(0);

        traverseRooms(rooms, keys, 0);

        return keys.size() == n;
    }

    private void traverseRooms(List<List<Integer>> rooms, Set<Integer> keys, int roomIndex) {
        List<Integer> newKeys = rooms.get(roomIndex);

        if (keys.addAll(newKeys)) {
            for (Integer key : newKeys) {
                traverseRooms(rooms, keys, key);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        );

        System.out.println(new Solution841().canVisitAllRooms(rooms));
    }
}

