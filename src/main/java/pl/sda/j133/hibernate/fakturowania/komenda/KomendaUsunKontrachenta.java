package pl.sda.j133.hibernate.fakturowania.komenda;

import pl.sda.j133.hibernate.fakturowania.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturowania.model.Kontrachent;

public class KomendaUsunKontrachenta implements Komenda{
    private final DataAccessObject<Kontrachent> dataAccessObject;

    public KomendaUsunKontrachenta() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun kontrachenta";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego kontrachenta: ");
        String idString = Komenda.SCANNER.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(Kontrachent.class, id)) {
            System.out.println("Usunieto Kontrachenta");
        } else {
            System.err.println("Nie udalo sie usunac Kontrachenta");
        }
    }
}
