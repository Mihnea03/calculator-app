package Plan;

public abstract class Risk {
    float premium;
    float coverage;
    float ceiling;

    public boolean isCovered(String[] risksCovered, String[] claimedRisks){
        for(int i=0;i<=claimedRisks.length;i++) {
            for (int j = 1; j < risksCovered.length; j++) {
                if (risksCovered[j] == claimedRisks[i]) break;
                if(j== risksCovered.length) return false;
            }
        }
        return true;
    }

    public abstract float getPremium();
    public abstract float getCoverage();
    public abstract float getCeiling();
}
