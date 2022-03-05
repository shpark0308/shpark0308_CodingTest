class ±¤°í»ðÀÔ_01_Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int total_time = StringToSecond(play_time.split(":"));
        int[] seconds = new int[total_time+1];
        
        for (int i=0; i<logs.length;i++) {
        	String[] str = logs[i].split("-");
        	int start_time = StringToSecond(str[0].split(":"));
        	int end_time = StringToSecond(str[1].split(":"));
        	
        	for (int t=start_time; t<end_time; t++) seconds[t]++;
        	
        }
        
        int startTime = 0;
        int endTime = StringToSecond(adv_time.split(":"));
        long sum = 0;
        
        for (int i=startTime; i<endTime; i++) sum+=seconds[i];
        
        // ´©Àû°ª¿¡¼­ ÇÏ³ª¾¿ »©°í ÇÏ³ª¾¿ Ãß°¡
        long maxsum = sum;
        int maxseconds = startTime;
        
        for ( ; endTime<=total_time; startTime++, endTime++) {
        	sum = sum-seconds[startTime]+seconds[endTime];
        	
        	if (sum>maxsum) {
        		maxsum = sum;
        		maxseconds = startTime+1; // ÇÑÄ­ ´õ ³ª¾Æ°£ Ãâ¹ß °ª
        	}
        	
        	
        }
        System.out.println(SecondToString(maxseconds));
        return SecondToString(maxseconds);
    }
    public int StringToSecond(String[] str) {
    	return 3600*Integer.parseInt(str[0])+60*Integer.parseInt(str[1])+Integer.parseInt(str[2]);
    }
    
    public String SecondToString(int seconds) {
    	int hh = seconds / 3600;
    	seconds%=3600;
    	int mm = seconds / 60;
    	seconds%=60;
    	String str = ((hh+"").length()<2?"0"+hh:hh+"")+":";
    	str += ((mm+"").length()<2?"0"+mm:mm+"")+":";
    	str += (seconds+"").length()<2?"0"+seconds:seconds+"";
    	return str;
    }
    
    
}
public class ±¤°í»ðÀÔ_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		±¤°í»ðÀÔ_01_Solution s = new ±¤°í»ðÀÔ_01_Solution();
		s.solution("02:03:55", "00:14:15", new String[] {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
		s.solution("99:59:59", "25:00:00", new String[] {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});
		s.solution("50:00:00", "50:00:00", new String[] {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"});
	}

}
