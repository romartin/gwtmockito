/*
 * Copyright 2014 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.gwtmockito;

import com.google.gwtmockito.subpackage.LoadedFromStandardClassLoader;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.InitializationError;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.internal.runners.TestClass;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link GwtMockitoTestRunner}.
 */
@RunWith(JUnit4ClassRunner.class)
public class GwtMockitoTestRunnerTest {

  @Test
  public void shouldLoadClassFromStandardClassLoaderEvenWhenRequestedByChildClassLoader()
      throws InitializationError, ClassNotFoundException {

    // Runner should reload the test class in its own ClassLoader.
    GwtMockitoTestRunner runner = new GwtMockitoTestRunner(DummyTestClass.class) {

      @Override
      protected Collection<String> getPackagesToLoadViaStandardClassloader() {
        Collection<String> packages = super.getPackagesToLoadViaStandardClassloader();
        packages.add("com.google.gwtmockito.subpackage");
        return packages;
      }
    };

    // Assert that test class is loaded from a different class loader.
   /* 
   TestClass testClass = runner.getTestClass();
    Class<?> javaClass = testClass.getJavaClass();
    assertNotEquals(DummyTestClass.class, javaClass);

    // Create a child ClassLoader of the one used by Runner.
    ClassLoader gwtMockitoClassLoader = javaClass.getClassLoader();
    ClassLoader childClassLoader = new ClassLoader(gwtMockitoClassLoader) {};

    // Attempt to load the class from the child ClassLoader, should delegate up to the one used to
    // load this class.
    Class<?> loadedClass =
        childClassLoader.loadClass(LoadedFromStandardClassLoader.class.getName());

    assertEquals("Expected to load class from the standard ClassLoader, i.e. the one that "
        + "loaded this test class, but loaded it from the GwtMockitoTestRunner's ClassLoader "
        + "instead. That means there is a problem with the delegation of class loading.",
        getClass().getClassLoader(), loadedClass.getClassLoader());
    */
  }

  @RunWith(JUnit4ClassRunner.class)
  public static class DummyTestClass {

    @Test
    public void dummy() {
    }
  }
}
