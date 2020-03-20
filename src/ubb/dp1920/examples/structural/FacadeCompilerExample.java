package ubb.dp1920.examples.structural;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Classes that represent the different stages of compiling.
 * 
 * We might need fine-grained access to these (e.g. syntax highlight)
 */
class Scanner {
    private InputStream input;

    public Scanner(InputStream input) {
        this.input = input;
    }

    public byte scan() {
        return 0;
    }
}

class Parser {
    public Parser() {
    };

    public void Parse(Scanner scanner, ProgramNodeBuilder pnb) {
    }
}

class ProgramNodeBuilder {
    public ProgramNodeBuilder() {
    }

    ProgramNode newVariable(String variableName) {
        return new ProgramNode();
    };

    ProgramNode NewAssignment(ProgramNode variable, ProgramNode expression) {
        return new ProgramNode();
    }

    ProgramNode NewReturnStatement(ProgramNode value) {
        return new ProgramNode();
    }

    ProgramNode NewCondition(ProgramNode condition, ProgramNode truePart, ProgramNode falsePart) {
        return new ProgramNode();
    };
    // ...

    public ProgramNode getRootNode() {
        return null;
    };
};

class ProgramNode {
    protected ProgramNode() {
    }

    public int getSourcePosition(int line, int index) {
        return 0;
    }
    // ...

    // child manipulation
    public void add(ProgramNode child) {
    }

    public void remove(ProgramNode child) {
    }
    // ...

    public void traverse(CodeGenerator codeGen) {
    }

};

/**
 * Implements the Visitor pattern
 */
class CodeGenerator {
    protected OutputStream oStream;

    public void visit(ProgramNode node) {
    }

    protected CodeGenerator(InputStream iStream) {
    };
};

/**
 * Concrete code generator that is used by a compiler to produce executable code
 */
class X86CodeGen extends CodeGenerator {
    public X86CodeGen(InputStream iStream) {
        super(iStream);
    }
}

/**
 * This is the facade. It uses the system classes to provide a common
 * functionality
 */
class Compiler {
    public Compiler() {
    };

    public void Compile(InputStream iStream, OutputStream oStream) {
        Scanner scanner = new Scanner(iStream);
        ProgramNodeBuilder builder = new ProgramNodeBuilder();
        Parser parser = new Parser();
        parser.Parse(scanner, builder);

        X86CodeGen x86codeGen = new X86CodeGen(iStream);
        ProgramNode parseTree = builder.getRootNode();
        parseTree.traverse(x86codeGen);
    }
};
