public class OsobaJMBG extends Osoba {
    private String jmbg;
    public OsobaJMBG(String ime, String prezime, String adresaStanovanja, String jmbg) {
        super(ime, prezime, adresaStanovanja);
        this.setJmbg(jmbg);
    }
    public OsobaJMBG(final OsobaJMBG ojmbg){
        super(ojmbg.getIme(), ojmbg.getPrezime(), ojmbg.getAdresaStanovanja());
        this.setJmbg(ojmbg.getJmbg());
    }
    public static boolean ispravanJmbg(String jmbg){
        if (jmbg.length() != 13){
            System.out.println("Neispravno unet JMBG - neispravna duzina JMBG-a (JMBG je broj od 13 cifara)");
            return false;
        }
        for (int i = 0; i < jmbg.length(); i++){
            if (!Character.isDigit(jmbg.charAt(i))){
                System.out.println("Neispravno unet JMBG - JMBG se sastoji samo od brojeva");
                return false;
            }
        }
        int dan = Integer.parseInt(jmbg.substring(0,2));
        int mesec = Integer.parseInt(jmbg.substring(2,4));
        int godina = Integer.parseInt(jmbg.substring(4,7)) + 1000;
        if (Datum.ispravanDatum(dan, mesec, godina)){
            System.out.println("Neispravno unet JMBG - dan, mesec ili godina u JMBG-u neispravno uneto");
            return false;
        }
        return true;
    }
    @Override
    public int numeroloskiBroj() {
        int zbir = 0;
        for (int i = 0; i < 7; i++){
            zbir += jmbg.charAt(i) - '0';
        }
        zbir += 1; //zbog toga sto nemamo 1 na pocetku kod godine u jmbg-u
        while (zbir > 9){
            zbir = zbirBrojeva(zbir);
        }
        return zbir;
    }
    @Override
    public String metabolizam(Datum d) {
        return null;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    @Override
    public String toString() {
        return super.toString() + "JMBG: " + getJmbg() + "\n";
    }
}
