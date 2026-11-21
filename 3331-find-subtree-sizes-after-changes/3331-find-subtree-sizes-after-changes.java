import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) children[parent[i]].add(i);

        int[] newParent = new int[n];
        newParent[0] = -1;
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] order = new int[n];
        int cnt = 0;

        // iterative DFS: stack of nodes, idx pointer per node, saved[] restores last[]
        int[] stack = new int[n];
        int[] idx = new int[n];
        int[] saved = new int[n];
        int top = 0;

        stack[top++] = 0;
        order[cnt++] = 0;
        int c0 = s.charAt(0) - 'a';
        saved[0] = last[c0];
        last[c0] = 0;

        while (top > 0) {
            int u = stack[top - 1];
            if (idx[u] < children[u].size()) {
                int v = children[u].get(idx[u]++);
                int c = s.charAt(v) - 'a';
                newParent[v] = last[c] != -1 ? last[c] : parent[v];
                saved[v] = last[c];
                last[c] = v;
                order[cnt++] = v;
                stack[top++] = v;
            } else {
                int c = s.charAt(u) - 'a';
                last[c] = saved[u];
                top--;
            }
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = n - 1; i > 0; i--) {
            int v = order[i];
            ans[newParent[v]] += ans[v];
        }
        return ans;
    }
}