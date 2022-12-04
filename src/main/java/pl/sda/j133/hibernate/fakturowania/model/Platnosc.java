package pl.sda.j133.hibernate.fakturowania.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Platnosc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Integer id;

    private Double kwota;

    @Enumerated(EnumType.STRING)
    private FormaPlatnosci formaPlatnosci;

    @CreationTimestamp
    private LocalDate dataRealizacji;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Faktura faktura;
}

