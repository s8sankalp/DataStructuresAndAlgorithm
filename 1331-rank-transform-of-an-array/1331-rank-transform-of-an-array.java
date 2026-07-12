class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> mpp=new HashMap<>();
        int[] sort=Arrays.copyOf(arr,arr.length);
        Arrays.sort(sort);
        int rank=1;
        for(int i=0;i<sort.length;i++)
        {
            if(i>0&&sort[i]>sort[i-1])
            {
                rank++;
            }
            mpp.put(sort[i],rank);
        }
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=mpp.get(arr[i]);
        }
        return arr;
    }
}