package giuliani;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static String[] arrIn = {
            "1001-40",
            "1002-50",
            "1003-60",
            "1002-80",
            "1005-35",
            "1005-55",
            "1007-68",
            "1009-98",
            "1009-99",
            "1009-10",
            "1004-89"
            };

    public static void main(String... args) {
        List<String[]> li = new LinkedList<>();


        Arrays.sort(arrIn);

        for (String in : arrIn) {

            String[] studentScore = in.split("-");
            boolean studentInList = false;
            int toRemove = -1;

            for (int i = 0; i < li.size(); i++) {
                String[] e = li.get(i);

                if (studentScore[0].equals(e[0])) {
                    if (!studentInList && studentScore[1].compareTo(e[1]) > 0) {
                        li.add(i, studentScore);
                        toRemove = i + 1;
                    } else {
                        toRemove = i;
                    }
                    studentInList = true;
                    break;
                } else if (!studentInList && studentScore[1].compareTo(e[1]) > 0) {
                    li.add(i, studentScore);
                    studentInList = true;
                }
            }
            if (!studentInList) {
                li.add(studentScore);
            } else if (toRemove > -1) {
                li.remove(toRemove);
            }
        }

        for (String[] e : li) {
            System.out.println(e[0] + '-' + e[1]);
        }

    }
}


