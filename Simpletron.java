


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Simpletron extends JFrame{
			private final int READ = 10;
			private final int WRITE = 11;
			private final int LOAD = 20;
			private final int STORE = 21;
			private final int ADD = 30;
			private final int SUBTRACT = 31;
			private final int DIVIDE = 32;
			private final int MULTIPLY = 33;
			private final int BRANCH = 40;
			private final int BRANCHNEGATIVE = 41;
			private final int BRANCHZERO = 42;
			private final int HALT = 43;
            private int counter = 0;
            private int count = 0; 
            private final JTextField accumulator1,instructionCounter1,operationCode1,instructionRegister1,operand1;
            private final JLabel accumulator2,instructionCounter2,operationCode2,instructionRegister2,operand2;
            private final JButton button;
            private JPanel panel;
            private JTextArea Area;
	    private static int[] memory = new int[100];   
	    private int accumulator = 0;          
	    private int instructionCounter = 0;    
	    private int operationCode = 0;   
	    private int operand = 0;                
	    private int instructionRegister = 0;
	    
            public Simpletron(){
                super("Simpletron");
                 panel = new JPanel();
                panel.setLayout(new FlowLayout());
                accumulator2 = new JLabel("Accumulator");
                instructionCounter2 = new JLabel("InstCounter");
                instructionRegister2 = new JLabel("InstReg");
                operand2 = new JLabel("Operand");
                operationCode2 = new JLabel("OpCode");
                accumulator1 = new JTextField(5);
                 instructionCounter1 = new JTextField(3);
                 operationCode1 = new JTextField(5);
                 operand1 = new JTextField(3);
                 instructionRegister1 = new JTextField(3);
                 button = new JButton("Excecute Next Instruction");
                 button.addActionListener(new Registeration());
                 Area = new JTextArea(10,75);
                 panel.add(accumulator2);
                 panel.add(accumulator1);
                 panel.add(instructionCounter2);
                 panel.add(instructionCounter1);
                 panel.add(instructionRegister2);
                 panel.add(instructionRegister1);                 
                 panel.add(operationCode2);
                 panel.add(operationCode1);
                 panel.add(operand2);
                 panel.add(operand1);
                 panel.add(Area);
                 panel.add(button);
                 add(panel);
                 Area.setBackground(Color.lightGray);
                 panel.setBackground(Color.lightGray);
                 accumulator1.setBackground(Color.lightGray);
                 operand1.setBackground(Color.lightGray);
                 operationCode1.setBackground(Color.lightGray);
                 instructionRegister1.setBackground(Color.lightGray);
                 button.setBackground(Color.lightGray);
                 instructionCounter1.setBackground(Color.lightGray);
                 accumulator1.setEditable(false);
                 instructionCounter1.setEditable(false);
                 operand1.setEditable(false);
                 operationCode1.setEditable(false);
                 instructionRegister1.setEditable(false);
                                
                                Font font = Area.getFont();  
                                Area.setFont(font.deriveFont(Font.BOLD));
                                accumulator1.setText(accumulator+"");
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(0+"");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                 
            }
                 private class Registeration implements ActionListener
                 {
                     @Override
                     public void actionPerformed(ActionEvent v)
                     {
                         excecute();
                     }
                 }
                 
                 
                 
	        
	     public void fetch()
            {
                operand = memory[counter]%100;
                operationCode = memory[counter]/100;
            }
	    public void load(int operationCode,int operand){
	        
                 instructionCounter++;
                switch(operationCode){
                    
	   
                    case READ:
                    { String number = JOptionPane.showInputDialog( "Please Enter a whole number (positive or negative): " );
				memory [ operand] = Integer.parseInt(number);
                                String s2 = "";
                               for ( int i = 0; i < 10; i++ )
		{
			s2+=String.format( "%24d", i);
		}

		s2+=String.format("\n\n");

		for (int i = 0; i < 10; i++ ) 
		{
			if ( count %10 == 0 )
				s2+=String.format("%02d      ", count);
			for (int j = 0; j < 10; j++) 
			{	
				
				if ( memory [ count ] == 0 )
					s2 += String.format("%s                 ","0000");
				else 
					s2 += String.format("%04d                 ",memory[count]);
				count++;

                        }
		       
		s2+=String.format("\n\n");	

                }
                                count = 0 ;
                                Area.setLineWrap(true);
                                Area.setText(s2);
                                accumulator1.setText(accumulator+"");
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(memory[counter]+" ");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                                
                                
				break;
                        
                    }
	            case WRITE:
	                
                    {
                        
                               JOptionPane.showMessageDialog(null,"The result of the operation is " + memory [ operand],"Write Operation Result",JOptionPane.PLAIN_MESSAGE );   
                            accumulator1.setText(accumulator+"");
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(memory[counter]+" ");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                                
				break;
                    }
	            case LOAD:
                    {            accumulator = memory[operand];
                                 accumulator1.setText(accumulator+"");
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(memory[counter]+" ");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                                        break;
                    }
	            case STORE:
                    {
                        memory[operand] = accumulator;
                              String s2 = "";
                               for ( int i = 0; i < 10; i++ )
		{
			s2+=String.format( "%24d", i);
		}

		s2+=String.format("\n\n");

		for (int i = 0; i < 10; i++ ) 
		{
			if ( count %10 == 0 )
				s2+=String.format("%02d      ", count);
			for (int j = 0; j < 10; j++) 
			{	
				
				if ( memory [ count ] == 0 )
					s2 += String.format("%s                 ","0000");
				else 
					s2 += String.format("%04d                 ",memory[count]);
				count++;

                        }
		       
		s2+=String.format("\n\n");	

                }
                                count = 0 ;
                                Area.setLineWrap(true);
                                Area.setText(s2);
                                accumulator1.setText(accumulator+"");
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(memory[counter]+" ");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                                
                                
				break;
                        
                    }
	            case ADD:
                    {
                        
                    
                                accumulator += memory[operand];
                                accumulator1.setText(accumulator+"");
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(memory[counter]+" ");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
	                break;
                    }
	            case SUBTRACT:
                    {
                        accumulator -= memory[operand];
                         accumulator1.setText(accumulator+"");
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(memory[counter]+" ");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                                break;
                    }
	                
	            case DIVIDE:
                    {
                        accumulator /= memory[operand];
                         accumulator1.setText(accumulator+"");
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(memory[counter]+" ");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                                break;
                    }
	            case MULTIPLY:
                    {        accumulator*=memory[operand];
                               accumulator1.setText(accumulator+"");
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(memory[counter]+" ");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                                break;
                        
                    }
                
	            case BRANCH:
                    {    instructionCounter = operand;
                                if(operand == 0)
                                {
                                    counter = -1;
                                }
                                else
                                {
                                counter = operand - 1;    
                                }
                                accumulator1.setText(""+accumulator);
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                                
                            
				break;
                }
	            case BRANCHNEGATIVE:
                    {    if(accumulator < 0)
                        {      instructionCounter = operand;
                             if(operand == 0)
                                {
                                    counter = -1;
                                }
                                else
                                {
                                counter = operand - 1;    
                                }
                                accumulator1.setText(""+accumulator);
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                        }
                     else
                        {
                                 accumulator1.setText(""+accumulator);
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(memory[counter]+"");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                        }
                                
	                break;
                }
	            case BRANCHZERO:
                    {      if(accumulator == 0)
                        {
                        instructionCounter = operand;
                             if(operand == 0)
                                {
                                    counter = -1;
                                }
                                else
                                {
                                counter = operand - 1;    
                                }
                                accumulator1.setText(""+accumulator);
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                }
                    else
                        {
                                 accumulator1.setText(""+accumulator);
                                instructionCounter1.setText(String.format("%d",instructionCounter));
                                instructionRegister1.setText(memory[counter]+"");
                                operationCode1.setText(operationCode+"");
                                operand1.setText(operand+"");
                        }
                    
	                break;
                }
	            case HALT:
                    {
                        JOptionPane.showMessageDialog(null,"The program has completed its task...","Program Terminated",JOptionPane.PLAIN_MESSAGE);
                    
				System.exit ( 0 );
				break;
                    }
	        }
               counter++;
	    
            }
            public void excecute()
            {
                fetch();
                load(operationCode,operand);
            }
             public static void main(String[] myArgs) {
        
        int mem[]=new int[100];
		char program[]=new char[500];
		FileReader inputFile;
		try{
			inputFile = new FileReader(myArgs[0]);
		}
		catch(IOException ioEx){
			JOptionPane.showMessageDialog(null,"Invalid File Name","Invalid File Name",JOptionPane.ERROR_MESSAGE);
			return;
		}
		int counter = 0;
		try{
			while(inputFile.read(program,counter,1) != -1)
				++counter;
		}
		catch(IOException ioEx){
			JOptionPane.showMessageDialog(null,"File Read Error","Encountered An  Error While Reading File",JOptionPane.ERROR_MESSAGE);
			return;
		}
		String stringToTokenize = new String(program);
		StringTokenizer tokens = new StringTokenizer(stringToTokenize,"\r\n\0",false);
		counter = 0;
		while(tokens.hasMoreTokens()){
				mem[counter++] = Integer.parseInt(tokens.nextToken());
		}
                Simpletron sML = new Simpletron();
                for(int i =0;i<mem.length;i++)
                        {
                            memory[i]=mem[i];
                        }
                int count = 0;
                String s2 ="";
                for ( int i = 0; i < 10; i++ )
		{
			s2+=String.format( "%24d", i);
		}

		s2+=String.format("\n\n");

		for (int i = 0; i < 10; i++ ) 
		{
			if ( count %10 == 0 )
				s2+=String.format("%02d      ", count);
			for (int j = 0; j < 10; j++) 
			{	
				
				if ( mem [ count ] == 0 )
					s2 += String.format("%s                 ","0000");
				else 
					s2 += String.format("%04d                 ",mem[count]);
				count++;

                        }
		       
		s2+=String.format("\n\n");	

                }
                sML.Area.setEditable(false);
                sML.Area.setLineWrap(true); 
                sML.Area.setText(s2);
                sML.pack();
                sML.setLocationRelativeTo(null);
        sML.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sML.setSize(850,500);
        sML.setVisible(true);
                
                
}
}
	    