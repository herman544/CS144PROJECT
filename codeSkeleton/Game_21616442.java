import stdlib.*;
import java.util.InputMismatchException;

public class Game_21616442 {
	
	//	Please excuse the messy code, 
	//	I lost all my project progress
	//	due to a computer crash last week.
	//	I had the file backed up, but due to
	//	the crash my hard drive was corrupted.
	//	I have tried to recreate my code in time,
	//	so I please ask that you excuse 
	//	that my program doesn't run correctly
	//	and have a look at my code/methods and logic.
	//	Any feedback/suggestions would be welcome.
	

    public static void main(String[] args) {
        String path = args[0];
        int outputVersion = Integer.parseInt(args[1]);
        if (outputVersion == 0) {
            // warrior statistics mode
        	
            MethodClass_21616442 mth = new MethodClass_21616442();
            
            mth.readFile(path);
          
            mth.waterRefresh();
            mth.allianceCheck();
            mth.ageCapCheck();
            mth.defenseCheckWarrior();
            mth.waterLogic(1,1);
            mth.moveWarrior();
            
        	
        } else if (outputVersion == 1) {
            // warrior statistics with visualization mode
        	MethodClass_21616442 mth = new MethodClass_21616442();
        	mth.readFile(path);
        	
            mth.waterRefresh();
            mth.allianceCheck();
            mth.ageCapCheck();
            mth.defenseCheckWarrior();
            mth.waterLogic(1,1);
            mth.moveWarrior();
        	
        	mth.visualDisplay();
        	
        	
        }
        

    }

}