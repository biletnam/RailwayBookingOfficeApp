import java.util.Date;

public class ModelTicket extends ModelBaseEntity {
    private ModelCarriage modelCarriage;
    private ModelPassenger modelPassenger;
    private ModelRoute modelRoute;
    private Date buyingTime;

    public ModelTicket(int id, ModelCarriage modelCarriage, ModelPassenger modelPassenger, ModelRoute modelRoute, Date buyingTime) {
        super(id);
        this.modelCarriage = modelCarriage;
        this.modelPassenger = modelPassenger;
        this.modelRoute = modelRoute;
        this.buyingTime = buyingTime;
    }

    public ModelCarriage getModelCarriage() {
        return modelCarriage;
    }

    public void setModelCarriage(ModelCarriage modelCarriage) {
        this.modelCarriage = modelCarriage;
    }

    public ModelPassenger getModelPassenger() {
        return modelPassenger;
    }

    public void setModelPassenger(ModelPassenger modelPassenger) {
        this.modelPassenger = modelPassenger;
    }

    public ModelRoute getModelRoute() {
        return modelRoute;
    }

    public void setModelRoute(ModelRoute modelRoute) {
        this.modelRoute = modelRoute;
    }

    public Date getBuyingTime() {
        return buyingTime;
    }

    public void setBuyingTime(Date buyingTime) {
        this.buyingTime = buyingTime;
    }
}
