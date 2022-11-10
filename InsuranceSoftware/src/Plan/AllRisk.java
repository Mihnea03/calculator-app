package Plan;

public class AllRisk extends Risk{
    @Override
    public float getPremium() {
        return 0.075f;
    }

    @Override
    public float getCoverage() {
        return 1f;
    }

    @Override
    public float getCeiling() {
        return 10;
    }

    public String[] AllRisksCovered = {
            "Vehicle Damage",
            "Third Party Damage",
            "Driver Damage",
            "Fire",
            "Robbery",
            "Transport",
            "Car Replacement"
    };
}
