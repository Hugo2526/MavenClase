package Entidades;

import lombok.Getter;

import java.util.*;

@Getter
public class Personaje {

    private String nombre;
    private Map<String, Item> inventario;
    private Map<TipoEquipamiento, Item> equipo;

    public Personaje(String nombre) {
        this.nombre = nombre;
        inventario = new HashMap<>();
        this.equipo = new TreeMap<>();
    }

    public void agregarItemInventario(Item item){
        this.inventario.put(item.getNombre(), item);
    }

    public void eliminarItemInventario(String nombreitem){
        this.inventario.remove(nombreitem);
    }

    /**
     * Devuelve lista con los items del invenatio del personaje
     * @return
     */
    public List<Item> getInventario(){
        return new ArrayList<>(inventario.values());
    }

    /**
     * Busca item por su nombre
     * @param nombreitem
     * @return item o null
     */
    public Item buscarItem(String nombreitem){
        return inventario.get(nombreitem);
    }

    public void agregarEquipo(TipoEquipamiento tipoEquipamiento, Item item){
        //Verificar que el item no este ya en el equipo
        if (equipo.containsKey(tipoEquipamiento)){
            //Mover item al inventario
            Item antiguo = equipo.get(tipoEquipamiento);
            inventario.put(antiguo.getNombre(), antiguo);
        }
        //Poner el nuevo
        //ToDo - Habria que comprobar TipoItem para ver si puedo ponerlo donde  corresponde
        equipo.put(tipoEquipamiento, item);
        //Eliminar el nuevo item del inventario
        inventario.remove(item.getNombre());
    }

    public void quitarEquipo(TipoEquipamiento tipoEquipamiento){
        Item item = equipo.get(tipoEquipamiento);
        equipo.remove(tipoEquipamiento);
        inventario.put(item.getNombre(), item);
    }

    public List<Map.Entry<TipoEquipamiento, Item>> getEquipo(){
        return new ArrayList<>(equipo.entrySet());
    }


}
