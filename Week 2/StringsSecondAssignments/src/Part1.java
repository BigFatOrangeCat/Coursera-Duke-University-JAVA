
public class Part1 {

    private int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            int distance = currIndex - startIndex;
            if (distance % 3 == 0) {
                return currIndex;
            } else {
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }

    private String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG",where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int minIndex = 0;
        if (taaIndex == -1 || (tagIndex != -1 && tagIndex < taaIndex)) {
            minIndex = tagIndex;
        }else{
            minIndex = taaIndex;
        }
        if (tgaIndex != -1 && tgaIndex < minIndex){
            minIndex = tgaIndex;
        }
        return dna.substring(startIndex,minIndex+3);
    }

    private void printAllGenes(){
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        int startIndex = 0;
        while (true) {
            String currGene = findGene(dna,startIndex);
            if (currGene.isEmpty()){
                break;
            }
            System.out.println(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
    }

    private void testFindStopCodon() {
        String dna = "AAAAAAAAATAAAAAAAAAAATAAAA";
        int dex = findStopCodon(dna,0,"TAA");
        System.out.println(dex);
        dex = findStopCodon(dna,6,"TAA");
        System.out.println(dex);
        dex = findStopCodon(dna,9,"TAA");
        System.out.println(dex);
        dex = findStopCodon(dna,10,"TAA");
        System.out.println(dex);
        dex = findStopCodon(dna,12,"TGA");
        System.out.println(dex);
        dna = "xxxxATG12345TAA1234567TAAxxx";
        String Gene = findGene(dna,0);
        System.out.println(Gene);
        dna = "xxxxATG12345TAA1234567TAGxxx";
        Gene = findGene(dna,0);
        System.out.println(Gene);
        dna = "xxxxATG12345TAA1234567TGAxxx";
        Gene = findGene(dna,0);
        System.out.println(Gene);

    }

    public static void main(String[] args){
          Part1 test = new Part1();
          test.testFindStopCodon();
          test.printAllGenes();
    }

}

