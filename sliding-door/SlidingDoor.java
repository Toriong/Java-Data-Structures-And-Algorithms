import java.util.ArrayList;
import java.util.List;

public class SlidingDoor {

    public static List<Integer> getLargestConsectiveNums(ArrayList<Integer> nums, Integer targetConsectiveLengthNum) {
        ArrayList<Integer> windowQueue = new ArrayList<Integer>(nums.size());
        Integer windowQueueSum = 0;
        Integer largestConsectiveNum = 0;
        ArrayList<Integer> largetSumConsectiveNumQueue = new ArrayList<Integer>(targetConsectiveLengthNum);

        for (Integer numIteration = 0; numIteration < nums.size(); numIteration++) {
            Integer num = nums.get(numIteration);

            if (windowQueue.size() == targetConsectiveLengthNum) {
                Integer removedNum = windowQueue.removeFirst();
                windowQueueSum = windowQueueSum - removedNum;
            }

            windowQueue.addLast(num);
            windowQueueSum = windowQueueSum + num;

            System.out.println(largestConsectiveNum);
            System.out.println(windowQueueSum);

            if (windowQueueSum > largestConsectiveNum) {
                largestConsectiveNum = windowQueueSum;
                largetSumConsectiveNumQueue = (ArrayList<Integer>) windowQueue.clone();
            }
        }

        return largetSumConsectiveNumQueue.stream().toList();
    }

    public static void main(String[] args) {
        int[] numsArr = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        ArrayList<Integer> numsArrayList = new ArrayList<Integer>();

        for (int numIteration = 0; numIteration < numsArr.length; numIteration++) {
            int num = numsArr[numIteration];
            numsArrayList.add(num);
        }

        List<Integer> largestConsectiveNums = getLargestConsectiveNums(numsArrayList, 4);
        int largetConsectiveNumsSum = largestConsectiveNums.stream().mapToInt(num -> num).sum();
        System.out.println(String.format("largest consecutive nums array: %s", largestConsectiveNums));
        System.out.println(String.format("largest consecutive nums sum: %s", largetConsectiveNumsSum));
    }
}