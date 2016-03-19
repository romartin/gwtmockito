package com.google.gwtmockito;

import javax.script.*;
import java.util.HashMap;
import java.util.Map;

public class JSEngine {

    private static ScriptEngine engine = getEngine();
    private static final Map<String, Bindings> overlayBindingsMap = new HashMap<String, Bindings>();    
    
    private static ScriptEngine getEngine() {
        ScriptEngineManager manager = new ScriptEngineManager();
        return manager.getEngineByName("rhino");
    }
    
    private static void _push(String uuid, String name, Object value) {
        Bindings bindings = getBindings(uuid);
        bindings.put(name, value);
    }

    public static void push(String uuid, String name, int value) {
        _push(uuid, name, value);
    }

    public static void push(String uuid, String name, long value) {
        _push(uuid, name, value);
    }

    public static void push(String uuid, String name, double value) {
        _push(uuid, name, value);
    }

    public static void push(String uuid, String name, boolean value) {
        _push(uuid, name, value);
    }
    
    public static void push(String uuid, String name, String value) {
        _push(uuid, name, value);
    }
    
    public static void push(String uuid, String name, Object value) {
        _push(uuid, name, value);
    }
    
    public static Object eval(String uuid, String expr) throws Exception {
        Bindings bindings = getBindings(uuid);
        System.out.println("**** EVAL [" + uuid + "] " + expr);
        return engine.eval(expr, bindings);
    }
    
    private static Bindings getBindings(String uuid) {
        Bindings bindings = overlayBindingsMap.get(uuid);
        if ( null == bindings ) {
            ScriptContext newContext = new SimpleScriptContext();
            bindings = newContext.getBindings(ScriptContext.ENGINE_SCOPE);
            overlayBindingsMap.put(uuid, bindings);
        }
        
        return bindings;
    }
    
    
    
}
