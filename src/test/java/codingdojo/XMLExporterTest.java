package codingdojo;

import org.approvaltests.Approvals;
import org.approvaltests.core.Options;
import org.approvaltests.scrubbers.DateScrubber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
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
    public void exportStore() throws Exception {
        Store store = FlagshipStore;
        String xml = XMLExporter.exportStore(store);
        Approvals.verifyXml(xml);
    }

    @Test
    public void exportHistory() throws Exception {
        Collection<Order> orders = Arrays.asList(RecentOrder, OldOrder);
        String xml = XMLExporter.exportHistory(orders);
        Approvals.verifyXml(xml, new Options().withScrubber(
                DateScrubber.getScrubberFor("2022-06-21T11:29Z")
        ));
    }
}
