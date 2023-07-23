package com.endava.TicketManagementSystem.repository;

import com.endava.TicketManagementSystem.model.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketCategoryRepository extends JpaRepository<TicketCategory, Integer> {
    List<TicketCategory> findAllById(Integer id);

    List<TicketCategory> findTicketCategoriesByEventId(Integer eventId);

}
