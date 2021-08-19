import com.task.Trade;
import com.task.TradeStore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MyTradeTests {

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Set Up @BeforeEach");
        Map<String, List<Trade>> tradeStoreMap=new HashMap<String,List<Trade>>();
        LocalDate maturityDate=LocalDate.parse("2021-08-19");
        tradeStoreMap.put("T1", Arrays.asList(
                new Trade("T1",1,"CP-1","B1",maturityDate,LocalDate.now(),"N"),
                new Trade("T1",2,"CP-2","B2",maturityDate,LocalDate.now(),"Y")));
        tradeStoreMap.put("T2", Arrays.asList(new Trade("T2",1,"CP-3","B2",maturityDate,LocalDate.now(),"Y")));
    }

    @Test
    public void versionIdTest_False() {
        LocalDate maturityDate=LocalDate.parse("2021-08-19");
        Trade t=new Trade("T1",1,"CP-1","B1",maturityDate,LocalDate.now(),"N");
        assertEquals(false, TradeStore.versionIdValidation(t));
    }
    @Test
    public void versionIdTest_True() {
        LocalDate maturityDate=LocalDate.parse("2021-08-19");
        Trade t=new Trade("T1",3,"CP-1","B1",maturityDate,LocalDate.now(),"N");
        assertEquals(true, TradeStore.versionIdValidation(t));
    }

    @Test
    public void maturityDate_False() {
        LocalDate maturityDate=LocalDate.parse("2021-08-18");
        assertEquals(false, TradeStore.maturityDateValidation(maturityDate));
    }
    @Test
    public void maturityDate_True() {
        LocalDate maturityDate=LocalDate.parse("2021-08-19");
        assertEquals(true, TradeStore.maturityDateValidation(maturityDate));
    }
}
