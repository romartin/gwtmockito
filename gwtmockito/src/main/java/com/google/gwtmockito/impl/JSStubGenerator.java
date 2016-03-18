package com.google.gwtmockito.impl;

import org.mockito.Mockito;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSStubGenerator {

    public static ScriptEngine engine = null;
    
    public static ScriptEngine getEngine() {
        ScriptEngineManager manager = new ScriptEngineManager();
        return manager.getEngineByName("rhino");
    }
    
    public static Object invoke(String exp) {

        try {
            return engine.eval(exp);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
