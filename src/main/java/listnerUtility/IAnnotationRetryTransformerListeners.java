package listnerUtility;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import testBase.WebTestBase;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;



public class IAnnotationRetryTransformerListeners implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor TestConstructor, Method testMethod){
        annotation.setRetryAnalyzer(ListenerUtility.class);

}

}