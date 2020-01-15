public class Datum {
    private int dan;
    private int mesec;
    private int godina;
    public Datum(int dan, int mesec, int godina){
        this.setDan(dan);
        this.setMesec(mesec);
        this.setGodina(godina);
    }
    public Datum(final Datum d){
        this.setDan(d.getDan());
        this.setMesec(d.getMesec());
        this.setGodina(d.getGodina());
    }
    public static int prestupnaGodina(int god){
        if (god % 400 == 0 || god % 4 == 0 && god % 100 != 0){
            return 1;
        } else {
            return 0;
        }
    }
    public static int daniMesec(int mesec, int godina){
        switch (mesec){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return 28 + prestupnaGodina(godina);
            default:
                return 0;
        }
    }
    public static boolean ispravanDatum(int d, int m, int g){
        return (d >= 1 && d <= daniMesec(m, g)) && (m >= 1 && m <= 12) && g > 1950;
    }
    public static Datum stringToDatum(String stringDatum){
        if (stringDatum.length() != 11){
            System.out.println("Neispravno unet datum - duzina datuma neispravna");
            return null;
        }
        if (stringDatum.charAt(2) != '.' || stringDatum.charAt(5) != '.' || stringDatum.charAt(10) != '.'){
            System.out.println("Neispravno unet datum - neispravan format datuma");
            return null;
        }
        int danDatum = 0; int mesecDatum = 0; int godinaDatum = 0;
        try {
            danDatum = Integer.parseInt(stringDatum.substring(0, 2));
            mesecDatum = Integer.parseInt(stringDatum.substring(3, 5));
            godinaDatum = Integer.parseInt(stringDatum.substring(6, 10));
        } catch (NumberFormatException e){
            System.out.println("Neispravno unet datum - neispravan format datuma");
            return null;
        }
        if (Datum.ispravanDatum(danDatum, mesecDatum, godinaDatum)){
            return new Datum(danDatum, mesecDatum, godinaDatum);
        } else {
            System.out.println("Neispravno unet datum - dan, mesec ili godina nisu ispravno uneti");
            return null;
        }
    }
    public int getDan() {
        return dan;
    }
    public void setDan(int dan) {
        this.dan = dan;
    }
    public int getMesec() {
        return mesec;
    }
    public void setMesec(int mesec) {
        this.mesec = mesec;
    }
    public int getGodina() {
        return godina;
    }
    public void setGodina(int godina) {
        this.godina = godina;
    }
    @Override
    public String toString() {
        String stringDan = (getDan() < 10) ? "0" + getDan() : "" + getDan();
        String stringMesec = (getMesec() < 10) ? "0" + getMesec() : "" + getMesec();
        return stringDan + "." + stringMesec + "." + getGodina() + ".";
    }
}
