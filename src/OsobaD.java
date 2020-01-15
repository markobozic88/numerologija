public class OsobaD extends Osoba {
    private Datum datumRodjenja;
    public OsobaD(String ime, String prezime, String adresaStanovanja, Datum datum) {
        super(ime, prezime, adresaStanovanja);
        setDatumRodjenja(new Datum(datum));
    }
    public OsobaD(final OsobaD od) {
        super(od.getIme(), od.getPrezime(), od.getAdresaStanovanja());
        setDatumRodjenja(new Datum(od.getDatumRodjenja()));
    }
    @Override
    public int numeroloskiBroj() {
        int ukupanZbir = zbirBrojeva(getDatumRodjenja().getDan()) + zbirBrojeva(getDatumRodjenja().getMesec()) +
                zbirBrojeva(getDatumRodjenja().getGodina());
        while (ukupanZbir > 9) {
            ukupanZbir = zbirBrojeva(ukupanZbir);
        }
        return ukupanZbir;
    }
    @Override
    public String metabolizam(Datum d) {
        int zbirMetabolizam = (getDatumRodjenja().getDan() + d.getDan()) * 1000000 +
                (getDatumRodjenja().getMesec() + d.getMesec()) * 10000 +
                getDatumRodjenja().getGodina() + d.getGodina();
        String stringZbirMetabolizam = String.valueOf(zbirMetabolizam);
        if (stringZbirMetabolizam.length() == 7) {
            stringZbirMetabolizam = "0" + stringZbirMetabolizam;
        }
        return stringZbirMetabolizam;
    }
    public Datum getDatumRodjenja() {
        return datumRodjenja;
    }
    public void setDatumRodjenja(Datum datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }
    @Override
    public String toString() {
        return super.toString() + "Datum rodjenja: " + getDatumRodjenja() + "\nNumeroloski broj: " + numeroloskiBroj();
    }


}
