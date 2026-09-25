/* =========================================================================
   MAILLON 2 — JAVA : le moteur de calcul
   Complétez les quatre méthodes. Les classes Ligne, Resultat et Chargeur
   sont fournies : ne les modifiez pas.
       javac -encoding UTF-8 -d out src/*.java
       java -Dstdout.encoding=UTF-8 -cp out Tests     (les tests)
       java -Dstdout.encoding=UTF-8 -cp out Main      (la production)
   ========================================================================= */

import java.util.List;

public class Classement {

    /** Barème officiel des dix premiers. FOURNI — NE PAS MODIFIER. */
    public static final int[] BAREME = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

    // 1. pointsPourPosition(position) : points marqués pour cette position.
    //    1 -> 25, 2 -> 18, ..., 10 -> 1. Au-delà de la 10e place : 0.
    //    Un abandon vaut la position 0, donc 0 point.
    public static int pointsPourPosition(int position) {
    if (position >= 1 && position <= 10) {
        return BAREME[position - 1];
    }

    return 0;
}
    // 2. classementPilotes(lignes) : un Resultat par pilote, avec ses points,
    //    ses victoires (position 1) et ses 2e places, trié par :
    //    points décroissants, puis victoires, puis 2e places, puis nom (A→Z).
    public static List<Resultat> classementPilotes(List<Ligne> lignes) {
    List<Resultat> resultats = new java.util.ArrayList<>();

    for (Ligne ligne : lignes) {

        Resultat resultat = null;

        // On cherche si le pilote existe déjà
        for (Resultat r : resultats) {
            if (r.nom.equals(ligne.pilote())) {
                resultat = r;
                break;
            }
        }

        // Si le pilote n'existe pas encore, on le crée
        if (resultat == null) {
            resultat = new Resultat(ligne.pilote(), ligne.ecurie());
            resultats.add(resultat);
        }

        // Ajout des points
        resultat.points += pointsPourPosition(ligne.position());

        // Victoire
        if (ligne.position() == 1) {
            resultat.victoires++;
        }

        // Deuxième place
        if (ligne.position() == 2) {
            resultat.deuxiemes++;
        }
    }

    // Tri : points → victoires → 2e places → nom
    resultats.sort((a, b) -> {
        if (a.points != b.points) {
            return Integer.compare(b.points, a.points);
        }

        if (a.victoires != b.victoires) {
            return Integer.compare(b.victoires, a.victoires);
        }

        if (a.deuxiemes != b.deuxiemes) {
            return Integer.compare(b.deuxiemes, a.deuxiemes);
        }

        return a.nom.compareTo(b.nom);
    });

    return resultats;
}

    // 3. classementEcuries(pilotes) : additionne les points, victoires et
    //    2e places des pilotes de chaque écurie. Même ordre de tri.
    public static List<Resultat> classementEcuries(List<Resultat> pilotes) {
    List<Resultat> ecuries = new java.util.ArrayList<>();

    for (Resultat pilote : pilotes) {

        Resultat ecurie = null;

        // On cherche si l'écurie existe déjà
        for (Resultat r : ecuries) {
            if (r.nom.equals(pilote.ecurie)) {
                ecurie = r;
                break;
            }
        }

        // Si l'écurie n'existe pas encore, on la crée
        if (ecurie == null) {
            ecurie = new Resultat(pilote.ecurie, "");
            ecuries.add(ecurie);
        }

        // Addition des résultats des pilotes
        ecurie.points += pilote.points;
        ecurie.victoires += pilote.victoires;
        ecurie.deuxiemes += pilote.deuxiemes;
    }

    // Tri : points → victoires → 2e places → nom
    ecuries.sort((a, b) -> {
        if (a.points != b.points) {
            return Integer.compare(b.points, a.points);
        }

        if (a.victoires != b.victoires) {
            return Integer.compare(b.victoires, a.victoires);
        }

        if (a.deuxiemes != b.deuxiemes) {
            return Integer.compare(b.deuxiemes, a.deuxiemes);
        }

        return a.nom.compareTo(b.nom);
    });

    return ecuries;
}

    // 4. positionMoyenne(lignes, pilote) : moyenne des positions de ce pilote,
    //    ABANDONS EXCLUS, arrondie à 2 décimales. 0 s'il n'a jamais terminé.
    //    Ex. positions 1, 2 et un abandon -> 1.5
    public static double positionMoyenne(List<Ligne> lignes, String pilote) {
        // À COMPLÉTER
        return 0;
    }
}
