package ro.mpp2025.repo;

import ro.mpp2025.domain.Volunteer;

import java.util.Optional;

public interface VolunteerRepository extends Repository<Integer, Volunteer>{
    Optional<Volunteer> findByUsername(String username);
}
