package tn.esprit.rh.achat.dto;
import java.util.Set;


import lombok.Data;
import tn.esprit.rh.achat.entities.Produit;

@Data
public class CategorieProduitDTO {

	private String codeCategorie;
	private String libelleCategorie;
	private Set<Produit> produits;
}
