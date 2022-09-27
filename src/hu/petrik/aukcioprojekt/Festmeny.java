package hu.petrik.aukcioprojekt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Festmeny {

    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama;
    private int legmagasabbLicit;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt;


    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
        this.licitekSzama = 0;
        this.legmagasabbLicit = 0;
        this.legutolsoLicitIdeje = null;
        this.elkelt = false;

    }

    public String getCim() {
        return cim;
    }

    public String getFesto() {
        return festo;
    }

    public String getStilus() {
        return stilus;
    }

    public int getLicitekSzama() {
        return licitekSzama;
    }

    public int getLegmagasabbLicit() {
        return legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return legutolsoLicitIdeje;
    }

    public boolean isElkelt() {
        return elkelt;
    }

    public void setElkelt(boolean elkelt) {
        this.elkelt = elkelt;
    }

    public void licit() {
       this.licit(10);
    }
    private int getKerekitettLicitMatematikaiMuveletekkel(int ujLicit)
    {
        int osztasokSzama = 0;
        while  (ujLicit > 100)
        {
            osztasokSzama++;
            ujLicit /=10;


        }
        ujLicit *= Math.pow(10, osztasokSzama);
        return ujLicit;
    }

    private int getKerekitettLicitSzoveggeAlakitassal(int ujlicit) {
        String szovegesLicit = String.valueOf(ujlicit);
        int hossz = szovegesLicit.length();
        StringBuilder veglegeslicit = new StringBuilder(szovegesLicit.substring(0, 2));
        veglegeslicit.append("0".repeat(hossz - 2));
        int veglegesLicitOsszeg = Integer.parseInt(veglegeslicit.toString());
        return veglegesLicitOsszeg;
    }

    public void licit(int mertek) {
        if (mertek < 10 || mertek > 100)
        {
            throw new IllegalArgumentException("A licit mértéke 10 és 100% közötti kell hogy legyen");
        }

        if (this.elkelt) {
            throw new RuntimeException("A festmény már elkelt");
        }
        if (this.licitekSzama == 0) {
            this.legmagasabbLicit = 100;
        } else {
            int ujlicit = this.legmagasabbLicit * (100 + mertek) / 100;
            int veglegesLicitOsszeg = getKerekitettLicitSzoveggeAlakitassal(ujlicit);
            this.legmagasabbLicit = veglegesLicitOsszeg;
        }
        this.licitekSzama++;
        this.legutolsoLicitIdeje = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatum =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = String.format("%s: %s (%s)", this.festo, this.cim, this.stilus);
        if (this.licitekSzama>0)
        {
           s = String.format("%s: %s (%s)\n" +
                    "%s" +
                    "%d $ - %s (összesen: %d db)\n", this.festo, this.cim, this.stilus,this.elkelt ? "elkelt\n" : "nem kelt el", this.legmagasabbLicit, this.legutolsoLicitIdeje.format(formatum), this.licitekSzama);
        }
        return s;
    }





}
