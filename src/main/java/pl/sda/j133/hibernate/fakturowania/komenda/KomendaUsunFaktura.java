package pl.sda.j133.hibernate.fakturowania.komenda;

import pl.sda.j133.hibernate.fakturowania.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturowania.model.Faktura;

public class KomendaUsunFaktura implements Komenda{
    private final DataAccessObject<Faktura> dataAccessObject;

    public KomendaUsunFaktura() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun faktura";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanej faktury: ");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Faktura.class, id)) {
            System.out.println("Usunieto fakture");
        } else {
            System.err.println("Nie udalo sie usunac faktury");
        }
    }
}
