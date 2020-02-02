package jianzhiOffer_third_time;


public class Problem42 {

    public String solution(String str, int pos) {
        if (null == str || pos < 0 || pos > str.length() - 1) {
            throw new RuntimeException("error");
        }
        
        str = getReverseStr(str, 0, str.length() - 1);
        str = getReverseStr(str, 0, str.length() - pos - 2);        
        str = getReverseStr(str, str.length() - pos - 1, str.length() - 1);
        

        return str;
    }
    
    private String getReverseStr(String str, int start_pos, int end_pos) {        
        StringBuilder str_build = new StringBuilder(str);        
        while (start_pos < end_pos) {
            char temp = str_build.charAt(start_pos);
            str_build.setCharAt(start_pos, str_build.charAt(end_pos));
            str_build.setCharAt(end_pos, temp);
            start_pos++;
            end_pos--;
        }        
        return str_build.toString();
    }
    
    public static void main(String[] args) {
        Problem42 p = new Problem42();
        String str = "abcdefg";
        
        System.out.println(p.solution(str, str.length() - 1));
//        p.getReverseStr(str, 0, 3);
    }
    
    
    
    
}
