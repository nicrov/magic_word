import java.util.Random;

public class MagicWord {
    private static final int MAX_FAILS = 10;
    private static final String[] palabras = {
            "sol", "luna", "mar", "rio", "montaña", "arbol", "flor", "cielo", "nube", "viento",
            "fuego", "tierra", "camino", "bosque", "piedra", "arena", "hoja", "raiz", "estrella", "lluvia",
            "casa", "puerta", "ventana", "mesa", "florentina", "libro", "papel", "lapiz", "reloj", "llave",
            "espejo", "cama", "pared", "techo", "puente", "ciudad", "calle", "plaza", "parque", "torre",
            "perro", "gato", "pajaro", "caballo", "lobo", "leon", "andreu", "oso", "pez", "aguila",
            "tiempo", "pene", "alma", "mente", "corazon", "sueno", "voz", "silencio", "sombra", "luz",
            "viaje", "mundo", "barco", "tren", "ruta", "mapa", "destino", "origen", "meta", "paso",
            "fuerza", "valor", "paz", "esperanza", "calma", "verdad", "razon", "deseo", "idea", "memoria",
            "musica", "canto", "danza", "arte", "color", "ritmo", "verso", "poema", "cuento", "historia",
            "noche", "dia", "tarde", "alba", "aurora", "crepusculo", "invierno", "verano", "hugorabudo", "primavera"

    };

    private String hiddenword;
    private boolean[] correctLetters;
    private int fails;

    public MagicWord() {
        fails = 0;
        int palabraAleatoria = (int) (Math.random() * palabras.length);
        hiddenword = palabras[palabraAleatoria];
        correctLetters = new boolean[hiddenword.length()];
        for (int i = 0; i < correctLetters.length; i++) {
            correctLetters[i] = false;
        }

    }

    @Override
    public String toString() {
        String S = "";
        for (int i = 0; i < correctLetters.length; i++) {
            if (correctLetters[i]) {
                S += hiddenword.charAt(i);
            } else {
                S += "_";
            }

        }
        return S;
    }

    public boolean wins() {
        for (int i = 0; i < correctLetters.length; i++) {
            if (!correctLetters[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean losses() {
        return fails> MAX_FAILS;
    }


    public void shoot(String wordOrLetter) {
        boolean acierto = false;
        if (wordOrLetter.length() == 1) {
            for (int i = 0; i < hiddenword.length(); i++) {
                if (wordOrLetter.charAt(0) == hiddenword.charAt(i)) {
                    correctLetters[i] = true;
                    acierto = true;
                }
            }
            if (!acierto) {
                fails++;
            }

        } else {
            if (hiddenword.equals(wordOrLetter)) {
                for (int i = 0; i < correctLetters.length; i++) {
                    correctLetters[i] = true;
                    fails = MAX_FAILS + 1;
                }
            }
        }

    }

    public String getHiddenword() {
        return hiddenword;
    }
}

