package com.wikimedia.wikimediastream_consumer_service.repository;


import com.wikimedia.wikimediastream_consumer_service.entity.WikiMediaEntityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiMediaEventDataRepository extends JpaRepository<WikiMediaEntityData, Long> {
}
