package pl.sda.j133.hibernate.fakturowania.komenda;

import pl.sda.j133.hibernate.fakturowania.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturowania.model.Faktura;
import pl.sda.j133.hibernate.fakturowania.model.Firma;
import pl.sda.j133.hibernate.fakturowania.model.Kontrachent;

import java.time.LocalDate;
import java.util.Optional;

public class KomendaDodajFaktura implements Komenda{
    private final DataAccessObject<Kontrachent> dataAccessObjectKontrachent;
    private final DataAccessObject<Firma> dataAccessObjectFirma;
    private final DataAccessObject<Faktura> dataAccessObject;


    public KomendaDodajFaktura() {
        this.dataAccessObject = new DataAccessObject<>();
        this.dataAccessObjectFirma = new DataAccessObject<>();
        this.dataAccessObjectKontrachent = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj faktura";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id firmy");
        String idString = Komenda.SCANNER.nextLine();
        Long idFirma = Long.parseLong(idString);

        Optional<Firma> firmaOptional = dataAccessObjectFirma.find(Firma.class, idFirma);
        if (firmaOptional.isEmpty()) {
            System.err.println("Firma nie istnieje");
            return;
        }

        System.out.println("Podaj id kontrachenta");
        String idKontrachentString = Komenda.SCANNER.nextLine();
        Long idKontrachent = Long.parseLong(idKontrachentString);

        Optional<Kontrachent> kontrachentOptional = dataAccessObjectKontrachent.find(Kontrachent.class, idKontrachent);
        if (kontrachentOptional.isEmpty()) {
            System.err.println("Kontrachent nie istnieje");
            return;
        }

        System.out.println("Podaj numer faktury:");
        String numerFaktury = Komenda.SCANNER.nextLine();

        System.out.println("Podaj termin platnosci faktury:");
        String terminFaktury = Komenda.SCANNER.nextLine();

        System.out.println("Podaj kwota faktury:");
        String kwotaFaktury = Komenda.SCANNER.nextLine();

        Faktura faktura = Faktura
                .builder()
                .numerFaktury(numerFaktury)
                .dataWystawienia(LocalDate.now())
                .firma(firmaOptional.get())
                .kontrachent(kontrachentOptional.get())
                .terminPlatnosci(LocalDate.parse(terminFaktury))
                .kwota(Double.valueOf(kwotaFaktury))
                .build();

        dataAccessObject.insert(faktura);
        System.out.println("Dodano fakture");
    }
}
