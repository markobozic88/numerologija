public abstract class Osoba {
    private String ime;
    private String prezime;
    private String adresaStanovanja;
    Osoba(String ime, String prezime, String adresaStanovanja){
        this.setIme(ime);
        this.setPrezime(prezime);
        this.setAdresaStanovanja(adresaStanovanja);
    }
    Osoba(Osoba o){
        this.setIme(o.getIme());
        this.setPrezime(o.getPrezime());
        this.setAdresaStanovanja(o.getAdresaStanovanja());
    }
    public abstract int numeroloskiBroj();
    public abstract String metabolizam(final Datum d);
    int zbirBrojeva(int br){
        int zb = 0;
        while (br != 0){
            zb += br % 10;
            br /= 10;
        }
        return zb;
    }
    public String getIme() {
        return ime;
    }
    public void setIme(String ime) {
        this.ime = ime;
    }
    public String getPrezime() {
        return prezime;
    }
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public String getAdresaStanovanja() {
        return adresaStanovanja;
    }
    public void setAdresaStanovanja(String adresaStanovanja) {
        this.adresaStanovanja = adresaStanovanja;
    }
    @Override
    public String toString() {
        return "Ime: " + getIme() + "\nPrezime: " + getPrezime() + "\nAdresa: " + getAdresaStanovanja() + "\n";
    }
}
