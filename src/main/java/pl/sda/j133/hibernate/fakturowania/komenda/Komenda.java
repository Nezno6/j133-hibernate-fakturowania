package pl.sda.j133.hibernate.fakturowania.komenda;

import java.util.List;
import java.util.Scanner;

public interface Komenda {
    Scanner SCANNER = new Scanner(System.in);

    String getKomenda();
    void obsluga();
}
