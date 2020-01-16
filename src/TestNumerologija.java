import java.util.Scanner;
public class TestNumerologija {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Broj osoba: ");
        int brOsoba = scanner.nextInt();
        Osoba[] nizOsoba = new Osoba[brOsoba];
        for (int i=0; i<brOsoba; i++){
            System.out.println("Unesite ime " + (i+1) + ". osobe");
            String unetoIme = scanner.next();
            System.out.println("Unesite prezime " + (i+1) + ". osobe");
            String unetoPrezime = scanner.next();
            System.out.println("Unesite adresu stanovanja " + (i+1) + ". osobe");
            String unetaAdresa = scanner.next();
            System.out.println("1-datum rodjenja\t2-JMBG");
            int drOrJmbg = scanner.nextInt();
            switch (drOrJmbg){
                case 1:
                    System.out.println("Unesite datum rodjenja (dd.mm.gggg.):");
                    String dr = scanner.next();
                    Datum dt = Datum.stringToDatum(dr);
                    if (dt == null){
                        i--;
                        break;
                    }
                    nizOsoba[i] = new OsobaD(unetoIme, unetoPrezime, unetaAdresa, dt);
                    break;
                case 2:
                    System.out.println("Unesite JMBG:");
                    String jmbg = scanner.next();
                    if (OsobaJMBG.ispravanJmbg(jmbg)){
                        nizOsoba[i] = new OsobaJMBG(unetoIme, unetoPrezime, unetaAdresa, jmbg);
                        break;
                    }
                    System.out.println("Niste ispravno uneli JMBG");
                    i--;
                    break;
                default:
                    System.out.println("Neispravna opcija! Unesite 1 za datum rodjenja ili 2 za JMBG");
                    i--;
                    break;
            }
        }
        Datum danasnjiDatum = null;
        while (danasnjiDatum == null){
            System.out.println("Danasnji datum: ");
            String danasnjiDatumString = scanner.next();
            danasnjiDatum = Datum.stringToDatum(danasnjiDatumString);
        }
        System.out.println("Rezultati:");
        for (int j = 0; j < brOsoba; j++){
            if (nizOsoba[j].numeroloskiBroj() != 7 && !nizOsoba[j].metabolizam(danasnjiDatum).contains("0")){
                System.out.println((j + 1) + ". osoba: \n" + nizOsoba[j] + "\nMetabolizam: " + nizOsoba[j].metabolizam(danasnjiDatum));
            }
        }
    }
}
