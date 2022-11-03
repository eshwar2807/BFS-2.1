class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> m = new HashMap<>();
        for(Employee e : employees){
            m.put(e.id, e);
        }
        return algo(id, m);
    }
    private int algo(int id, Map<Integer, Employee> m){
        Employee e = m.get(id);
        int ti = e.importance;
        for(int s : e.subordinates){
            ti += algo(s, m);
        }
        return ti;
    }
    
}
//tc=O(n);
//sc=O(n);
