package DS1;
/*
[1,5,6,0,0,0]
3
[1,2,3]
3
112356
*/

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {4,5,6};
        merge3(nums1, 3, nums2, 3);
        for(int n : nums1){
            System.out.print(n+", ");
        }
    }
    //fastest
    public static void merge3(int[] nums1, int m, int[] nums2, int n){
        int i=m-1, j=n-1, k=m+n-1;
        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k--]=nums1[i--];
            } else{
                nums1[k--]=nums2[j--];
            }
        }
    }
    //2nd fastest
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j=n-1, k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--]=nums1[i--];
            } else{
                nums1[k--]=nums2[j--];
            }
        }
        while(i>=0){
            nums1[k--]=nums1[i--];
        }
        while(j>=0){
            nums1[k--]=nums2[j--];
        }
    }
    //3rd fastest
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length!=0){
            for(int i=0, j=0; i<m+n; i++){
                if(nums1[i]>nums2[j] && i<m){
                    int swapVar = nums1[i];
                    nums1[i]=nums2[j];
                    nums2[j]=swapVar;
                    int k=j;
                    while(k+1<n && nums2[k]>nums2[k+1]){
                        int swapVar2 = nums2[k];
                        nums2[k]=nums2[k+1];
                        nums2[k+1]=swapVar2;
                        k++;
                    }
                } else if (i>=m){
                    nums1[i]=nums2[j];
                    j++;
                }
            } 
        }
    }
}