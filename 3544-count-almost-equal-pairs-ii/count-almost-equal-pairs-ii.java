class Solution {
    public int countPairs(int[] nums) {
        int cnt=0;
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                int x=nums[i];
                int y = nums[j];
                if(x==y) {
                    cnt++;
                    continue;
                }

                int unequalsDigits=0;
                // for at most 2 swaps, at most 4 unequalDigit pairs are possible,
                // more than 4 will result in numbers inelegible to count 
                int[][] d = {
                    {-1, -1},
                    {-1, -1},
                    {-1, -1},
                    {-1, -1},
                };

                while(x!=0 || y!=0) {
                    //remainders  ( digits ) to compare
                    int r1 = x%10;
                    int r2 = y%10;

                    x/=10;
                    y/=10;
                    
                    if(r1==r2) continue;
                    else unequalsDigits++;


                    if(unequalsDigits==1) {
                        d[0][0]=r1;
                        d[0][1]=r2;
                    }
                    else if(unequalsDigits==2) {
                        d[1][0]=r1;
                        d[1][1]=r2;
                        
                    }
                    else if(unequalsDigits==3) {
                        d[2][0]=r1;
                        d[2][1]=r2;
                        
                    }
                    else if(unequalsDigits==4) {
                        d[3][0]=r1;
                        d[3][1]=r2;
                        
                    }else if(unequalsDigits>4) {
                        break;
                    }

                }

                if(unequalsDigits>4) continue;

                if(unequalsDigits==4) {
                    // make pairs of 2 ,2 for the swap to happen
                    HashMap<Integer, Integer> map = new HashMap<>();

                    for(int rw1=0; rw1<3; rw1++) {
                        if(map.containsKey(rw1)) continue;
                        for(int rw2=rw1+1; rw2<4; rw2++) {
                            if(map.containsKey(rw2)) continue;
                            int[] a = d[rw1];
                            int[] b = d[rw2];
                            if(a[0]==b[1] && a[1]==b[0]) {
                                map.put(rw1, rw2);
                                map.put(rw2, rw1);
                                break;
                            }
                        }
                    }

                    if(map.size()==4) cnt++;
                }else if(unequalsDigits==3) {

                    // for 2 swaps the numbers will have to interchange with one another twice
                    // eg. 3,2,1
                    //     1,3,2   swap 1 and 2 first in first row than swap 1 and 3 
                    // so for digits of first row we increment frequency of digits
                    // and for digts of second row we decrease 
                    // tha check if the numbers are not adjusted back to zero meaning different digits are present and cannot be made equals after swaps.
                    int[] fq = new int[10];
                    fq[d[0][0]]++;
                    fq[d[1][0]]++;
                    fq[d[2][0]]++;
                    fq[d[0][1]]--;
                    fq[d[1][1]]--;
                    fq[d[2][1]]--;
                    
                    for(int t=0; t<10; t++) {
                        if(fq[t]!=0) {
                            cnt--;
                            break;
                        }
                    }
                    cnt++;
                }
                else if(unequalsDigits==2) {
                    // similer to Q 2, just check if the unequalsDigit pairs are swappable to make numbers equal.
                    if(d[0][0]==d[1][1] && d[1][0]==d[0][1]) cnt++;
                }
            }
        }

        return cnt;
    }
}