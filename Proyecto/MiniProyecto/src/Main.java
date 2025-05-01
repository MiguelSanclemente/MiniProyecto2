import entrenador.Entrenador;
import pokemon.Pokemon;
import pokemon.element.ElementPokemon;
import Batalla.Batalla;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicializa los datos necesarios
        ElementPokemon.initializeData();

        // Crear el primer entrenador y configurar su equipo
        Entrenador entrenador1 = new Entrenador();
        entrenador1.setNameTrainer(sc);

        // Crear el segundo entrenador y configurar su equipo
        Entrenador entrenador2 = new Entrenador();
        entrenador2.setNameTrainer(sc);

        // Obtener los nombres y equipos de los entrenadores
        String nombreEntrenador1 = entrenador1.getNombre();
        String nombreEntrenador2 = entrenador2.getNombre();

        Pokemon[] equipo1 = entrenador1.getEquipo();
        Pokemon[] equipo2 = entrenador2.getEquipo();

        // Mostrar equipos iniciales
        System.out.println("\nEquipos iniciales:");
        System.out.println(nombreEntrenador1 + ":");
        for (Pokemon p : equipo1) {
            System.out.println("- " + p.getNamePokemon() + " (HP: " + p.getHP() + ", Tipo: " + p.getTypePokemon() + ")");
        }

        System.out.println("\n" + nombreEntrenador2 + ":");
        for (Pokemon p : equipo2) {
            System.out.println("- " + p.getNamePokemon() + " (HP: " + p.getHP() + ", Tipo: " + p.getTypePokemon() + ")");
        }

        // Iniciar la batalla
        Batalla batalla = new Batalla();
        batalla.iniciarBatalla(nombreEntrenador1, equipo1, nombreEntrenador2, equipo2, sc);
    }
}