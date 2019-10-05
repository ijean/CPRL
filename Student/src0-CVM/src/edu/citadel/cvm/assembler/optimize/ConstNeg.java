package edu.citadel.cvm.assembler.optimize;


import edu.citadel.cvm.assembler.Symbol;
import edu.citadel.cvm.assembler.Token;
import edu.citadel.cvm.assembler.ast.Instruction;

import java.util.List;


/**
 * Performs a special type of constant folding by replacing an instruction
 * sequence of the form LDCINT x, NEG with LDCINT -x. 
 */
public class ConstNeg implements Optimization
  {
    @Override
    public void optimize(List<Instruction> instructions, int instNum)
      {
        // quick check that there are at least 2 instructions remaining
        if (instNum > instructions.size() - 2)
            return;

        Instruction inst0 = instructions.get(instNum);
        Instruction inst1 = instructions.get(instNum + 1);
        
        Symbol symbol0 = inst0.getOpCode().getSymbol();
        Symbol symbol1 = inst1.getOpCode().getSymbol();

        if (symbol0 == Symbol.LDCINT && symbol1 == Symbol.NEG)
          {
            String arg0 = inst0.getArg().getText();
            int constValue = Integer.parseInt(arg0);
            int negValue   = -constValue;
            
            // make sure that the NEG instruction does not have any labels
            List<Token> inst1Labels = inst1.getLabels();
            if (inst1Labels == null || inst1Labels.size() == 0)
              {
                inst0.getArg().setText(Integer.toString(negValue));

                // remove the NEG instruction
                instructions.remove(instNum + 1);
              }            
          }
      }
  }
