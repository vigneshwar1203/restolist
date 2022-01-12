package com.thbs.Repository;

import com.thbs.Model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bookingRepo extends JpaRepository<BookingDetails,String> {
    @Query("SELECT b FROM BookingDetails b where b.email = ?1")
    List<BookingDetails> findByIdEmail(String email);
}
