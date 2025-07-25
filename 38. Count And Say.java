class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for(int i=2; i<=n; i++){
            s = countAndAdd(s);
        }
        return s;
    }

    String countAndAdd(String s){
        StringBuilder currString = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            } else {
                currString.append(count);
                currString.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        currString.append(count);
        currString.append(c);
        return currString.toString();
    }
}
