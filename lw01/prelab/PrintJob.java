package lw01.prelab;

public abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;
 
    public PrintJob (String id, int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("halaman harus positif");
        }
        this.id = id;
        this.pages = pages;
    }
 
    public String getId() {
        return id;
    }
 
    public int getPages() {
        return pages;
    }
 
public int hitungBiaya(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("salinan harus positif");
        }
        return copies * hitungBiaya();
    }
  
    public String label() {
        return "Print";
    }
  
    public String summary() {
        return id + " | " + label() + " | " + hitungBiaya();
    }
}
 