package pokemon.element;

import pokemon.Pokemon;
import pokemon.ataque.Ataque;

import java.util.Scanner;

public class ElementPokemon {
    private static Ataque[] fireMoves;
    private static Ataque[] waterMoves;
    private static Ataque[] grassMoves;
    private static Ataque[] groundMoves;
    private static Ataque[] electricMoves;
    private static Pokemon[] pokemon;

    public static void initializeMoves() {
        fireMoves = new Ataque[] {
            new Ataque("Lanzallamas", Pokemon.TipoAtaque.FISICO, (byte) 90),
            new Ataque("Llamarada", Pokemon.TipoAtaque.ESPACIAL, (byte) 85),
            new Ataque("Puño Fuego", Pokemon.TipoAtaque.FISICO, (byte) 75),
            new Ataque("Giro Fuego", Pokemon.TipoAtaque.ESPACIAL, (byte) 70),
            new Ataque("Nitrocarga", Pokemon.TipoAtaque.FISICO, (byte) 65) // Mantén este ataque
        };

        waterMoves = new Ataque[] {
            new Ataque("Hidrobomba", Pokemon.TipoAtaque.ESPACIAL, (byte) 95),
            new Ataque("Surfer", Pokemon.TipoAtaque.ESPACIAL, (byte) 85),
            new Ataque("Acua poket", Pokemon.TipoAtaque.FISICO, (byte) 80),
            new Ataque("Pistola Agua", Pokemon.TipoAtaque.ESPACIAL, (byte) 65),
            new Ataque("Acua lluvia", Pokemon.TipoAtaque.FISICO, (byte) 75) // Mantén este ataque
        };

        grassMoves = new Ataque[] {
            new Ataque("Rayo Solar", Pokemon.TipoAtaque.ESPACIAL, (byte) 95),
            new Ataque("Hoja Afilada", Pokemon.TipoAtaque.FISICO, (byte) 85),
            new Ataque("Latigazo", Pokemon.TipoAtaque.FISICO, (byte) 80),
            new Ataque("Bomba Germen", Pokemon.TipoAtaque.ESPACIAL, (byte) 75),
            new Ataque("Drenadoras", Pokemon.TipoAtaque.ESPACIAL, (byte) 70)
        };

        groundMoves = new Ataque[] {
            new Ataque("Terremoto", Pokemon.TipoAtaque.FISICO, (byte) 95),
            new Ataque("Excavar", Pokemon.TipoAtaque.FISICO, (byte) 85),
            new Ataque("Tierra Viva", Pokemon.TipoAtaque.ESPACIAL, (byte) 80),
            new Ataque("Bofetón Lodo", Pokemon.TipoAtaque.ESPACIAL, (byte) 75),
            new Ataque("Avalancha", Pokemon.TipoAtaque.FISICO, (byte) 70)
        };

        electricMoves = new Ataque[] {
            new Ataque("inpactrueno", Pokemon.TipoAtaque.FISICO, (byte) 78),
            new Ataque("Rayo", Pokemon.TipoAtaque.FISICO, (byte) 81),
            new Ataque("Puño Trueno", Pokemon.TipoAtaque.ESPACIAL, (byte) 92),
            new Ataque("Relampago", Pokemon.TipoAtaque.ESPACIAL, (byte) 89),
            new Ataque("Truenete", Pokemon.TipoAtaque.FISICO, (byte) 52)
        };
    }

    public static void initializePokemons() {
        pokemon = new Pokemon[] {
            new Pokemon("Charizard", (short) 282, Pokemon.TipoPokemon.FUEGO, new Ataque[] {fireMoves[0], fireMoves[1], fireMoves[2], fireMoves[3]}),
            new Pokemon("Flareon", (short) 198, Pokemon.TipoPokemon.FUEGO, new Ataque[] {fireMoves[1], fireMoves[2], fireMoves[3], fireMoves[4]}),

            new Pokemon("Blastoise", (short) 292, Pokemon.TipoPokemon.AGUA, new Ataque[] {waterMoves[0], waterMoves[1], waterMoves[2], waterMoves[3]}),
            new Pokemon("Vaporeon", (short) 214, Pokemon.TipoPokemon.AGUA, new Ataque[] {waterMoves[1], waterMoves[2], waterMoves[3], waterMoves[4]}),

            new Pokemon("Venasaur", (short) 271, Pokemon.TipoPokemon.PLANTA, new Ataque[] {grassMoves[0], grassMoves[1], grassMoves[2], grassMoves[3]}),
            new Pokemon("Leafeon", (short) 194, Pokemon.TipoPokemon.PLANTA, new Ataque[] {grassMoves[1], grassMoves[2], grassMoves[3], grassMoves[4]}),

            new Pokemon("Sandslash", (short) 324, Pokemon.TipoPokemon.TIERRA, new Ataque[] {groundMoves[0], groundMoves[1], groundMoves[2], groundMoves[3]}),
            new Pokemon("Nidoking", (short) 344, Pokemon.TipoPokemon.TIERRA, new Ataque[] {groundMoves[1], groundMoves[2], groundMoves[3], groundMoves[4]}),
            new Pokemon("Hippowdon", (short) 350, Pokemon.TipoPokemon.TIERRA, new Ataque[] {groundMoves[0], groundMoves[1], groundMoves[2], groundMoves[3]}),
            new Pokemon("Rhyperior", (short) 350, Pokemon.TipoPokemon.TIERRA, new Ataque[] {groundMoves[1], groundMoves[2], groundMoves[3], groundMoves[4]}),

            new Pokemon("Pikachu", (short) 176, Pokemon.TipoPokemon.ELECTRICO, new Ataque[] {electricMoves[0], electricMoves[2], electricMoves[1], electricMoves[4]}),
            new Pokemon("Kilowattrel", (short) 208, Pokemon.TipoPokemon.ELECTRICO, new Ataque[] {electricMoves[1], electricMoves[3], electricMoves[0], electricMoves[4]}),
            new Pokemon("Zapdos", (short) 274, Pokemon.TipoPokemon.ELECTRICO, new Ataque[] {electricMoves[3], electricMoves[4], electricMoves[2], electricMoves[1]})
        };
    }

    public static void initializeData() {
        initializeMoves();
        initializePokemons();
    }

    public void createAtaques(Scanner sc, Ataque[] ataque) {
        for (int i = 0; i < ataque.length; i++) {
            System.out.println("Ingrese el nombre del ataque " + (i + 1) + ":");
            String nombreAtaque = sc.nextLine();

            System.out.println("Seleccione el tipo de ataque:");
            System.out.println("1. FISICO");
            System.out.println("2. ESPACIAL");
            int tipoOpcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea pendiente
            Pokemon.TipoAtaque tipoAtaque = (tipoOpcion == 1) ? Pokemon.TipoAtaque.FISICO : Pokemon.TipoAtaque.ESPACIAL;

            int poder;
            do {
                System.out.println("Ingrese el poder del ataque (máximo 150 para ESPACIAL, 100 para FISICO):");
                poder = sc.nextInt();
                sc.nextLine(); // Consumir el salto de línea pendiente
                if ((tipoAtaque == Pokemon.TipoAtaque.FISICO && poder > 0 && poder <= 100) ||
                    (tipoAtaque == Pokemon.TipoAtaque.ESPACIAL && poder > 0 && poder <= 150)) {
                    break;
                } else {
                    System.out.println("El poder del ataque no es válido. Intente de nuevo.");
                }
            } while (true);

            // Inicializar el objeto Ataque en la posición i
            ataque[i] = new Ataque(nombreAtaque, tipoAtaque, (byte) poder);
        }
    }

    public Ataque[] createAtaques(Scanner sc) {
        Ataque[] ataquesPersonalizados = new Ataque[4];
        for (int i = 0; i < ataquesPersonalizados.length; i++) {
            System.out.println("Ingrese el nombre del ataque " + (i + 1) + ":");
            String nombreAtaque = sc.nextLine();

            System.out.println("Seleccione el tipo de ataque:");
            System.out.println("1. FISICO");
            System.out.println("2. ESPACIAL");
            int tipoOpcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea pendiente
            Pokemon.TipoAtaque tipoAtaque = (tipoOpcion == 1) ? Pokemon.TipoAtaque.FISICO : Pokemon.TipoAtaque.ESPACIAL;

            int poder;
            do {
                System.out.println("Ingrese el poder del ataque (máximo 150 para ESPACIAL, 100 para FISICO):");
                poder = sc.nextInt();
                sc.nextLine(); // Consumir el salto de línea pendiente
                if ((tipoAtaque == Pokemon.TipoAtaque.FISICO && poder > 0 && poder <= 100) ||
                    (tipoAtaque == Pokemon.TipoAtaque.ESPACIAL && poder > 0 && poder <= 150)) {
                    break;
                } else {
                    System.out.println("El poder del ataque no es válido. Intente de nuevo.");
                }
            } while (true);

            ataquesPersonalizados[i] = new Ataque(nombreAtaque, tipoAtaque, (byte) poder);
        }
        return ataquesPersonalizados;
    }

    public static Ataque[] getFireMoves() {
        return fireMoves;
    }

    public static Ataque[] getWaterMoves() {
        return waterMoves;
    }

    public static Ataque[] getGrassMoves() {
        return grassMoves;
    }

    public static Ataque[] getGroundMoves() {
        return groundMoves;
    }

    public static Ataque[] getElectricMoves() {
        return electricMoves;
    }

    public static void main(String[] args) {
        ElementPokemon.initializeData();

        Scanner sc = new Scanner(System.in);
        ElementPokemon element = new ElementPokemon();

        // Crear ataques personalizados
        Ataque[] ataquesPersonalizados = element.createAtaques(sc);

        // Asignar los ataques personalizados a un Pokémon
        Pokemon pokemonPersonalizado = new Pokemon("Pokemon Personalizado", (short) 200, Pokemon.TipoPokemon.FUEGO, ataquesPersonalizados);
    }

    public static Pokemon[] getPokemon() {
        return pokemon;
    }
}
