package ro.mpp2025.repo;

import ro.mpp2025.domain.Donor;

public interface DonorRepository extends Repository<Integer, Donor>{
    Iterable<Donor> filterDonorsByName(String name);
    Iterable<Donor> filterDonorsByAddress(String address);
    Iterable<Donor> filterDonorsByPhone(String phoneNumber);
}