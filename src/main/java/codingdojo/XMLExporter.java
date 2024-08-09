package codingdojo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Date;

public class XMLExporter {

    private XMLExporter() {
    }
    public static String exportFull(Collection<Order> orders) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<orders>");
        for (Order order : orders) {
            xml.append(order.getFullExport());
        }
        xml.append("</orders>");
        return xml.toString();
    }

    public static String exportTaxDetails(Collection<Order> orders) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<orderTax>");
        for (Order order : orders) {
            xml.append(order.getExportWithTax());
        }
        double totalTax = TaxCalculator.calculateAddedTax(orders);
        xml.append(formatter.format(totalTax));
        xml.append("</orderTax>");
        return xml.toString();
    }

    public static String exportStore(Store store) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<store");
        xml.append(" name='");
        xml.append(store.getName());
        xml.append("'");
        xml.append(">");
        for (Product product : store.getStock()) {
            xml.append(product.exportWithStore());
        }
        xml.append("</store>");
        return xml.toString();
    }

    public static String exportHistory(Collection<Order> orders) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xml.append("<orderHistory");
        xml.append(" createdAt='");
        Date now = new Date();
        xml.append(Util.toIsoDate(now));
        xml.append("'");
        xml.append(">");
        for (Order order : orders) {
            xml.append(order.getExportHistory());
        }
        xml.append("</orderHistory>");
        return xml.toString();
    }

}
