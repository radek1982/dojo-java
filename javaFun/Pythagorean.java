public class Pythagorean {
    public double calculateHypotenouse(int legA, int legB) {
        
        return Math.sqrt(legA*legA + legB*legB); 
    }

    public static void main(String[] args) {
        
        Pythagorean p = new Pythagorean();
        System.out.println(p.calculateHypotenouse(3, 4));
    }
}