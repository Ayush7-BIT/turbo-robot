class SegmentTree {
    int[] segmentTree;
    int n;

    public SegmentTree(int[] arr) {
        n = arr.length;
        segmentTree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }

  
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = arr[start];
        } else {
            int mid = start + (end - start) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            segmentTree[node] = Math.min(segmentTree[2 * node + 1], segmentTree[2 * node + 2]);
        }
    }

    public int query(int L, int R) {
        return queryUtil(0, 0, n - 1, L, R);
    }

    private int queryUtil(int node, int start, int end, int L, int R) {
        if (R < start || L > end) {
            return Integer.MAX_VALUE;
        }
        if (L <= start && end <= R) {
            return segmentTree[node];
        }
        int mid = start + (end - start) / 2;
        int leftQuery = queryUtil(2 * node + 1, start, mid, L, R);
        int rightQuery = queryUtil(2 * node + 2, mid + 1, end, L, R);
        return Math.min(leftQuery, rightQuery);
    }

    public void update(int idx, int value) {
        updateUtil(0, 0, n - 1, idx, value);
    }

    private void updateUtil(int node, int start, int end, int idx, int value) {
        if (start == end) {
            
            segmentTree[node] = value;
        } else {
            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                updateUtil(2 * node + 1, start, mid, idx, value);
            } else {
                updateUtil(2 * node + 2, mid + 1, end, idx, value);
            }
            segmentTree[node] = Math.min(segmentTree[2 * node + 1], segmentTree[2 * node + 2]);
        }
    }
}

public class RMQ {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9, 11, 4, 5};
        SegmentTree st = new SegmentTree(arr);

        System.out.println("Minimum value in range(1, 5): " + st.query(1, 5));
        System.out.println("Minimum value in range(0, 3): " + st.query(0, 3));

        st.update(2, 6);
        System.out.println("Minimum value in range(1, 5) after update: " + st.query(1, 5));
    }
}
