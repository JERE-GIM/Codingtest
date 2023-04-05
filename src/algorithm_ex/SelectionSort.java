package algorithm_ex;

import java.util.Arrays;

public class SelectionSort {
    public int[] selectionSort(int[] arr) {
        // 전체 배열을 검색하여 현재 요소와 비교하고 컬렉션이 완전히 정렬될 때까지
        // 현재 요소보다 더 작거나 큰 요소(오름차순 또는 내림차순에 따라)를 교환하는 정렬 알고리즘

        // i=0부터 arr.length -1 까지 조회
        for (int i = 0; i < arr.length - 1; i++) {
            // 가장 작은 값의 인덱스 min을 현재 자리 바꿀 i 인덱스로 초기화
            int min = i;
            // arr[i]과 i+1 ~ arr.length 범위의 숫자들을 쭈욱 비교
            for (int j = i + 1; j < arr.length; j++) {
                // 비교하면서 arr[min]보다 작은 숫자가 나올 때마다 min 변수에 그 인덱스를 저장
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            // 비교가 끝나면 min에 저장되어 있는 인덱스가 가장 작은 수의 인덱스이므로 이 인덱스의 값과 arr[i] 자리 교환
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }
}

class SelectionSort_Test {
    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        int[] output = s.selectionSort(new int[]{4, 5, 3, 2, 1, 6, 9});
        System.out.println(Arrays.toString(output));

        output = s.selectionSort(new int[]{3, 4, 5, 1});
        System.out.println(Arrays.toString(output));
    }
}
