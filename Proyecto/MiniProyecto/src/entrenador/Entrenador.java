package entrenador;

import pokemon.Pokemon;

import java.util.Scanner;

public class Entrenador {
    private String nombre; // Nombre del entrenador
    private Pokemon[] equipo; // Equipo de Pokémon del entrenador

    public void setNameTrainer(Scanner sc) {
        Pokemon pokemon = new Pokemon();

        // Solicitar el nombre del entrenador
        System.out.println("Ingrese el nombre del entrenador:");
        nombre = sc.nextLine();

        // Configurar el equipo del entrenador
        System.out.println("¿Cómo quieres jugar, " + nombre + "?");
        System.out.println("1. Pokemones aleatorios");
        System.out.println("2. Crear tus propios pokemones");
        int opcion = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea pendiente

        switch (opcion) {
            case 1 -> {
                // Generar equipo aleatorio
                equipo = pokemon.randomPokemonTeam(3);
                System.out.println("Equipo generado para " + nombre + ":");
                for (Pokemon p : equipo) {
                    System.out.println("- " + p.getNamePokemon() + " (HP: " + p.getHP() + ", Tipo: " + p.getTypePokemon() + ")");
                }
            }
            case 2 -> {
                // Crear equipo personalizado
                pokemon.createPokemon(sc);
                equipo = pokemon.getPokemons(); // Asignar el equipo creado
            }
            default -> {
                System.out.println("Opción no válida. Se generará un equipo aleatorio por defecto.");
                equipo = pokemon.randomPokemonTeam(3);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon[] getEquipo() {
        return equipo;
    }
}
