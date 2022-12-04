package pl.sda.j133.hibernate.fakturowania.komenda;

import pl.sda.j133.hibernate.fakturowania.database.DataAccessObject;
import pl.sda.j133.hibernate.fakturowania.model.Firma;

import java.util.List;

public class KomendaListaFirma implements Komenda{
    private final DataAccessObject<Firma> dataAccessObject;

    public KomendaListaFirma() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista firma";
    }

    @Override
    public void obsluga() {
        List<Firma> firmy = dataAccessObject.findAll(Firma.class);
        firmy.forEach(System.out::println);
    }
}
