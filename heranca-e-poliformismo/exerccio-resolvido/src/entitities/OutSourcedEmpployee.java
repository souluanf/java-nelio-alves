package entitities;

public class OutSourcedEmpployee extends Employee {

    private Double additionalCharge;

    public OutSourcedEmpployee(Double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    public OutSourcedEmpployee(String nanme, Integer hours, Double valuePerHour, Double additionalCharge) {
        super(nanme, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    public Double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(Double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double payment() {
        return super.payment() + additionalCharge * 1.1;
    }
}
