package Policy;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Policy implements Serializable {
    Vehicle vehicle;
    List<String>risksCoveredList = new ArrayList<>();

    List<Float>premiumList = new ArrayList<>();
    List<Float>coverageList = new ArrayList<>();
    List<Float>ceilingList = new ArrayList<>();

    int validityYear;
    LocalDate policyDate;

    public Policy(Vehicle vehicle, List<String> risksCoveredList, List<Float> premiumList, List<Float> coverageList, List<Float> ceilingList, int validityYear, LocalDate policyDate) {
        this.vehicle = vehicle;
        this.risksCoveredList = risksCoveredList;
        this.premiumList = premiumList;
        this.coverageList = coverageList;
        this.ceilingList = ceilingList;
        this.validityYear = validityYear;
        this.policyDate = policyDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<String> getRisksCoveredList() {
        return risksCoveredList;
    }

    public List<Float> getPremiumList() {
        return premiumList;
    }

    public List<Float> getCoverageList() {
        return coverageList;
    }

    public List<Float> getCeilingList() {
        return ceilingList;
    }

    public int getValidityYear() {
        return validityYear;
    }

    public LocalDate getPolicyDate() {
        return policyDate;
    }

    @Override
    public String toString() {
        return vehicle +
                "\nValidity Year: " + validityYear;
    }
}
