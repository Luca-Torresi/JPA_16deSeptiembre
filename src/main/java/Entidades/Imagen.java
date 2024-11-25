package Entidades;

import lombok.*;

import javax.persistence.*;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table
public class Imagen {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;

    @OneToOne(mappedBy = "imagen")
    private Articulo articulo;
}
