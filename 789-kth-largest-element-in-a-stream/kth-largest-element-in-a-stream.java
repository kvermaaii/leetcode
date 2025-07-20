import java.util.*;

class KthLargest {
    int kth;
    List<Integer> list;

    public KthLargest(int k, int[] nums) {
        kth = k;
        list = new ArrayList<>();
        Arrays.sort(nums);
        for (int num : nums) {
            list.add(num);
        }
    }

    public int add(int val) {
        insert(list, val, 0, list.size() - 1);
        return list.get(list.size() - kth);
    }

    private void insert(List<Integer> list, int val, int start, int end) {
        // When list is empty or insert at end
        if (start > end) {
            list.add(start, val);
            return;
        }
        int mid = start + (end - start) / 2;
        if (list.get(mid) > val) {
            insert(list, val, start, mid - 1);
        } else {
            insert(list, val, mid + 1, end);
        }
    }
}


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */