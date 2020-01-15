import java.util.Scanner;

public class TestNumerologija {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Broj osoba: ");
        int brOsoba = scanner.nextInt();
        Osoba nizOsoba[] = new Osoba[brOsoba];
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

                    //Osoba osobaJMBG = new OsobaJMBG(new Osoba(unetoIme, unetoPrezime, unetaAdresa), jmbg);

                    //nizOsoba[i] = osobaJMBG;
                    break;
            }


        }

        System.out.println("Danasnji datum: ");
        String danasnjiDatum = scanner.next();






    }
}
