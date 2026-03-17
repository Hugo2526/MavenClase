package app;

import Entidades.Item;
import Entidades.Personaje;
import Entidades.TipoEquipamiento;
import Entidades.TipoItem;

import java.util.Map;

public class app {
    static void main() {

        Personaje personaje = new Personaje("Pepe");
        personaje.agregarItemInventario(new Item("vara troncho", "una vara magica poderosa", 18, TipoItem.ARMA));
        personaje.agregarItemInventario(new Item("capa blanca", "una capa de mago", 7, TipoItem.ARMADURA));
        personaje.agregarItemInventario(new Item("vino del mercadona", "elixir de sabiduria", 1, TipoItem.CONSUMIBLE));
        personaje.agregarItemInventario(new Item("botas de flash", "unas botas para ir como un formula 1", 3, TipoItem.ARMADURA));


        personaje.agregarEquipo(TipoEquipamiento.MANO_PRINCIPAL, personaje.buscarItem("vara troncho"));
        personaje.agregarEquipo(TipoEquipamiento.PECHO, personaje.buscarItem("capa blanca"));

        IO.println("-----EQUIPO-----");
        for (Map.Entry<TipoEquipamiento, Item> entry : personaje.getEquipo()){
            IO.println(entry.getKey() + " -> " + entry.getValue());
        }


        IO.println("-----INVENTARIO-----");
        for (Item item : personaje.getInventario()){
            IO.println(item);
        }


    }
}
