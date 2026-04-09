class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int yCord = 0;
        int xCord = 0;
        int xDir = 0;
        int yDir = 1;
        int maxDist = Integer.MIN_VALUE;
        int n = commands.length;
        Set<String> set = new HashSet<>();
        int l = obstacles.length;
        // int m = obstacles[0].length;
        for(int i = 0; i < l; i++){
            set.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        for(int i = 0; i < n; i++){
            if(commands[i] < 0){
                if(yDir == 1 && commands[i] == -2 || yDir == -1 && commands[i] == -1){
                    xDir = -1;
                    yDir = 0;
                }else if(yDir == 1 && commands[i] == -1 || yDir == -1 && commands[i] == -2){
                    xDir = 1;
                    yDir = 0;
                }else if(xDir == 1 && commands[i] == -2 || xDir == -1 && commands[i] == -1){
                    yDir = 1;
                    xDir = 0;
                }else if(xDir == 1 && commands[i] == -1 || xDir == -1 && commands[i] == -2) {
                    yDir = -1;
                    xDir = 0;
                }
            }else{
                // if(xDir == 0){
                //     int start = Math.min(yCord, yCord + commands[i] * yDir);
                //     int end = Math.max(yCord, yCord + commands[i] * yDir);
                //     for(int j = start; j <= end; j++){
                //         if(set.contains(xCord + "," + j)){
                //             yCord = j - 1;
                //             break;
                //         }
                //     }
                // }else{
                //     int start = Math.min(xCord, xCord + commands[i] * xDir);
                //     int end = Math.max(xCord,xCord + commands[i] * xDir);
                //     for(int j = start; j <= end; j++){
                //         if(set.contains(j + "," + yCord)){
                //             xCord = j - 1; 
                //             break;
                //         }
                //     }
                // } this code is loosing the sense of dirn the robot is moving
                for (int step = 1; step <= commands[i]; step++) {
                    int nextX = xCord + xDir;
                    int nextY = yCord + yDir;

                    if (set.contains(nextX + "," + nextY)) {
                        break; 
                    }

                    xCord = nextX;
                    yCord = nextY;
                }
            }
            maxDist = Math.max(maxDist, xCord*xCord + yCord*yCord);
        }
        return maxDist;
    }
}