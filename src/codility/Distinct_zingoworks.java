package codility;

import java.util.HashSet;
import java.util.Set;

public class Distinct_zingoworks {

    public int solution(int[] A) {
        Set<Integer> distinctNumbers = new HashSet<>();
        for (int each : A) {
            distinctNumbers.add(each);
        }

        return distinctNumbers.size();
    }

}
