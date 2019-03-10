
/**
 * 在这里给出对类 Part1 的描述。
 * 
 * @JIANG Jichen
 * @08/03/2019
 */
public class Part1 {
    public String findSimpleGene(String dna){
        int startCodon = dna.indexOf("ATG");
        if (startCodon == -1){
            return "";
        }
        int firstStopCodon = dna.indexOf("TAA",startCodon+3);
        if (firstStopCodon == -1){
            return "";
        }
        String result = dna.substring(startCodon,firstStopCodon+3);
        if (result.length() % 3 == 0 ){
            return result;
        }else{
            return "It's not a correct Gene";
        }
    }

    public void testSimpleGene(){
        String dna = "TTGTGAAGGGAAGTATAA";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATGTGGTGGTGGTGG";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "TGGTGGTGGTGG";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATGTGGTGGTGGTGGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATGTGGTGGTGGTGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }
}