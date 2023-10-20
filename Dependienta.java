package TiendaNueva;

import java.util.ArrayList;

public class Dependienta implements Runnable{

    String nombre;
    Cliente cliente;
    long tiempoInicio;
    ArrayList <Long> tiemposCompraProducto =new ArrayList<Long>();

    public Dependienta(String nombre, Cliente cliente, long tiempoInicio){

        this.nombre=nombre;
        this.cliente=cliente;
        this.tiempoInicio=tiempoInicio;
    }

    public void run(){

            System.out.println("Depednienta "+nombre+" atendiendo a "+cliente.nombre);

            for(int i=0;i<cliente.getCompra().length;i++){

                try {
                    Thread.sleep(cliente.getCompra()[i]);

                    //se guarda el tiempo de compra de cada producto
                    tiemposCompraProducto.add((System.currentTimeMillis() - tiempoInicio));

                    System.out.println("PRODUCTO " + (i + 1) + " de cliente "+cliente.nombre+" pasa por caja en " + tiemposCompraProducto.get(i) + " ms ");


                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

            }

            System.out.println("COMPRA DEL CLIENTE "+cliente.nombre+" PROCESADA EN "+calculaTiempoCompra(tiemposCompraProducto)+" ms ");
    }

    public long calculaTiempoCompra(ArrayList <Long>  t){
        long res=0;
        for (int i=0; i<t.size();i++){
            res=res+t.get(i);
        }
        return (res);
    }

}