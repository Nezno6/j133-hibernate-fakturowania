package pl.sda.j133.hibernate.fakturowania.komenda;

import pl.sda.j133.hibernate.fakturowania.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturowania.model.Firma;
import pl.sda.j133.hibernate.fakturowania.model.Kontrachent;

import java.util.List;

public class KomendaListaKontrachent implements Komenda{
    private final DataAccessObject<Kontrachent> dataAccessObject;

    public KomendaListaKontrachent() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista kontrachent";
    }

    @Override
    public void obsluga() {
        List<Kontrachent> kontrachenci = dataAccessObject.findAll(Kontrachent.class);
        kontrachenci.forEach(System.out::println);
    }
}
