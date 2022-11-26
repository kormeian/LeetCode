class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (numbers[index1] + numbers[index2] != target) {
            int sum = numbers[index1] + numbers[index2];
            if (sum < target) {
                index1++;
            } else {
                index2--;
            }
        }
        answer[0] = index1 + 1;
        answer[1] = index2 + 1;

        return answer;
    }
}