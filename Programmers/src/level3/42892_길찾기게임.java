import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    static int index;

    public static class Node implements Comparable<Node> {
        int x, y, idx;
        Node left, right;

        public Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node n) {
            if (this.y == n.y) {
                if (this.x > n.x)
                    return 1;
                else
                    return -1;
            } else if (this.y < n.y)
                return 1;
            else
                return -1;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        ArrayList<Node> list = new ArrayList<Node>();

        for (int a = 0; a < nodeinfo.length; a++) {
            list.add(new Node(nodeinfo[a][0], nodeinfo[a][1], a + 1));
        }

        Collections.sort(list);

        Node root = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            addNode(root, list.get(i));
        }

        preorder(answer, root);
        index = 0;
        postorder(answer, root);

        return answer;
    }

    public static void addNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                addNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                addNode(parent.right, child);
            }
        }
    }

    public static void preorder(int[][] arr, Node root) { // 전위순회

        if (root != null) {
            arr[0][index++] = root.idx;
            preorder(arr, root.left);
            preorder(arr, root.right);
        }
    }

    public static void postorder(int[][] arr, Node root) { // 후위순회
        if (root != null) {
            postorder(arr, root.left);
            postorder(arr, root.right);
            arr[1][index++] = root.idx;
        }
    }
}