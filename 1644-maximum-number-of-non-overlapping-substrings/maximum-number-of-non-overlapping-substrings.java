class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        boolean [] isvaild=new boolean[26];
        int [] start=new int[26];
        int [] end=new int[26]; 
        Arrays.fill(start,-1);
        Arrays.fill(isvaild,true);
        List<String> ans=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            int c=s.charAt(i)-'a';
            if(start[c]==-1) start[c]=i; 
            end[c]=i; 
        }

        for(int i=0;i<26;i++)
        {
            if(start[i]==-1) continue;
            for(int j=start[i];j<=end[i];j++) 
            {
                int c=s.charAt(j)-'a'; 
                if(start[c]<start[i])
                {
                    isvaild[i]=false;
                    break;
                }
                end[i]=Math.max(end[i],end[c]); 
            }
        }
        int laststart=Integer.MAX_VALUE;
        for(int i=s.length()-1;i>=0;i--)
        {
            int c=s.charAt(i)-'a';
            if(!isvaild[c]) continue;
            if(start[c]==i&&end[c]<laststart)
            {
                ans.add(s.substring(start[c],end[c]+1));
                laststart=start[c];
            }

        }
        Collections.reverse(ans); 
        return ans; 


        
    }
}