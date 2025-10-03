 class test{
  
    public int findPeakElement(int[] arr) {
   int n=arr.length;
   int low=0,high=n-1;
   while(low<=high)
   {
    int mid=low+(high-low)/2;
    if((mid==0||arr[mid-1]<arr[mid])&&(mid==n-1||arr[mid]>arr[mid+1]))
    {
        return mid;
    }
    else if(mid<n-1&&arr[mid]<arr[mid+1])
    {
        low=mid+1;
    }
    else
    high=mid-1;
   }
   return -1;
}
    public static void main(String[] args) {
        test t = new test();
        int[] arr = {1,2,6,6,7,4};
        int peakIndex = t.findPeakElement(arr);
        if(peakIndex == -1) {
            System.out.println("No peak element found.");
        } else {
            System.out.println("Peak element: " + arr[peakIndex]);
        }
    
    }
}