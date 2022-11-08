package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;

import java.util.List;


public interface ICategorieProduitService {

	List<CategorieProduit> retrieveAllCategorieProduits();

	CategorieProduit addCategorieProduit(CategorieProduit cp);

	void deleteCategorieProduit(Long id);

	CategorieProduitDTO updateCategorieProduit(CategorieProduitDTO cp);

	CategorieProduit retrieveCategorieProduit(Long id);

}
