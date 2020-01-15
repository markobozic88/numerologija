public class OsobaJMBG extends Osoba {

    private String jmbg;

    OsobaJMBG(Osoba o, String jmbg) {
        super(o);
        this.setJmbg(jmbg);
    }

    @Override
    public int numeroloskiBroj() {
        return 0;
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
