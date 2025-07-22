Feature: Création d'une commande

  L'utilisateur peut créer une commande à condition de renseigner toutes les informations requises et valides.

  Background:
    Given que je suis connecté à l'application, j'accède au menu et j'ouvre la page de création de commande


#  Scenario: Créer une commande Semi direct avec succès
#    When je remplis le type de valorisation
#    And je choisis le genre de commande
#    And je renseigne les informations du fournisseur
#    And je sélectionne les sites concernés
#    And je choisis le mode de selection par article
#And je renseigne les articles
#    And je clique sur le bouton Enregistrer
#    And je répartis la commande sur les sites et je clique sur les boutons enregistrer , valoriser et envoyer
#    Then le bon de commande est généré avec succès
#
#  Scenario: Fournisseur inexistant
#    When je remplis le type de valorisation
#    And je choisis le genre de commande
#    And je renseigne les informations d'un fournisseur inexistant
#    And je sélectionne les sites concernés
#    And je choisis le mode de selection par article
#    And je renseigne les articles
#    And je clique sur le bouton Enregistrer echec
#    Then un popup s'affiche corriger les erreurs puis valider
#
#  Scenario: Fournisseur non renseigné
#    When je remplis le type de valorisation
#    And je choisis le genre de commande
#    And je sélectionne les sites concernés
#    And je choisis le mode de selection par article
#    And je renseigne les articles
#    And je clique sur le bouton Enregistrer echec
#    Then un popup s'affiche corriger les erreurs puis valider
#
#  Scenario: Fournisseur non disponible à la date de collecte renseignée
#    When je remplis le type de valorisation
#    And je choisis le genre de commande
#    And je renseigne les informations du fournisseur
#    And je saisis une date de collecte inférieure à J+1
#    And je sélectionne les sites concernés
#    And je choisis le mode de selection par article
#    And je renseigne les articles
#    And je clique sur le bouton Enregistrer echec
#    Then un popup s'affiche corriger les erreurs puis valider
#
#  Scenario: Site inexistant
#    When je remplis le type de valorisation
#    And je choisis le genre de commande
#    And je renseigne les informations du fournisseur
#    And je sélectionne un site inexistant
#    And je choisis le mode de selection par article
#    And je renseigne les articles
#    And je clique sur le bouton Enregistrer echec
#    Then un popup s'affiche corriger les erreurs puis valider
#
#  Scenario: Nom du site non renseigné
#    When je remplis le type de valorisation
#    And je choisis le genre de commande
#    And je renseigne les informations du fournisseur
#    And je choisis le mode de selection par article
#    And je renseigne les articles
#    And je clique sur le bouton Enregistrer
#    And je renseigne les quantités et je clique sur les boutons enregistrer , valoriser et envoyer
#    Then le bon de commande est généré avec succès
#
#  Scenario: Sites en doublon
#    When je remplis le type de valorisation
#    And je choisis le genre de commande
#    And je renseigne les informations du fournisseur
#    And je sélectionne plusieurs fois le même site
#    And je choisis le mode de selection par article
#    And je renseigne les articles
#    And je clique sur le bouton Enregistrer echec
#    Then un popup s'affiche corriger les erreurs puis valider

  Scenario: Aucun article renseigné
    When je remplis le type de valorisation
    And je choisis le genre de commande
    And je renseigne les informations du fournisseur
    And je sélectionne les sites concernés
    And je choisis le mode de selection par article
    And je clique sur le bouton Enregistrer echec
    Then une boite de dialogue s'affiche

#  Scenario: Articles en doublon
#    When je remplis le type de valorisation
#    And je choisis le genre de commande
#    And je renseigne les informations du fournisseur
#    And je sélectionne les sites concernés
#    And je choisis le mode de selection par article
#    And je saisis deux fois ou plus le même article
#    And je clique sur le bouton Enregistrer echec
#    Then un popup s'affiche corriger les erreurs puis valider
#
#  Scenario: Article inexistant
#    When je remplis le type de valorisation
#    And je choisis le genre de commande
#    And je renseigne les informations du fournisseur
#    And je sélectionne les sites concernés
#    And je choisis le mode de selection par article
#    And je renseigne un ou plusieurs articles inexistants
#    And je clique sur le bouton Enregistrer echec
#    Then un popup s'affiche corriger les erreurs puis valider

  Scenario: Liste d’articles vide
    When je remplis le type de valorisation
    And je choisis le genre de commande
    And je renseigne les informations du fournisseur
    And je sélectionne les sites concernés
    And je choisis le mode de selection par liste d’articles
    And je clique sur le bouton Enregistrer echec
    Then une boite de dialogue s'affiche Vous devez saisir au moins une liste d'articles.

  Scenario: Article manquant
    When je remplis le type de valorisation
    And je choisis le genre de commande
    And je renseigne les informations du fournisseur
    And je sélectionne les sites concernés
    And je choisis le mode de selection par article
    And je ne saisis pas un article
    And je clique sur le bouton Enregistrer echec
    Then un popup s'affiche corriger les erreurs puis valider