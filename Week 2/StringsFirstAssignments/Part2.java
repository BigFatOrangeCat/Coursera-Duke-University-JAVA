
/**
 * 在这里给出对类 Part2 的描述。
 * 
 * @JIANG Jichen
 * @08/03/2019
 */
public class Part2 {
    public String findSimpleGene(String dna){
        int startCodon = 0, firstStopCodon = 0;
        for (int i = 0; i<dna.length(); i++){
            if(Character.isUpperCase(dna.charAt(i))){ 
                startCodon = dna.indexOf("ATG");
                firstStopCodon = dna.indexOf("TAA",startCodon+3);
            }else{
                startCodon = dna.indexOf("atg");
                firstStopCodon = dna.indexOf("taa",startCodon+3);
            }
        }
        if (startCodon == -1){
            return "";
        }
        if (firstStopCodon == -1){
            return "";
        }
        String result = dna.substring(startCodon,firstStopCodon+3);
        if (result.length() % 3 == 0 ){
            return result;
        }else{
            return "";
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
        
        dna = "atgtggtggtggtggtaa";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATGTGGTGGTGGTGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
    }
}