package com.google.gwtmockito.util;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.Node;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.comments.BlockComment;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JavaSourceParser {
    
    public interface Callback {
        void onNativeMethod(String[] argNames, String code);
    }
    
    public static void getNativeCode(String className, String method, int paramsLength, Callback callback) throws IOException, ParseException {
        
        // creates an input stream for the file to be parsed.
        InputStream in = JavaSourceParser.class.getResourceAsStream("/" + className.replaceAll("\\.","/") + ".java");
        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // visit and print the methods names
        new NativeMethodVisitor(callback, method, paramsLength).visit(cu, null);
    }

    /**
     * Simple visitor implementation for visiting public native MethodDeclaration nodes. 
     */
    private static class NativeMethodVisitor extends VoidVisitorAdapter {

        private final Callback callback;
        private final String method;
        private final int paramsLength;

        public NativeMethodVisitor(Callback callback, String method, int paramsLength) {
            this.callback = callback;
            this.method = method;
            this.paramsLength = paramsLength;
        }

        @Override
        public void visit(MethodDeclaration n, Object arg) {
            // Public native declarations. 
            int pSize = n.getParameters() != null ? n.getParameters().size() : 0;
            if ( n.getModifiers() >= 256 && method.equals(n.getName()) && pSize == paramsLength ) {
                List<Node> nodesList = n.getChildrenNodes();
                if ( null != nodesList ) {
                    for ( Node node : nodesList ) {
                        if ( node instanceof BlockComment) {
                            BlockComment blockComment = (BlockComment) node;
                            String code = blockComment.toString();
                            code = code.replaceFirst(".*\\{","").replaceAll("\\}\\-.*","").replaceAll("\n","");
                            code = StringEscapeUtils.unescapeEcmaScript(code);
                            String[] argNames = getArgNames(n);
                            callback.onNativeMethod(argNames, code);
                        }
                    }
                }
            }
            super.visit(n, arg);
        }
    }
    
    private static String[] getArgNames(MethodDeclaration n) {
        List<Parameter> parameters = n.getParameters();
        if ( null != parameters && !parameters.isEmpty() ) {
            String[] result = new String[parameters.size()];
            int x = 0;
            for (Parameter parameter : parameters) {
                String id = parameter.getId().getName();
                result[x] = id;
                x++;
            }
            return result;
        }
        return null;
    }

}
