Feature: Test réaliser sur site Rexel boutique

	
	@TEST_PT-43
	Scenario: Test réaliser sur site Rexel boutique
		Feature: Naviguer sur site Rexel
		
					Scenario: Rexel test
						Feature: Rexel test naviguation sur site	
							Example: test
							Given Je navigue sur le site Rexel boutique
							And Accept cookies
							And appuie sur selection produits
							And choisir Chauffage electrique climatisation ventilation
							And choisir Chauffage domestique depuis la liste
						  And choisir Radiateur connecte pour rajouter dans le panier
						  And voir mon panier
