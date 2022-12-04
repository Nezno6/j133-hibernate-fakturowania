package pl.sda.j133.hibernate.fakturowania.komenda;

import pl.sda.j133.hibernate.fakturowania.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturowania.model.Kontrachent;

public class KomendaDodajKontrachent implements Komenda{
    private final DataAccessObject<Kontrachent> dao = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "dodaj kontrachent";
    }

    @Override
    public void obsluga() {

        System.out.println("Podaj nazwe kontrachenta: ");
        String nazwa = Komenda.SCANNER.nextLine();

        System.out.println("Podaj nip kontrachenta: ");
        String nip = Komenda.SCANNER.nextLine();

        System.out.println("Podaj adres kontrachenta: ");
        String adres = Komenda.SCANNER.nextLine();

        Kontrachent kontrachent = Kontrachent
                .builder()
                .adres(adres)
                .nazwa(nazwa)
                .nip(nip)
                .build();

        dao.insert(kontrachent);
    }
}
