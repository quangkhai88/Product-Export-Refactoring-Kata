package codingdojo;

public class Product {

    protected final String name;
    protected final String id;
    protected final int weight;
    protected final Price price;

    public Product(String name, String id, int weight, Price price) {
        this.name = name;
        this.id = id;
        this.weight = weight;
        this.price = price;
    }

    public void saveToDatabase() {
        throw new UnsupportedOperationException("missing from this exercise - shouldn't be called from a unit test");
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" + name + '}';
    }

    public int getWeight() {
        return weight;
    }

    public double getPriceInUSD() {
        return price.getPriceInUSD();
    }

    public boolean isEvent() {
        return false;
    }

    public String getPriceCurrency() {
        return price.getCurrency();
    }

    public double getPriceAmount() {
        return price.getAmount();
    }

    public double getTax() {
        return getPriceInUSD() * 0.175;
    }

    public String export() {
        StringBuilder xml = new StringBuilder();
        xml.append("<product");
        xml.append(" id='");
        xml.append(getId());
        xml.append("'");
        if (isEvent()) {
            xml.append(" stylist='");
            xml.append(stylistFor());
            xml.append("'");
        }
        if (getWeight() > 0) {
            xml.append(" weight='");
            xml.append(getWeight());
            xml.append("'");
        }
        xml.append(">");
        xml.append("<price");
        xml.append(" currency='");
        xml.append(getPriceCurrency());
        xml.append("'>");
        xml.append(getPriceAmount());
        xml.append("</price>");
        xml.append(getName());
        xml.append("</product>");
        return xml.toString();
    }

    public String getExportBasicInfo() {
        StringBuilder xml = new StringBuilder();
        xml.append("<product");
        xml.append(" id='");
        xml.append(getId());
        xml.append("'");
        xml.append(">");
        xml.append(getName());
        xml.append("</product>");
        return xml.toString();
    }

    private static String stylistFor() {
        return "Celeste Pulchritudo";
    }

    public String exportWithStore() {
        StringBuilder xml = new StringBuilder();
        xml.append("<product");
        xml.append(" id='");
        xml.append(getId());
        xml.append("'");
        if (isEvent()) {
            xml.append(" location='");
            xml.append(getName());
            xml.append("'");
        } else {
            xml.append(" weight='");
            xml.append(getWeight());
            xml.append("'");
        }
        xml.append(">");
        xml.append("<price");
        xml.append(" currency='");
        xml.append(getPriceCurrency());
        xml.append("'>");
        xml.append(getPriceAmount());
        xml.append("</price>");
        xml.append(getName());
        xml.append("</product>");
        return xml.toString();
    }
}
