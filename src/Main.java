
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();
        Persona persona1 = new Persona("Javier");
        Persona persona2 = new Persona("Javier", 21, 1.65f);

        System.out.println("List");

        List<Persona> lista = new ArrayList<>();

        lista.add(persona);
        lista.add(persona1);
        lista.add(persona2);
        lista.add(new Persona("Pepe",46,1.60f));
        lista.add(new Persona("Vero",38,1.60f));
        lista.add(new Persona("Francisco",22,1.70f));
        lista.add(new Persona("Omar",34,1.80f));
        lista.add(new Persona("Pedro",53,1.70f));
        lista.add(new Persona("Tony",24,1.70f));
        lista.add(new Persona("Luna",20,1.60f));
        lista.add(new Persona("Sol",34,1.80f));

        persona.setNombre("David");

        System.out.println("Listado de Personas");
        for (Persona p:lista){
            System.out.println(p.descripcion());
        }
        lista.get(0).setEdad(18);
        lista.get(0).imprimirdatos();

        lista.get(1).setEdad(18);
        lista.get(1).imprimirdatos();

        lista.get(2).setEdad(18);
        lista.get(2).imprimirdatos();

        lista.get(3).setEdad(18);
        lista.get(3).imprimirdatos();

        lista.get(4).setEdad(18);
        lista.get(4).imprimirdatos();

        System.out.println("Set");
        Set<String> nombres = new HashSet<>();
        nombres.add("Mateo");
        nombres.add("Javier");
        nombres.add("Irene");
        nombres.add("Michael");
        nombres.add("Jorge");
        System.out.println("Nombres unicos (sin orden garantizado): "+nombres);

        Set<Persona> nombres2=new HashSet<>();
        nombres2.add(new Persona("Ana",25,1.60f));
        nombres2.add(new Persona("Vero",38,1.50f));
        nombres2.add(new Persona("Paulina Fiell",25,1.60f));
        nombres2.add(new Persona("Javi Fiell",21,1.65f));

        System.out.println("Hashmap");
        Map<String, Persona> codigounico = new HashMap<>();
        codigounico.put("e01",persona);
        codigounico.put("e02",persona1);
        codigounico.put("e03",persona2);
        codigounico.put("e04",lista.get(0));

        System.out.println("Codigo unico e03 - "+codigounico.get("e03").descripcion());
        System.out.println("Codigo unico e02 - "+codigounico.get("e02").descripcion());
        System.out.println("Codigo unico e10 - "+codigounico.containsKey("e10"));


        Scanner le = new Scanner(System.in);
        String nombre;

        do {
            System.out.println("--- Ingreso de Personas ---");
            System.out.println("Ingrese un nombre: ");
            nombre = le.nextLine();

            if (!nombre.equals("0")){
                Persona person = new Persona(nombre);
                lista.add(person);
            }

        }while(!nombre.equals("0"));












        le.close();


    }
}