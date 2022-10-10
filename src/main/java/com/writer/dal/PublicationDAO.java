package com.writer.dal;

import com.writer.bo.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationDAO extends JpaRepository<Publication, Integer> {



}
