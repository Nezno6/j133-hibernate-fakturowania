package pl.sda.j133.hibernate.fakturowania;

import pl.sda.j133.hibernate.fakturowania.komenda.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //new DataAccessObject<Firma>().findAll(Firma.class);
        List<Komenda> listaKomend = List.of(
                new KomendaDodajFirme(),
                new KomendaDodajFaktura(),
                new KomendaDodajKontrachent(),

                new KomendaListaFirma(),
                new KomendaListaFaktura(),
                new KomendaListaKontrachent(),

                new KomendaUsunFirma(),
                new KomendaUsunFaktura(),
                new KomendaUsunKontrachenta()
        );

        String komenda;
        do {
            System.out.println("Lista dostepnych komend:");
            for (int i = 0; i < listaKomend.size(); i++) {
                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
            }
            System.out.println("exit");
            System.out.println();

            System.out.println("Podaj komende:");
            komenda = Komenda.SCANNER.nextLine();

            for (Komenda dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda)) {
                    dostepnaKomenda.obsluga();
                }
            }
        } while (!komenda.equalsIgnoreCase("exit"));
    }
}
