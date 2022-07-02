package annotations;


import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@DataJpaTest
@TestExecutionListeners(mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS, value = {
        DbUnitTestExecutionListener.class})
@ActiveProfiles("test")
public @interface RepositoriesTest {
}
