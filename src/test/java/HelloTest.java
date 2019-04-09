import com.dean.fact.HelloDto;
import lombok.extern.slf4j.Slf4j;
import org.drools.core.common.DefaultFactHandle;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

/**
 * Created by Dean on 2019/4/9
 */
@Slf4j
public class HelloTest extends BaseTest {



    @Test
    public void helloTest(){
        KieSession kieSession = getKieSession();
        HelloDto helloDto = new HelloDto();

        log.info("------------- before exec rule helloDto.word={}",helloDto.getWord());
        DefaultFactHandle factHandle = (DefaultFactHandle)kieSession.insert(helloDto);
        int count = kieSession.fireAllRules();
        log.info("------------- fireAllRules count={}",count);

        log.info("------------- after exec rule helloDto.word={}",helloDto.getWord());

        HelloDto helloDto1 = (HelloDto)factHandle.getObject();
        log.info("------------- after exec rule factHandle.helloDto.word={}",helloDto1.getWord());

        kieSession.dispose();
    }


}
