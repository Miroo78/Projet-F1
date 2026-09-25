/* =========================================================================
   MAILLON 3 — JAVASCRIPT : l'interface
   Les données arrivent du maillon Java, dans donnees.js :
     PILOTES = [{nom, ecurie, points, victoires}, ...]
     ECURIES = [{nom, points, victoires}, ...]
   Complétez les trois fonctions, puis ouvrez index.html dans le navigateur.
   ========================================================================= */

// 1. trierParPoints(liste) : renvoie une NOUVELLE liste triée par points
//    DÉCROISSANTS. La liste reçue ne doit pas être modifiée.
//    À points égaux, celui qui a le plus de victoires passe devant.
function trierParPoints(liste) {
  return [...liste].sort((a, b) => {
    if (a.points !== b.points) {
      return b.points - a.points; // Tri par points décroissants
    }
    return b.victoires - a.victoires; // Tri par victoires décroissantes si points égaux
  });
}

// 2. remplirTableau(idCorps, liste) : remplit le <tbody> dont l'id est fourni.
//    Une ligne <tr> par entrée, avec dans l'ordre les cellules <td> :
//      rang (1, 2, 3...) | nom | écurie (chaîne vide si absente) | points | victoires
//    Chaque <tr> porte l'attribut data-nom. Un nouvel appel REMPLACE le contenu.
function remplirTableau(idCorps, liste) {
  const corps = document.getElementById(idCorps);

  corps.innerHTML = "";

  liste.forEach((element, index) => {
    const ligne = document.createElement("tr");

    ligne.dataset.nom = element.nom;

    const rang = document.createElement("td");
    rang.textContent = index + 1;

    const nom = document.createElement("td");
    nom.textContent = element.nom;

    const ecurie = document.createElement("td");
    ecurie.textContent = element.ecurie || "";

    const points = document.createElement("td");
    points.textContent = element.points;

    const victoires = document.createElement("td");
    victoires.textContent = element.victoires;

    ligne.appendChild(rang);
    ligne.appendChild(nom);
    ligne.appendChild(ecurie);
    ligne.appendChild(points);
    ligne.appendChild(victoires);

    corps.appendChild(ligne);
  });
}
// 3. marquerPodium(idCorps) : ajoute la classe CSS "podium" aux TROIS PREMIÈRES
//    lignes du tableau, et la retire de toutes les autres.
function marquerPodium(idCorps) { // 
  const corps = document.getElementById(idCorps);
  const lignes = corps.querySelectorAll("tr");

  lignes.forEach((ligne, index) => { // Parcours de toutes les li,es du tableaau
    ligne.classList.remove("podium");

    if (index < 3) { // Si c'est unn des 3 lignes 
      ligne.classList.add("podium");// ajt podium
    }// Sinon on ne fait rien
    // ajouter la classe "intermediaire" aux lignes 4 à 6 (index 3 à 5)
    if (index >= 3 && index < 6) {
      ligne.classList.add("intermediaire");
    } else {
      ligne.classList.remove("intermediaire");
    }
  });
}

/* --- FOURNI — NE PAS MODIFIER : affichage de la saison ------------------- */
function afficherSaison() {
  if (typeof PILOTES === "undefined") {
    return;
  }
  remplirTableau("corps-pilotes", trierParPoints(PILOTES));
  marquerPodium("corps-pilotes");
  remplirTableau("corps-ecuries", trierParPoints(ECURIES));
  marquerPodium("corps-ecuries");
}
