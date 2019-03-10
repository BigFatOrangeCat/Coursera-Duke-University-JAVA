public class Part2 {
    private int howMany(String stringa, String stringb){
        int startIndex = 0;
        int count = 0;
        int currIndex = 0;
        while (currIndex != -1) {
            currIndex = stringb.indexOf(stringa, startIndex);
            if (currIndex != -1) {
                count = count + 1;
            }
            startIndex = currIndex + stringa.length();
        }
        return count;
    }

    private void testHowMany(){
        int result = howMany("GAA","ATGAACGAATTGAATC");
        System.out.println(result);
        result = howMany("AA","ATAAAA");
        System.out.println(result);
    }

    public static void main(String[] args){
        Part2 test = new Part2();
        test.testHowMany();
    }

}