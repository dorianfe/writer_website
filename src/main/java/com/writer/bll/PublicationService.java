package com.writer.bll;
import com.writer.bo.Publication;
import com.writer.dal.PublicationDAO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PublicationService{

    private final PublicationDAO dao;

    public PublicationService(PublicationDAO dao) {
        this.dao = dao;
    }

    public List<Publication> listAll() {
       return dao.findAll();
   }
   public Optional<Publication> getOne(Long id) { return dao.findById(id);}
   public Publication addPublication(Publication publication) {
        publication.setUpdated(LocalDateTime.now());
        dao.save(publication);
       return publication;
   }
   public void deletePublication(Publication publication) {
       dao.delete(publication);
   }
}
