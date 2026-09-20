package lw01.prelab;

public class ColourPrint extends PrintJob {
    private int firstPages = 10;
    private int rateFirst = 1500;
    private int rateExtra = 1000;
    private int setupFee = 2000;
 
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }
 
    public int hitungBiaya() {
        int pages = getPages();
        int firstPart = Math.min(pages, firstPages);
        int extraPart = Math.max(0, pages - firstPages);
        return firstPart * rateFirst + extraPart * rateExtra + setupFee;
    }
 
    public String label() {
        return "Colour";
    }
}