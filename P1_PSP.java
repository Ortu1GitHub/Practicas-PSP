package org.example;

import java.util.*;


public class P1_PSP {



    public static void main(String[] args) {

        int option;
        boolean loop=true;
        //loop=true;


        ArrayList<String> job1=new ArrayList <String>();
        ArrayList<String> job2=new ArrayList <String>();
        ArrayList<String> job3=new ArrayList <String>();

        ArrayList<String> res=new ArrayList <String>();

        int duration[]=new int[3];

        Scanner data=new Scanner(System.in);

        System.out.println("**********************");
        System.out.println("*** PRACTICA 1 PSP ***");
        System.out.println("**********************");


        for (int i=0; i<=2;i++) {

            System.out.println("Indique la duracion (longitud del array) del job "+(i+1)+" : ");

            duration[i]=data.nextInt();

            if(i==0) {
                //Se rellena el array list del job 1

                for (int j=1;j<=duration[i];j++) {
                    job1.add("A");
                }
            }

            if(i==1) {
                //Se rellena el array list del job 2

                for (int k=1;k<=duration[i];k++) {
                    job2.add("B");
                }
            }

            if(i==2) {
                //Se rellena el array list del job 3

                for (int l=1;l<=duration[i];l++) {
                    job3.add("C");
                }
            }

        }

        //Se imprimen los 3 jobs
        System.out.println("**********************");
        System.out.println("JOB 1: ");
        for (int m=0;m<job1.size();m++){
            System.out.println(job1.get(m));
        }
        System.out.println("JOB 2: ");
        for (int n=0;n<job2.size();n++){
            System.out.println(job2.get(n));
        }
        System.out.println("JOB 3: ");
        for (int o=0;o<job3.size();o++){
            System.out.println(job3.get(o));
        }

        while(loop) {
            System.out.println("Indique el algoritmo de ejecucion a considerar:");
            System.out.println("1. FCFS");
            System.out.println("2. SJF");
            System.out.println("3. Round Robin (tamaño ventana 1)");
            System.out.println("4. Salir ");

            option = data.nextInt();

            switch (option) {

                case 1:

                    res = FCFS(job1, job2, job3, duration);

                    break;

                case 2:

                    res = SJF(job1, job2, job3, duration);

                    break;

                case 3:

                    res = RR(job1, job2, job3, duration);

                    break;
                case 4:
                    loop = false;
                    return;

                default:

                    System.out.println("Opcion no reconocida..");
                    break;
            }


            System.out.println("El orden de ejecución seria :");
            for (int x = 0; x < res.size(); x++) {
                System.out.println(res.get(x));
            }
            System.out.println("Tiempo de ejecución del job 1: " + (devolverUltimaOcurrencia(res, "A") + 1) + " s ");
            System.out.println("Tiempo de ejecución del job 2: " + (devolverUltimaOcurrencia(res, "B") + 1) + " s ");
            System.out.println("Tiempo de ejecución del job 3: " + (devolverUltimaOcurrencia(res, "C") + 1) + " s ");

        }//while
    }

    private static int devolverUltimaOcurrencia(ArrayList<String> res, String cadena) {
        for (int i = res.size() - 1; i >= 0; i--) {
            if (res.get(i) .equals(cadena)) {
                // Devolver el índice de la última ocurrencia
                return i;
            }
        }
        return -1;
    }

    private static ArrayList  FCFS(ArrayList<String> job1, ArrayList<String> job2, ArrayList<String> job3,int duration[]) {
        ArrayList<String> res=new ArrayList <String>();
        for(int i=0;i<duration[0] ;i++){
            res.add(job1.get(i));
        }
        for(int j=0;j<duration[1] ;j++){
            res.add(job2.get(j));
        }
        for(int k=0;k<duration[2];k++){
            res.add(job3.get(k));
        }
        return (res);
    }

    private static ArrayList SJF(ArrayList<String> job1, ArrayList<String> job2, ArrayList<String> job3,int duration[]) {
        ArrayList<String> res=new ArrayList <String>();

        //Map para asociar las duraciones a los jbs
        Map<Integer, Integer> mapDurationsJobs = new HashMap<>();
        mapDurationsJobs.put(duration[0],1);
        mapDurationsJobs.put(duration[1],2);
        mapDurationsJobs.put(duration[2],3);

        //Se ordenan las duraciones por orden creciente
        int durationSorted[];
        durationSorted=duration;

        Arrays.sort(durationSorted);

        //Una vez ordenados se ejecuta cada job asociado a cada duracion
        int aux;
        aux=mapDurationsJobs.get(durationSorted[0]);
        if(aux==1){
            for(int i=0;i<job1.size() ;i++){
                res.add(job1.get(i));
            }
        }

        if(aux==2) {
            for (int i = 0; i < job2.size(); i++) {
                res.add(job2.get(i));
            }
        }

        if(aux==3) {
            for (int i = 0; i < job3.size(); i++) {
                res.add(job3.get(i));
            }
        }

        aux=mapDurationsJobs.get(durationSorted[1]);

        if(aux==1){
            for(int i=0;i<job1.size() ;i++){
                res.add(job1.get(i));
            }
        }

        if(aux==2) {
            for (int i = 0; i < job2.size(); i++) {
                res.add(job2.get(i));
            }
        }

        if(aux==3) {
            for (int i = 0; i < job3.size(); i++) {
                res.add(job3.get(i));
            }
        }

        aux=mapDurationsJobs.get(durationSorted[2]);

        if(aux==1){
            for(int i=0;i<job1.size() ;i++){
                res.add(job1.get(i));
            }
        }

        if(aux==2) {
            for (int i = 0; i < job2.size(); i++) {
                res.add(job2.get(i));
            }
        }

        if(aux==3) {
            for (int i = 0; i < job3.size(); i++) {
                res.add(job3.get(i));
            }
        }

        return (res);
    }

    private static ArrayList RR(ArrayList<String> job1, ArrayList<String> job2, ArrayList<String> job3,int duration[]) {
        ArrayList<String> res=new ArrayList <String>();

        //Se rellena res con un elemento de cada job mientras queden elementos en el mismo

        int posJob1 = 0;
        int posJob2 = 0;
        int posJob3 = 0;

        int durationRes=job1.size()+job2.size()+job3.size();

        while (durationRes>=0){

            if(posJob1<job1.size()){
                res.add(job1.get(posJob1));
                posJob1++;
            }

             if(posJob2<job2.size()){
                res.add(job2.get(posJob2));
                posJob2++;
             }

            if(posJob3<job3.size()){
                res.add(job3.get(posJob3));
                posJob3++;
            }

            durationRes--;
        }

        return (res);
    }
}