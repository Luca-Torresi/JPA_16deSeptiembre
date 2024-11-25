package Entidades;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data @Builder @AllArgsConstructor @NoArgsConstructor @ToString(exclude = {"promociones","imagen"})
@Entity @Table
public class Articulo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private Double precioVenta;
    private Double precioCompra;
    private Integer stockActual;
    private Integer stockMaximo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUnidadMedida")
    private UnidadMedida unidadMedida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idImagen")
    private Imagen imagen;

    @ManyToMany(mappedBy = "articulos")
    @Builder.Default
    private Set<Promocion> promociones = new HashSet<>();
}
