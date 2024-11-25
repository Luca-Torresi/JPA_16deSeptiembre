package Entidades;

import Enumeraciones.TipoPromocion;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data @Builder @AllArgsConstructor @NoArgsConstructor @ToString
@Entity @Table
public class Promocion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta;
    private LocalTime horaDesde;
    private LocalTime horaHasta;
    private String descripcionDescuento;
    private Double precioPromocional;
    private TipoPromocion tipoPromocion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "promocion_articulo",
            joinColumns = @JoinColumn(name = "idPromocion"),
            inverseJoinColumns = @JoinColumn(name = "idArticulo"))
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();
}
