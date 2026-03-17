package Entidades;


import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode (of = "nombre")

public class Item {

    private String nombre;
    private String descripcion;
    private int nivelRequerido;
    private TipoItem tipo;
}
