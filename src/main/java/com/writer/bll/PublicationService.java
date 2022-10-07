package com.writer.bll;
import com.writer.bo.Publication;
import com.writer.dal.PublicationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService{

    @Autowired
    PublicationDAO dao;

   public List<Publication> listAllPublications() {
       return dao.findAll();
   }
   public Publication addPublication(Publication publication) {
       return dao.save(publication);
   }
   public void deletePublication(Publication publication) {
       dao.delete(publication);
   }
}
