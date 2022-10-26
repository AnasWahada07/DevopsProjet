package tn.esprit.rh.achat.services;

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
		System.out.println("Succes");
	}

}
