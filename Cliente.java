package TiendaNueva;

public class Cliente {

    public   int[] compra;
    public   String nombre;

    public Cliente(String nombre, int[] compra) {
        this.nombre=nombre;
        this.compra=compra;
    }

    public  int[] getCompra(){
        return compra;
    }

    public void setCompra(int [] compra){
        this.compra=compra;
    }


}
