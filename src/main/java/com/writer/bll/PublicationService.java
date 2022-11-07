package com.writer.bll;
import com.writer.bo.Publication;
import com.writer.dal.PublicationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationService{

    @Autowired
    PublicationDAO dao;

   public List<Publication> listAll() {
       return dao.findAll();
   }
   public Optional<Publication> getOne(Long id) { return dao.findById(id);}
   public void addPublication(Publication publication) {
       dao.save(publication);
   }
   public void deletePublication(Publication publication) {
       dao.delete(publication);
   }
}
