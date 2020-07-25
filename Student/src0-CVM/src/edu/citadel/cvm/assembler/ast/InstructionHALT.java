package edu.citadel.cvm.assembler.ast;


import edu.citadel.cvm.OpCode;
import edu.citadel.cvm.assembler.Symbol;
import edu.citadel.cvm.assembler.Token;

import java.util.List;
import java.io.IOException;


/**
 * This class implements the abstract syntax tree for the assembly
 * language instruction HALT.
 */
public class InstructionHALT extends InstructionNoArgs
  {
    public InstructionHALT(List<Token> labels, Token opCode)
      {
        super(labels, opCode);
      }


    public void assertOpCode()
      {
        assertOpCode(Symbol.HALT);
      }


    @Override
    public void emit() throws IOException
      {
        emit(OpCode.HALT);
      }
  }
