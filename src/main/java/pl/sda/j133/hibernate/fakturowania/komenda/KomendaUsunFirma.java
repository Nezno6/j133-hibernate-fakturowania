package pl.sda.j133.hibernate.fakturowania.komenda;

import pl.sda.j133.hibernate.fakturowania.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturowania.model.Firma;

public class KomendaUsunFirma implements Komenda{
    private final DataAccessObject<Firma> dataAccessObject;

    public KomendaUsunFirma() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun firma";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanej firmy: ");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Firma.class, id)) {
            System.out.println("Usunieto Firme");
        } else {
            System.err.println("Nie udalo sie usunac firmy");
        }
    }
}
