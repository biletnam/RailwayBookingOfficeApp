public enum CarriageType {
    BERTH,COMPARTMENT,DELUXE;

    public static CarriageType getCarriageType(String type){
        if(BERTH.name().equals(type)) return BERTH;
        else if(COMPARTMENT.name().equals(type)) return COMPARTMENT;
        else if (DELUXE.name().equals(type)) return DELUXE;

        throw new IllegalArgumentException("No Enum specified for this type");
    }
}
