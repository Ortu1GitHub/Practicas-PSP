package TiendaNueva;


public class Main {
    public static void main(String[] args) {

        Cliente lola=new Cliente("lola",new int[] {200,400,300,200});
        Cliente pepe =new Cliente("pepe",new int[]{200,200,500,200,300});

        long tiempoInicio=System.currentTimeMillis();

        //Se generan los objetos de tipo Runnable
        Runnable r1=new Dependienta("MARTA",lola,tiempoInicio);
        Runnable r2=new Dependienta("LORENA",pepe,tiempoInicio);

        //Se asignan a los objetos de tipo Thread
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);

        //Arrancan los hilos
        t1.start();
        t2.start();

    }
}