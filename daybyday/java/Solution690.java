package daybyday.java;

import java.util.*;

public class Solution690 {
    // 员工的重要性 dfs 和 bfs
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public int getImportance(List<Employee> employees, int id) {
        Deque<Integer> stack = new LinkedList<>();

        HashMap<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }

        stack.push(id);

        int res = 0;
        while (!stack.isEmpty()) {
            Employee curEmployee = map.get(stack.pop());
            res += curEmployee.importance;
            for (int i = 0; i < curEmployee.subordinates.size(); i++) {
                stack.push(curEmployee.subordinates.get(i));
            }
        }
        return res;
    }
}
