public class SameDashes {
    public static boolean sameDashes(String str1, String str2) {
        String shorter = "";
        String longer = "";
        // TODO: Your code here
        if (str1.length() > str2.length()) {
            shorter = str2;
            longer = str1;
        } else {
            shorter = str1;
            longer = str2;
        }

        for (int i = shorter.length(); i < longer.length(); i++) {
            shorter = shorter.concat("o");
        }

        for (int i = 0; i < shorter.length(); i++) {
            if (shorter.charAt(i) == '-' && longer.charAt(i) != '-' || longer.charAt(i) == '-' && shorter.charAt(i) != '-') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(sameDashes("1st-has-more characters", "2nd-has-less"));
        System.out.println(sameDashes("dash-at-end-", "this-is-end-too"));
        System.out.println(sameDashes("012345678901-", "0--"));
    }
}