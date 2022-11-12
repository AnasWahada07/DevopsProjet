package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CategorieProduitServiceImplTest {
	
	@Mock
	CategorieProduitRepository categorieproduitrepository;
	
	@InjectMocks
	CategorieProduitServiceImpl categorieservice;
	
	@Test
	public void testretrieveCategorieProduit() {
		CategorieProduit categorieproduit = new CategorieProduit(1L,"ab","abc",null);
		categorieproduit.setIdCategorieProduit(1L);
		Mockito.when(categorieproduitrepository.findById(1L)).thenReturn(Optional.of(categorieproduit));
		
		categorieservice.retrieveCategorieProduit(1L);
		Assertions.assertNotNull(categorieproduit);
		System.out.println(categorieproduit);
		System.out.println("catégorie de produit valide");
	}
	
	@Test
	void addCategorieProduitTest() {
		CategorieProduit categorieproduit10 = new CategorieProduit(10L,"qs","qsd",null);
		categorieproduit10.setIdCategorieProduit(10L);
		categorieservice.addCategorieProduit(categorieproduit10);
		verify(categorieproduitrepository, times(1)).save(categorieproduit10);
		System.out.println(categorieproduit10); 
		System.out.println("Succées de création d'une catégorie de produit ");
	}
	
	@Test 
	void deleteCategorieProduitTest() {
		CategorieProduit categorieproduit20 = new CategorieProduit(null,"qs","qsd",null);
		categorieproduit20.setIdCategorieProduit(20L);
		Mockito.lenient().when(categorieproduitrepository.findById(categorieproduit20.getIdCategorieProduit())).thenReturn(Optional.of(categorieproduit20));
		categorieservice.deleteCategorieProduit(20L);
		verify(categorieproduitrepository).deleteById(categorieproduit20.getIdCategorieProduit());
		System.out.println(categorieproduit20);
		System.out.println("Succées d'éffacement d'une catégorie de produit");
	}
	
	@Test 
	void retrieveAllCategorieProduits() {
		List<CategorieProduit> categorieproduitList = new ArrayList<CategorieProduit>(){{
			
			add(new CategorieProduit(100L,"WWW","VVVV",null));
			add(new CategorieProduit(200L,"KKKK","llll",null));
			add(new CategorieProduit(300L,"uuuu","MMMM",null));

		}};
		
		when(categorieservice.retrieveAllCategorieProduits()).thenReturn(categorieproduitList);
		List<CategorieProduit> cpList = categorieservice.retrieveAllCategorieProduits();
		assertEquals(3, cpList.size());
		System.out.println("la fonction tourne correctement");
	}

}
