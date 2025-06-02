public class Solution extends Relation {
    public int findCelebrity(int n) {
        int startP = 0;
        int lastP = n-1;
        while(lastP>startP){
            if(knows(startP,lastP)){
                startP++;
            } else{
                lastP--;
                if(!knows(lastP,startP)){
                    startP++;
                }
            }
        }
        int posCeleb = startP;
        for(int i=0; i<n; i++){
            if((knows(posCeleb,i) || !knows(i,posCeleb)) && posCeleb != i ){
                return -1;
            }
        }
        return posCeleb;
    }
}
