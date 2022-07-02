package annotations;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@TestExecutionListeners(mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS, value = {
        DbUnitTestExecutionListener.class
})
@Transactional
@Rollback
@AutoConfigureMockMvc
@SpringBootTest(properties = {"spring.jpa.properties.hibernate.show_sql=true",
        "spring.redis.port=6370"})
@ActiveProfiles("test")
public @interface IntegrationTest {
}
