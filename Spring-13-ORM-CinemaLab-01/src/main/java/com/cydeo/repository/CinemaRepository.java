package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema>findTop3ByNameContainsOrderBySponsoredName(String pattern);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema>findAllByLocationCountry(String country);


//    //Write a derived query to list all cinemas with a specific name or sponsored name
//    List<Cinema> listAllByNameOrSponsoredName(String name, String SponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c.name FROM Cinema c Where c.id = ?1")
    String findNameByIdJPQL(@Param("id") Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value="SELECT * FROM cinema c JOIN location l WHERE l.id = c.location_id where l.country = ?1", nativeQuery = true)
    List<Cinema> findAllByCountrySQL(@Param("country") String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM cinema WHERE name LIKE concat('%', :pattern, '%') OR sponsored_name LIKE concat('%', :pattern, '%')", nativeQuery = true)
    List<Cinema>findAllByContainsNameOrSponsoredNameSQL(@Param("pattern") String pattern);

    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM cinema ORDER BY name", nativeQuery = true)
    List<Cinema>sortByNameSQL();

    //Write a native query to distinct all cinemas by sponsored name
//    @Query(value = "SELECT DISTINCT sponsored_name FROM cinema ", nativeQuery = true)
//    List<Cinema>findAllByDistinctSponsoredName();

}
