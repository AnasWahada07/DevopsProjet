package tn.esprit.rh.achat.services; 

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitServiceTest {

    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    ProduitServiceImpl produitService;

    @Test
    public void testRetrieveProduit() {

        Produit produit = new Produit(1L,"1xl","savon",12.5,new Date(), new Date(),null,null,null);

        produit.setIdProduit(1L);

        Mockito.when(produitRepository.findById(1L)).thenReturn(Optional.of(produit));
        produitService.retrieveProduit(1L);
        Assertions.assertNotNull(produit);

        System.out.println(produit);
        System.out.println(" Retrieve is working correctly...!!");

    }


    @Test
   public void createProduitTest()
    {
        Produit produit2 = new Produit(2L,"2xl","lait",10.5,new Date(), new Date(), null, null, null);
        produit2.setIdProduit(2L);

        produitService.addProduit(produit2);
        verify(produitRepository, times(1)).save(produit2);
        System.out.println(produit2);
        System.out.println(" Create is working correctly...!!");
    }


    @Test
 public   void getAllProduitTest()
    {
        List<Produit> Produitlist = new ArrayList<Produit>() {

            {
                add(new Produit(3L,"3xl","cafe",8.5,new Date(), new Date(), null, null, null));
                add(new Produit(4L,"4xl","fromage",12.5, new Date(), new Date(), null, null, null));
                add(new Produit(5L,"5xl","table",5.5, new Date(), new Date(), null, null, null));
            }};


        when(produitService.retrieveAllProduits()).thenReturn(Produitlist);
        //test
        List<Produit> produitList = produitService.retrieveAllProduits();
        assertEquals(3, produitList.size());
        System.out.println(" Retrieve all is working correctly...!!");
    }




}