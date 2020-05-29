# -ET3-TPGraphicalEditor-LE_SAOUT_Robin-

La plupart des fonctionnalités sont présentes dans le projet mais je tiens à noter les différents problèmes qui peuvent arriver:

1) Logiquement pas de problème pour cette question la fenêtre est générée avec SceneBuilder.

2) Je n'ai implémenté ce code que sur Rectangle et Ellipse par manque de temps pour passer aux fonctionnalités suivantes.
L'application ne gère pas les lignes.
Les ellipses et les rectangles se forment bien et la taille se définit dans le canvas directement en glissant l'objet.
(faire du haut à gauche vers le bas à droite)

3) Le colorpicker fonctionne

4) Le radioButton Select/move permet de :

-  sélectionner une figure et de rendre un feedback (grossissement de l'objet de 10). (ne rétrécit pas quand on déselectionne)

- La Couleur se modifie bien mais il faut recliquer sur la figure une fois que la couleur est choisi dans le colorPicker.

- Les figures se déplacent correctements dans le Canvas

5) -Le bouton delete, supprime les composants de l'interface lorsque séléctionné. MAIS out of bonds lorsque je ne veux supprimer qu'un rectangle. Problème à cause des Arraylists. 
Le bouton fonctionne pour une ellipse et delete aussi si on a une ellipse et un rectangle. Le out of bonds n'arrive que pour un rectangle sur le canvas.

- Une piste de bouton clone est située en bas du contolleur en commentaire.

