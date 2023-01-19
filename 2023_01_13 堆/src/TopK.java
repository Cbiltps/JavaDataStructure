import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-01-17
 * Time: 18:00
 */
public class TopK {
    /**
     * 求数组当中的前K个最小的元素
     * @param array
     * @param k
     * @return
     */
    public static int[] topK(int[] array, int k) {
        // 1.创建一个大小为k的大根堆(默认是小根堆)
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 2.遍历数组当中的元素, 前K个元素放到队列当中
        for (int i = 0; i < array.length; i++) {
            if (bigHeap.size() < k) {
                bigHeap.offer(array[i]);
            } else {
                // 3.从第k+1个元素开始, 每个元素和堆顶元素进行比较
                if (array[i] < bigHeap.peek()) {
                    // 3.1先弹出
                    bigHeap.poll();
                    // 3.2后存入
                    bigHeap.offer(array[i]);
                }
            }
        }
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = bigHeap.poll();
        }
        return tmp;
    }

    /**
     * 373. 查找和最小的 K 对数字
     * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/submissions/
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> bigHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
            }
        });

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (bigHeap.size() < k) {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums1[i]);
                    tmpList.add(nums2[j]);
                    bigHeap.offer(tmpList);
                } else {
                    int top = bigHeap.peek().get(0) + bigHeap.peek().get(1);
                    if ((nums1[i] + nums2[j]) < top) {
                        bigHeap.poll();
                        List<Integer> tmpList = new ArrayList<>();
                        tmpList.add(nums1[i]);
                        tmpList.add(nums2[j]);
                        bigHeap.offer(tmpList);
                    } else {
                        break;
                    }
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k && !bigHeap.isEmpty(); i++) {
            result.add(bigHeap.poll());
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] array = {18, 21, 8, 10, 34, 12};
//        int[] tmp = topK(array, 3);
//        System.out.println(Arrays.toString(tmp));

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> ret = kSmallestPairs(nums1, nums2, 3);
        System.out.println(ret);
    }
}



