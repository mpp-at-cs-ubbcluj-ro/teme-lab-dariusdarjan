package ro.mpp2025.repo;

import ro.mpp2025.domain.CharityCase;

import java.util.Optional;

public interface CharityCaseRepository extends Repository<Integer, CharityCase> {
    Optional<CharityCase> findByName(String name);
}
