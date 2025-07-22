
Feature: Expédition des commandes
  Background:
    Given que je suis connecté à l'application, j'accède au menu et j'ouvre la page de la modification des quantités d'expédition

#  Scenario: modification des quantités à expédier avec succès
#    When je renseigne le numéro de commande
#    And je renseigne le site livreur
#    And je clique sur rechercher
#    And je clique sur select all
#    And je clique sur editer
#    And je modifie les quantités
#    And je clique sur valider
#    Then je suis redirigé vers la page Menu
#
#Scenario: expédier avec succès
#    When je clique sur expédition
#    When je renseigne le numéro de commande
#    And je renseigne le site livreur
#    And je clique sur rechercher
#    And je clique sur select all 2
#    And je clique sur edition des avis de l'expédition
#    And je clique sur envoyer
#    Then une boite de dialogue s'affiche exp

  Scenario: expédier site livreur erroné
    When je clique sur expédition
    When je renseigne le numéro de commande
    And je renseigne le site livreur 911
    And je clique sur rechercher
    Then une boite de dialogue s'affiche données introuvables

  Scenario: expédier numéro de commande inexistante
    When je clique sur expédition
    When je renseigne le numéro de commande inexistant
    And je renseigne le site livreur
    And je clique sur rechercher
    Then une boite de dialogue s'affiche données introuvables
