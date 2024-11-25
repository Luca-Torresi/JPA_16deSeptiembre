import Entidades.Articulo;
import Entidades.Imagen;
import Entidades.Promocion;
import Entidades.UnidadMedida;
import Enumeraciones.TipoPromocion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            //UNIDADES DE MEDIDA
            UnidadMedida ochoPorciones = UnidadMedida.builder()
                    .denominacion("8 porciones")
                    .build();
            UnidadMedida cuatroPorciones = UnidadMedida.builder()
                    .denominacion("4 porciones")
                    .build();
            UnidadMedida litro = UnidadMedida.builder()
                    .denominacion("1 litro")
                    .build();

            //IMÁGENES
            Imagen imagen1 = Imagen.builder()
                    .denominacion("Pizza Grande Hawaiana")
                    .build();
            Imagen imagen2 = Imagen.builder()
                    .denominacion("Pizza Grande Napolitana")
                    .build();
            Imagen imagen3 = Imagen.builder()
                    .denominacion("Pizza Grande Muzzarella")
                    .build();
            Imagen imagen4 = Imagen.builder()
                    .denominacion("Pizza Chica Hawaiana")
                    .build();
            Imagen imagen5 = Imagen.builder()
                    .denominacion("Pizza Chica Napolitana")
                    .build();
            Imagen imagen6 = Imagen.builder()
                    .denominacion("Pizza Chica Muzzarella")
                    .build();
            Imagen imagen7 = Imagen.builder()
                    .denominacion("Cerveza Andes")
                    .build();
            Imagen imagen8 = Imagen.builder()
                    .denominacion("Cerveza Quilmes")
                    .build();

            //ARTÍCULOS
            Articulo hawaianaGrande = Articulo.builder()
                    .denominacion("Pizza Grande Hawaiana")
                    .imagen(imagen1)
                    .unidadMedida(ochoPorciones)
                    .precioVenta(7000.0)
                    .build();
            Articulo napolitanaGrande = Articulo.builder()
                    .denominacion("Pizza Grande Napolitana")
                    .imagen(imagen2)
                    .unidadMedida(ochoPorciones)
                    .precioVenta(7500.0)
                    .build();
            Articulo muzzarellaGrande = Articulo.builder()
                    .denominacion("Pizza Grande Muzzarella")
                    .imagen(imagen3)
                    .unidadMedida(ochoPorciones)
                    .precioVenta(8100.0)
                    .build();
            Articulo hawainanaChica = Articulo.builder()
                    .denominacion("Pizza Chica Hawaiana")
                    .imagen(imagen4)
                    .unidadMedida(cuatroPorciones)
                    .precioVenta(3600.0)
                    .build();
            Articulo napolitanaChica = Articulo.builder()
                    .denominacion("Pizza Chica Napolitana")
                    .imagen(imagen5)
                    .unidadMedida(cuatroPorciones)
                    .precioVenta(3900.0)
                    .build();
            Articulo muzzarellaChica = Articulo.builder()
                    .denominacion("Pizza Chica Muzzarella")
                    .imagen(imagen6)
                    .unidadMedida(cuatroPorciones)
                    .precioVenta(4200.0)
                    .build();
            Articulo cervezaAndes = Articulo.builder()
                    .denominacion("Cerveza Andes")
                    .imagen(imagen7)
                    .unidadMedida(litro)
                    .precioVenta(1000.0)
                    .build();
            Articulo cervezaQuilmes = Articulo.builder()
                    .denominacion("Cerveza Quilmes")
                    .imagen(imagen8)
                    .unidadMedida(litro)
                    .precioVenta(1000.0)
                    .build();

            //PROMOCIONES
            Set<Articulo> happyHourArticulos = new HashSet<>();
            happyHourArticulos.add(hawaianaGrande);
            happyHourArticulos.add(muzzarellaGrande);
            happyHourArticulos.add(cervezaQuilmes);

            Promocion happyHour = Promocion.builder()
                    .denominacion("Happy Hour")
                    .tipoPromocion(TipoPromocion.HAPPY_HOUR)
                    .articulos(happyHourArticulos)
                    .fechaDesde(LocalDate.parse("2024-01-01"))
                    .fechaHasta(LocalDate.parse("2025-12-31"))
                    .horaDesde(LocalTime.of(19,00))
                    .horaHasta(LocalTime.of(21,00))
                    .build();

            Set<Articulo> veranoArticulos = new HashSet<>();
            veranoArticulos.add(napolitanaGrande);
            veranoArticulos.add(hawainanaChica);
            veranoArticulos.add(cervezaAndes);
            veranoArticulos.add(cervezaQuilmes);

            Promocion verano = Promocion.builder()
                    .denominacion("Verano")
                    .tipoPromocion(TipoPromocion.VERANO)
                    .articulos(veranoArticulos)
                    .fechaDesde(LocalDate.parse("2024-12-21"))
                    .fechaHasta(LocalDate.parse("2025-03-21"))
                    .horaDesde(LocalTime.of(18,00))
                    .horaHasta(LocalTime.of(23,59))
                    .build();

            Set<Articulo> inviernoArticulos = new HashSet<>();
            inviernoArticulos.add(hawaianaGrande);
            inviernoArticulos.add(muzzarellaChica);
            inviernoArticulos.add(cervezaQuilmes);

            Promocion invierno = Promocion.builder()
                    .denominacion("Invierno")
                    .tipoPromocion(TipoPromocion.INVIERNO)
                    .articulos(inviernoArticulos)
                    .fechaDesde(LocalDate.parse("2024-06-21"))
                    .fechaHasta(LocalDate.parse("2024-09-21"))
                    .horaDesde(LocalTime.of(17,30))
                    .horaHasta(LocalTime.of(22,30))
                    .build();

            /*
            hawaianaGrande.getPromociones().add(happyHour);
            muzzarellaChica.getPromociones().add(happyHour);
            cervezaAndes.getPromociones().add(happyHour);
            napolitanaChica.getPromociones().add(verano);
            hawainanaChica.getPromociones().add(verano);
            cervezaAndes.getPromociones().add(verano);
            cervezaQuilmes.getPromociones().add(verano);
            hawainanaChica.getPromociones().add(invierno);
            muzzarellaChica.getPromociones().add(invierno);
            cervezaQuilmes.getPromociones().add(invierno);
            */

            em.persist(happyHour);
            em.persist(verano);
            em.persist(invierno);

            em.getTransaction().commit();

        } catch(Exception e){
            em.getTransaction().rollback();

            System.out.println("Hubo un error");
        }

        System.out.println("----- PROMOCIONES -----");
        Promocion happyHour = em.find(Promocion.class,1L);
        Promocion verano = em.find(Promocion.class,2L);
        Promocion invierno = em.find(Promocion.class,3L);
        System.out.println(happyHour);
        System.out.println(verano);
        System.out.println(invierno);

        System.out.println("----- ARTÍCULOS -----");
        List<Articulo> articulos = em.createQuery("SELECT a FROM Articulo a", Articulo.class).getResultList();
        articulos.forEach(System.out::println);


    }
}
