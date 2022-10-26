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

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)


public class OperateurServiceImplTest {


		
		@Mock
		OperateurRepository OPrepository;
		
		@InjectMocks
		OperateurServiceImpl opService;

		@Test
		public void testRetrieveSecteur() {
			Operateur op = new Operateur(1L,"rym","bs","xxx",null);
			op.setIdOperateur(1L);
			
			
			Mockito.when(OPrepository.findById(1L)).thenReturn(Optional.of(op));
			opService.retrieveOperateur(1L);
			Assertions.assertNotNull(op);
			
			System.out.println(op);
			System.out.println("operateur retrouvé");
		}
}
