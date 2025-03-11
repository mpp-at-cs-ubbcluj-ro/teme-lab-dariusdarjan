package ro.mpp2025.domain;


public class Donation extends Entity<Integer>{
    private CharityCase charityCase;
    private Donor donor;
    private float amount;

    public Donation(Integer id, CharityCase charityCase, Donor donor, float amount) {
        this.id = id;
        this.charityCase = charityCase;
        this.donor = donor;
        this.amount = amount;
    }

    public CharityCase getCharityCase() {
        return charityCase;
    }

    public void setCharityCase(CharityCase charityCase) {
        this.charityCase = charityCase;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
