
/**
 * 在这里给出对类 Part3 的描述。
 * 
 * @JIANG Jichen
 * @08/03/2019
 */
public class Part3 {
    public boolean twoOccurrences (String stringa, String stringb){
        int count = 0;
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = stringb.indexOf(stringa, lastIndex);
            System.out.println(lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += stringa.length();
            }
        }
        if (count > 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public String lastPart (String stringa, String stringb){
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = stringb.indexOf(stringa, lastIndex);
            System.out.println(lastIndex);
            if (lastIndex > 0) {
                stringb = stringb.substring(lastIndex+stringa.length());
                return stringb;
            }
        }
        return stringb;
    }
    public void testing() {
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgatgta"));
        System.out.println(lastPart("an", "banana"));
        System.out.println(lastPart("zoo", "forest"));
    }
}