package pl.sda.j133.hibernate.fakturowania.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Faktura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Integer id;

    @CreationTimestamp
    private LocalDate dataWystawienia;
    private String numerFaktury;
    private LocalDate terminPlatnosci;
    private Double kwota;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Firma firma;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Kontrachent kontrachent;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "faktura")
    private Set<Platnosc> platnosci;

}
