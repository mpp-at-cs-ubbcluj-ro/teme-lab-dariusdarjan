package ro.mpp2025.repo;

import ro.mpp2025.domain.Donation;

public interface DonationRepository extends Repository<Integer, Donation> {
    Iterable<Donation> filterDonationsByCaseId(Integer caseId);
    Iterable<Donation> filterDonationsByDonorId(Integer donorId);
}
