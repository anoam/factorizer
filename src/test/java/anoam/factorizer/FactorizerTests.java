package anoam.factorizer;

import org.junit.Assert;
import org.junit.Test;

public class FactorizerTests {

    @Test
    public void testFactorizerSimplestFactory() {
        Factorizer<FirstTestClass> factorizer = new Factorizer<>(FirstTestClass.class);

        Factory<FirstTestClass> factory = factorizer.attribute("firstAttribute", "foo").build();

        FirstTestClass entity = factory.build();

        Assert.assertEquals("foo", entity.getFirstAttribute());
        Assert.assertNull(entity.getSecondAttribute());
    }

    @Test
    public void testFactorizerSimplestFactoryABitMoreComplex() {
        Factorizer<FirstTestClass> factorizer = new Factorizer<>(FirstTestClass.class);

        Factory<FirstTestClass> factory = factorizer.attribute("firstAttribute", "foo").attribute("secondAttribute", "bar").build();


        FirstTestClass entity = factory.build();
        Assert.assertEquals("foo", entity.getFirstAttribute());
        Assert.assertEquals("bar", entity.getSecondAttribute());
    }

//  Temorary commented cause of not obvious functionality
//    @Test
//    public void testFactorizerSimplestFactoryCustomiztion() {
//        Factorizer<FirstTestClass> factorizer = new Factorizer<>(FirstTestClass.class);
//
//        Factory<FirstTestClass> factory = factorizer.attribute("firstAttribute", "foo").build();
//
//        FirstTestClass entity = factory.customize().stringAttribute("firstAttribute", "bar").stringAttribute("secondAttribute", "baz").build();
//
//        Assert.assertEquals("bar", entity.getFirstAttribute());
//        Assert.assertEquals("baz", entity.getSecondAttribute());
//    }
}
