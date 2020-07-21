package lab11;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.ArrayDeque;


public class Top {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in); 
            int n = sc.nextInt();
            
            List<Set<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; i++)
                g.add(new HashSet<>());

            Queue<Integer> q = new ArrayDeque<>();
            Map<Integer, Integer> mm = new HashMap<>();
            for (int i = 0; i < n; i++)
                mm.put(i, 0);
            
            int m = sc.nextInt();
            for (int i = 0; i < m; i++) {
                int f = sc.nextInt();
                int t = sc.nextInt();

                g.get(f).add(t);
                mm.replace(t, mm.get(t)+1);
            }

            for (Map.Entry<Integer, Integer> e : mm.entrySet()) {
                if (e.getValue() == 0)
                    q.add(e.getKey());
            }

            	while (!q.isEmpty()) {
                int v = q.remove();
                System.out.printf("%d\n", v);

                for (int vv : g.get(v)) {
                    int d = mm.get(vv)-1;

                    if (d == 0)
                        q.add(vv);
                    mm.replace(vv, d);
                }
            }
        } 
    }

