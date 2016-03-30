ProjetJeuTL

Le jeu reprend le principe d'un chercheur d'or. Sur la carte(map), un lingot invisible est généré avec une valeur aléatoire (or, argent ou bronze), l'or ayant une probabilité d'apparaître plus faible que l'argent et encore plus faible que le bronze. Une musique se lance lorsqu’on est sur le lingot (modulo un delta de précision).

Un sonar perpétuel donne une précision au joueur quant à la distance qui le sépare du lingot (plus le son est fort, plus le joueur en est proche, plus le son est faible plus il en est loin) avec trois stades de volume.

La touche « Entrée » permet de lancer une musique, « Echap » arrête cette musique.

Les déplacements se font via les touches directionnelles. 

La touche R permet de courir, W de marcher (à noter que le clavier peut être détecté en qwerty. Dans ce cas, R reste R mais W devient Z).

Répartition des tâches :
Louis :

 - Création de l’inventaire
 - Affichage de l’inventaire
 - Affichage de l’HUD
 - Gestion de l’inventaire
Benjamin : 

 - Création de la/des carte(s)
 - Gestion des collisions
 - Gestion des triggers
Matthieu :

 - Courir
 - Apparition or
 - Apparition monstres
 - Sonar
