package lw01.prelab;

public class MonoPrint extends PrintJob {
    private int ratePerPage = 500;
 
    public MonoPrint(String id, int pages) {
        super(id, pages);
    }
 
    public int hitungBiaya() {
        return getPages() * ratePerPage;
    }
 
    public String label() {
        return "Mono";
    }
}
 