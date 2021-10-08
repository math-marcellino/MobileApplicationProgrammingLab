package id.ac.umn.matthewmarcellino_00000036291_if570_el_uts;

import java.io.Serializable;

public class SumberSFX implements Serializable {
    private String title;
    private String kategori;
    private String SFX_URI;

    public SumberSFX(String title, String kategori, String SFX_URI){
        this.title = title;
        this.kategori = kategori;
        this.SFX_URI = SFX_URI;
    }

    public String getKategori() {
        return this.kategori;
    }

    public String getTitle() {
        return this.title;
    }

    public String getSFX_URI() {
        return this.SFX_URI;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setSFX_URI(String SFX_URI) {
        this.SFX_URI = SFX_URI;
    }

    public String toString() {
        return this.getTitle() + " => " + this.getKategori();
    }
}
