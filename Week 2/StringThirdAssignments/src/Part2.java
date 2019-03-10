public class Part2 {

    private float cgRatio(String dna) {
        int currIndex = 0;
        int count = 0;
        float length = dna.length();
        while (currIndex != -1) {
            currIndex = dna.indexOf("C", currIndex);
            if(currIndex == -1){
                break;
            }
            count += 1;
            currIndex += 1;
        }
        currIndex = 0;
        while (currIndex != -1) {
            currIndex = dna.indexOf("G", currIndex);
            if(currIndex == -1){
                break;
            }
            count += 1;
            currIndex += 1;
        }
        return count / length;
    }

    private int countCTG(String dna) {
        int currIndex = 0;
        int count = 0;
        while (currIndex != -1) {
            currIndex = dna.indexOf("CTG", currIndex);
            if(currIndex == -1){
                break;
            }
            count += 1;
            currIndex = currIndex + 3;
        }
        return count;
    }

    private void testcgRatio(){
        String dna = "ATGCCATAG";
        float count = cgRatio(dna);
        System.out.println(count);
    }

    private void testcountCTG(){
        String dna = "ATGCTGCTGCTGTAA";
        int count = countCTG(dna);
        System.out.println(count);
        }
    public static void  main(String[] args){
        Part2 test = new Part2();
        test.testcgRatio();
        test.testcountCTG();
    }

}