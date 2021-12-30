package KAKAO_BLIND_RECRUITMENT;


class ±¤°í»ðÀÔ_Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
    	String[] str = play_time.split(":");
    	int total_play_time = changeIntoTime(str);
    	str = adv_time.split(":");
    	int total_adv_time = changeIntoTime(str);

    	int[] timeArr = new int[total_play_time+1];
    	for (int i=0; i<logs.length;i++) {
    		str = logs[i].split("-");
    		int start_time = changeIntoTime(str[0].split(":"));
    		int end_time = changeIntoTime(str[1].split(":"));
    		for (int t=start_time; t<end_time; t++) timeArr[t]++;
    	}
    	
    	int start = 0;
    	int end = total_adv_time;
    	long sum = 0;
    	for (int i=start; i<end; i++) sum+=timeArr[i];
    	
    	long maxnum = sum;
    	int maxtime = start;
    	
    	while(end<=total_play_time) {
    		sum=sum-timeArr[start]+timeArr[end];
    		if (sum>maxnum) {
    			maxnum = sum;
    			maxtime = start+1;
    		}
    		start++;
    		end++;
    	}
    	int hh = maxtime/3600;
    	int mm = (maxtime%3600)/60;
    	int ss = (maxtime%3600)%60;
        String answer = changeToTime(hh)+":"+changeToTime(mm)+":"+changeToTime(ss);
        System.out.println(answer);
        return answer;
    }
    public static int changeIntoTime(String[] str) {
    	return Integer.parseInt(str[0])*3600+Integer.parseInt(str[1])*60+Integer.parseInt(str[2]);
    }
    public static String changeToTime(int time) {
    	String strtime = time+"";
    	switch(strtime.length()) {
    	case 2: return strtime;
    	case 1: return "0"+strtime;
    	default: return "00";
    	}
    }
}
public class ±¤°í»ðÀÔ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		±¤°í»ðÀÔ_Solution s = new ±¤°í»ðÀÔ_Solution();
		//s.solution("02:03:55", "00:14:15", new String[] {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"});
		//s.solution("99:59:59", 	"25:00:00", new String[] {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});
		s.solution("50:00:00","50:00:00", new String[] {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"});

	}

}
