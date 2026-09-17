class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n=arr.length;
        int sum=0,low=0,high=0,best=Integer.MAX_VALUE;
        int [] tilli=new int[n];
        int inf=Integer.MAX_VALUE;
        int result=inf;
        Arrays.fill(tilli,inf);
        while(high<n)
        {
            sum+=arr[high];
            while(sum>target&&low<=high)
            {
                sum-=arr[low];
                low++;
            }
            if(sum==target)
            {
                int len=high-low+1;
                if(low>0&&tilli[low-1]!=inf)
                {
                   result=Math.min(result,len+tilli[low-1]);
                   System.out.println(result);
                
                }
                 best=Math.min(best,len);
               
            }
             tilli[high]=best;
            high++;
        }
        if(result==inf) return -1;
        return result;

    }
}