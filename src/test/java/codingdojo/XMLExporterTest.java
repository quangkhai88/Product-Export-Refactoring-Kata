package codingdojo;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static codingdojo.SampleModelObjects.*;

class XMLExporterTest {

    @Test
    void testFullExport() {
        List<Order> list = Arrays.asList(RecentOrder, OldOrder);
        String xml = XMLExporter.exportFull(list);
        Approvals.verifyXml(xml);
    }

    @Test
    void testTaxExport() {
        List<Order> list = Arrays.asList(RecentOrder, OldOrder);
        String xml = XMLExporter.exportTaxDetails(list);
        Approvals.verifyXml(xml);
    }

    @Test
    void testFullExportWithEvent() {
        List<Order> list = Arrays.asList(RecentOrder, OldOrder);
        RecentOrder.addProducts(Masterclass);
        String xml = XMLExporter.exportFull(list);
        Approvals.verifyXml(xml);
    }

    @Test
    void testFullExportWithEventAndWeight() {
        List<Order> list = Arrays.asList(RecentOrder, OldOrder);
        RecentOrder.addProducts(Masterclass);
        String xml = XMLExporter.exportFull(list);
        Approvals.verifyXml(xml);
    }


    @Test
    void testExportStore() {
        List<Order> list = Arrays.asList(RecentOrder, OldOrder);
        String xml = XMLExporter.exportFull(list);
        Approvals.verifyXml(xml);
    }

    @Test
    void testExportHistory() {
        List<Order> list = Arrays.asList(RecentOrder, OldOrder);
        String xml = XMLExporter.exportFull(list);
        Approvals.verifyXml(xml);
    }
}
