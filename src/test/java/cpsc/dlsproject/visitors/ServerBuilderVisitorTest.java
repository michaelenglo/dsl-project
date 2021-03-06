package cpsc.dlsproject.visitors;

import cpsc.dlsproject.ast.Program;
import cpsc.dlsproject.ast.statements.*;
import junit.framework.TestCase;

import java.util.ArrayList;

public class ServerBuilderVisitorTest extends TestCase {

    public void testSimpleProgram() {
        ArrayList<Statement> body = new ArrayList<Statement>();
        Response response = new Response(200, "Some successful Message!", new ArrayList<VarDeclaration>());
        body.add(response);
        URLDeclaration url = new URLDeclaration("/path/to/success", new ArrayList<String>());
        EndpointDeclaration endpoint = new EndpointDeclaration(RequestMethod.GET, url, body);
        ArrayList<EndpointDeclaration> endpoints = new ArrayList<EndpointDeclaration>();
        endpoints.add(endpoint);
        Program program = new Program(endpoints);
        String expected = "GET {\n" +
                "    ENDPOINT = \"/path/to/success\";\n" +
                "    SEND = {\n" +
                "        200\";\n" +
                "        \"Some successful Message!\";\n" +
                "    };\n" +
                "};\n";
        System.out.println("Expected:\n" + expected + "\n");
        ServerBuilderVisitor serverBuilderVisitor = new ServerBuilderVisitor(program);
        serverBuilderVisitor.setPort(9000);
        serverBuilderVisitor.run();
    }
}
