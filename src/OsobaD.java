public class OsobaD extends Osoba {

    private Datum datumRodjenja;

    public OsobaD(String ime, String prezime, String adresaStanovanja, Datum datum) {
        super(ime, prezime, adresaStanovanja);
        datumRodjenja = new Datum(datum);
    }

    public OsobaD(final OsobaD o){
        super(o.getIme(), o.getPrezime(), o.getAdresaStanovanja());
        datumRodjenja = new Datum(o.datumRodjenja);
    }

    @Override
    public int numeroloskiBroj() {
        int ukupanZbir = zbir(datumRodjenja.getDan()) + zbir(datumRodjenja.getMesec()) + zbir(datumRodjenja.getGodina());

        while (ukupanZbir > 9){
            ukupanZbir = zbir(ukupanZbir);
        }
        return ukupanZbir;
    }

    @Override
    public String metabolizam(Datum d) {
        return null;
    }

    public Datum getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Datum datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String toString() {
        return super.toString() + "Datum rodjenja: " + getDatumRodjenja() + "\n";
    }
}
