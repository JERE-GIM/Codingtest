package daily_coding;

public class RotatedArraySearch {
    public int rotatedArraySearch(int[] rotated, int target) {
        int left = 0;
        int right = rotated.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(rotated[mid] == target) return mid;

            if(rotated[left] < rotated[mid]) {
                if(rotated[left] <= target && target < rotated[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(rotated[mid] < target && target <= rotated[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

class RotatedArraySearch_Test {
    public static void main(String[] args) {
        RotatedArraySearch r = new RotatedArraySearch();

        int output = r.rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 3);
        System.out.println(output); // --> 5

        output = r.rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 100);
        System.out.println(output); // --> -1
    }
}
