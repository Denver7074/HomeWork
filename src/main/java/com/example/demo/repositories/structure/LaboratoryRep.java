package com.example.demo.repositories.structure;

import java.util.List;
import com.example.demo.entities.structure.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LaboratoryRep extends JpaRepository<Laboratory, Long> {

  List<Laboratory> findLaboratoriesByCity(String city);

  boolean existsByCity(String city);

  boolean existsByUniqueNumber(String number);

  @Modifying
  @Query("update Laboratory l set l.deleted = true where l.id = :id")
  void softDelete(@Param("id") Long id);

  @Modifying
  @Query("update Laboratory l set l.fullName = :fullName, " +
          "l.uniqueNumber = :uniqueNumber, l.city = :city, " +
          "l.latitude = :latitude, l.longitude = :longitude where l.id = :id")
  void updateLaboratory(@Param("fullName") String fullName, @Param("uniqueNumber") String uniqueNumber,
                        @Param("city") String city, @Param("latitude") Double latitude,
                        @Param("longitude") Double longitude, @Param("id") Long id);
}
