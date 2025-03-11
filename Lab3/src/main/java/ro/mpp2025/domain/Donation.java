package ro.mpp2025.domain;


public class Donation extends Entity<Integer>{
    private Integer charityCase;
    private Integer donor;
    private float amount;

    public Donation(Integer id, Integer charityCase, Integer donor, float amount) {
        this.id = id;
        this.charityCase = charityCase;
        this.donor = donor;
        this.amount = amount;
    }

    public Integer getCharityCase() {
        return charityCase;
    }

    public void setCharityCase(Integer charityCase) {
        this.charityCase = charityCase;
    }

    public Integer getDonor() {
        return donor;
    }

    public void setDonor(Integer donor) {
        this.donor = donor;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
