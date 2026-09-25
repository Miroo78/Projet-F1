**Readme origanl remplaé par celui du rendu à la demande du Formateur
# Projet transversal — Championnat de Formule 1

**Réalisé par Amir Boumazouzi**

## Présentation

Ce projet consiste à développer une chaîne de traitement permettant de transformer des résultats bruts de championnat en classements de pilotes et d'écuries.

Le projet est organisé en trois maillons complémentaires :

```text
resultats.csv
    ↓
Python — Ingestion et nettoyage
    ↓
courses_propres.csv
    ↓
Java — Calcul des classements
    ↓
donnees.js
    ↓
JavaScript — Affichage web
```

## Python — Ingestion et nettoyage

Le premier maillon récupère les résultats bruts, convertit les temps au tour en secondes et normalise les résultats des pilotes ayant abandonné.

Le fichier nettoyé est ensuite généré au format attendu par le maillon Java.

**Tests : 4/4 réussis**

## Java — Traitement et calcul

Le deuxième maillon exploite les données nettoyées afin de calculer les points, les classements des pilotes et des écuries ainsi que la position moyenne des pilotes.

Les règles de classement et de départage sont prises en compte conformément au cahier des charges.

**Tests : 5/5 réussis**

## JavaScript — Interface

Le dernier maillon récupère les données produites par Java et les affiche dans une interface web.

Il assure notamment le tri des résultats, la génération dynamique des tableaux et l'identification des trois premières positions.

**Tests : 5/5 réussis**

## Validation de la chaîne

Les trois maillons ont été validés individuellement puis exécutés dans leur ordre de fonctionnement.

```text
Python → Java → JavaScript
```

La chaîne complète fonctionne correctement, depuis le fichier de résultats brut jusqu'à l'affichage des classements dans l'interface web.

## Technologies

* Python
* Java
* JavaScript
* HTML / CSS
* Git / GitHub

---

**Auteur : Amir Boumazouzi**
