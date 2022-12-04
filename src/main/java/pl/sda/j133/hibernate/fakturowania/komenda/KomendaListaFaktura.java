package pl.sda.j133.hibernate.fakturowania.komenda;

import pl.sda.j133.hibernate.fakturowania.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturowania.model.Faktura;

import java.util.List;

public class KomendaListaFaktura implements Komenda{
    private final DataAccessObject<Faktura> dataAccessObject;

    public KomendaListaFaktura() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista faktura";
    }

    @Override
    public void obsluga() {
        List<Faktura> faktury = dataAccessObject.findAll(Faktura.class);
        faktury.forEach(System.out::println);
    }
}
