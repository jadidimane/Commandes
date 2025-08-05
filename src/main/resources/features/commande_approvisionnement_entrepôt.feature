Feature: Création d'une commande flux approvisionnement entrepôt

  L'utilisateur peut créer une commande à condition de renseigner toutes les informations requises et valides.

  Background:
    Given que je suis connecté à l'application, j'accède au menu et j'ouvre la page de création de commande en tant que magazinier dans le site 921


  Scenario: Créer une commande normale avec succès
    When   je choisis le genre de commande app
    And je renseigne les informations du fournisseur
    And je choisis le mode de selection par article
    And je renseigne les articles
    And je clique sur le bouton Enregistrer
    And je répartis la commande et je clique sur valider
    Then une boite de dialogue est affiche
