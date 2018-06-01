package anoam.factorizer;

import org.junit.Assert;
import org.junit.Test;

public class FactorizerTests {

    @Test
    public void testFactorizerSimplestFactory() {
        Factorizer<FirstTestClass> factorizer = new Factorizer<>(FirstTestClass.class);

        Factory<FirstTestClass> factory = factorizer.stringAttribute("firstAttribute", "foo").build();

        FirstTestClass entity = factory.build();

        Assert.assertEquals(entity.getFirstAttribute(), "foo");
        Assert.assertNull(entity.getSecondAttribute());
    }

    @Test
    public void testFactorizerSimplestFactoryABitMoreComplex() {
        Factorizer<FirstTestClass> factorizer = new Factorizer<>(FirstTestClass.class);

        Factory<FirstTestClass> factory = factorizer.stringAttribute("firstAttribute", "foo").stringAttribute("secondAttribute", "bar").build();


        FirstTestClass entity = factory.build();
        Assert.assertEquals(entity.getFirstAttribute(), "foo");
        Assert.assertEquals(entity.getSecondAttribute(), "bar");
    }

    @Test
    public void testFactorizerSimplestFactoryCustomiztion() {
        Factorizer<FirstTestClass> factorizer = new Factorizer<>(FirstTestClass.class);

        Factory<FirstTestClass> factory = factorizer.stringAttribute("firstAttribute", "foo").build();

        FirstTestClass entity = factory.customize().stringAttribute("firstAttribute", "bar").stringAttribute("secondAttribute", "baz").build();

        Assert.assertEquals(entity.getFirstAttribute(), "bar");
        Assert.assertEquals(entity.getSecondAttribute(), "baz");

    }
}
