package Interfaz;

import entrenador.Entrenador;
import pokemon.Pokemon;
import pokemon.element.ElementPokemon;
import Batalla.Batalla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Interfaz extends JFrame {
    private JTextArea textArea;

    public Interfaz() {
        setTitle("Batalla Pokémon");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Configuración del layout
        setLayout(new BorderLayout());

        // Área de texto para mostrar información
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Botón para iniciar la batalla
        JButton startButton = new JButton("Iniciar Batalla");
        add(startButton, BorderLayout.SOUTH);

        // Acción del botón
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarBatalla();
            }
        });
    }

    private void iniciarBatalla() {
        // Inicializar datos
        ElementPokemon.initializeData();

        // Obtener la lista de Pokémon disponibles
        List<Pokemon> availablePokemons = new ArrayList<>(Arrays.asList(ElementPokemon.getPokemon()));

        // Crear entrenadores y asignar equipos
        Entrenador entrenador1 = new Entrenador();
        Entrenador entrenador2 = new Entrenador();

        entrenador1.setNameTrainer(new Scanner(System.in), availablePokemons);
        entrenador2.setNameTrainer(new Scanner(System.in), availablePokemons);

        // Obtener nombres y equipos
        String nombreEntrenador1 = entrenador1.getNombre();
        String nombreEntrenador2 = entrenador2.getNombre();
        Pokemon[] equipo1 = entrenador1.getEquipo();
        Pokemon[] equipo2 = entrenador2.getEquipo();

        // Mostrar equipos en el área de texto
        textArea.append("Equipos iniciales:\n");
        textArea.append(nombreEntrenador1 + ":\n");
        for (Pokemon p : equipo1) {
            textArea.append("- " + p.getNamePokemon() + " (HP: " + p.getHP() + ", Tipo: " + p.getTypePokemon() + ")\n");
        }
        textArea.append("\n" + nombreEntrenador2 + ":\n");
        for (Pokemon p : equipo2) {
            textArea.append("- " + p.getNamePokemon() + " (HP: " + p.getHP() + ", Tipo: " + p.getTypePokemon() + ")\n");
        }

        // Iniciar la batalla
        Batalla batalla = new Batalla();
        batalla.iniciarBatalla(nombreEntrenador1, equipo1, nombreEntrenador2, equipo2, new Scanner(System.in));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interfaz interfaz = new Interfaz();
            interfaz.setVisible(true);
        });
    }
}
