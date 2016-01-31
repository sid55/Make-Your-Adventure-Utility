
// cyoa.java
// This java class functions as a choose-your-own-adventure utility.
// The user can type in any file that contains any adventure as the
// argument for this java class and this java class will act as a line
// by line reader of the file and allows the user to play the game.

import java.util.*;   
import java.io.*;
import java.util.Enumeration;
public class cyoa {

	static LinkedList myList = new LinkedList();
	static Scanner sc = new Scanner(System.in);
	public static void main (String args[]) throws Exception{
		if (args.length != 1){
			System.out.println("You have not entered the correct argument(s)");
			System.exit(1);
		}
		if (args.length == 1){
			try{
				File filename = new File(args[0]);
				processFile(filename);
			}catch(Exception e){
				System.err.println("You have not entered the correct filename for your adventure");
				System.exit(1);
			}
		System.out.println();
		myList.setVeryTemp();
		myList.push();
		myList.myDescEnumer(myList.getVeryTemp());
		System.out.println();
		myList.setOptionsToUserEnter(myList.getVeryTemp());
		myList.myLetterEnumer(myList.getVeryTemp());
		System.out.println();
		String temper = sc.nextLine();
		while(true){
		if(temper.compareTo("r")==0){
			System.out.println("[restart]");
			System.out.println();
			myList.resetTop();
			myList.setVeryTemp();
			myList.push();
			myList.myDescEnumer(myList.getVeryTemp());
			System.out.println();
			myList.setOptionsToUserEnter(myList.getVeryTemp());
			myList.myLetterEnumer(myList.getVeryTemp());
			System.out.println();
			temper = sc.nextLine();
		}else if(temper.compareTo("q")==0){
			System.out.println("[quit]");
			System.out.println();
			System.out.println("You have quit the game. Come back again later!");
			System.exit(0);
		}else if(temper.compareTo("z")==0){
			System.out.println("[undo]");
			System.out.println();
			myList.changeVeryTempToDiff(myList.pop());
			myList.myDescEnumer(myList.getVeryTemp());
			System.out.println();
			myList.setOptionsToUserEnter(myList.getVeryTemp());
			myList.myLetterEnumer(myList.getVeryTemp());
			System.out.println();
			temper = sc.nextLine();
		}else if(temper.compareTo("y")==0){
			System.out.println("[information]");
			File filename2 = new File(args[0]);
			processFilePrint(filename2);
			System.out.println();
			System.out.println();
			myList.myDescEnumer(myList.getVeryTemp());
			System.out.println();
			myList.setOptionsToUserEnter(myList.getVeryTemp());
			myList.myLetterEnumer(myList.getVeryTemp());
			System.out.println();
			temper = sc.nextLine();
		}
		else{
		String optNumber = myList.lookForOptionNumber(myList.getVeryTemp(), temper);
		while(optNumber==null){
			System.out.println("[Not real option]");
			System.out.println();
			System.err.println("You have not entered a valid option. Please choose again.");
			System.err.println("Here are the options that you have: ");
			myList.setOptionsToUserEnter(myList.getVeryTemp());
			myList.myLetterEnumer(myList.getVeryTemp());
			System.out.println();
			temper = sc.nextLine();
			optNumber = myList.lookForOptionNumber(myList.getVeryTemp(), temper);
			if(temper.compareTo("r")==0){
				System.out.println("[restart]");
				System.out.println();
				myList.resetTop();
				myList.setVeryTemp();
				myList.push();
				myList.myDescEnumer(myList.getVeryTemp());
				System.out.println();
				myList.setOptionsToUserEnter(myList.getVeryTemp());
				myList.myLetterEnumer(myList.getVeryTemp());
				System.out.println();
				temper = sc.nextLine();
				optNumber = myList.lookForOptionNumber(myList.getVeryTemp(), temper);
			}else if(temper.compareTo("q")==0){
				System.out.println("[quit]");
				System.out.println();
				System.out.println("You have quit the game. Come back again later!");
				System.exit(0);
			}else if(temper.compareTo("z")==0){
				System.out.println("[undo]");
				System.out.println();
				myList.changeVeryTempToDiff(myList.pop());
				myList.myDescEnumer(myList.getVeryTemp());
				System.out.println();
				myList.setOptionsToUserEnter(myList.getVeryTemp());
				myList.myLetterEnumer(myList.getVeryTemp());
				System.out.println();
				temper = sc.nextLine();
				optNumber = myList.lookForOptionNumber(myList.getVeryTemp(), temper);
			}else if(temper.compareTo("y")==0){
				System.out.println("[information]");
				File filename2 = new File(args[0]);
				processFilePrint(filename2);
				System.out.println();
				System.out.println();
				myList.myDescEnumer(myList.getVeryTemp());
				System.out.println();
				myList.setOptionsToUserEnter(myList.getVeryTemp());
				myList.myLetterEnumer(myList.getVeryTemp());
				System.out.println();
				temper = sc.nextLine();
				optNumber = myList.lookForOptionNumber(myList.getVeryTemp(), temper);
			}
		}
		String supahh = myList.printsEndOfOptionDesc(myList.getVeryTemp(), optNumber);
		System.out.println(supahh);
		myList.setNewPointerTwoNodes2(myList.lookForTagObjectNode(myList.getVeryTemp(),optNumber),myList.lookForNode(myList.lookForTagObjectNodeItem(myList.getVeryTemp(),optNumber)));
		myList.changeVeryTemp();
		myList.push();
		System.out.println();
		myList.myDescEnumer(myList.getVeryTemp());
		System.out.println();
		myList.setOptionsToUserEnter(myList.getVeryTemp());
		myList.myLetterEnumer(myList.getVeryTemp());
		System.out.println();
		temper = sc.nextLine();
		}
		}
		}
	}
	
	public static void processFilePrint(File myFile) throws IOException{
		FileReader fileReader = new FileReader(myFile);
		BufferedReader bRead = new BufferedReader(fileReader);
		String line = bRead.readLine();
		while(line!=null){
			if(line.compareTo("")!=0){
				String value = line.split(" ")[0];
				String object = line.substring(2, line.length());
					if(value.compareTo("r")==0){
						System.out.println();
						System.out.print(object + " : ");
					}else if(value.compareTo("t")==0){
						System.out.print(object + " ");
					}
					line = bRead.readLine();
		}else if(line.compareTo("")==0){
			line = bRead.readLine();
		}
	}
		bRead.close();
	}
	
	
	public static void processFile(File myFile) throws IOException{
		FileReader fileReader = new FileReader(myFile);
		BufferedReader bRead = new BufferedReader(fileReader);
		String line = bRead.readLine();
		while(line!=null){
			if(line.compareTo("")!=0){
				String value = line.split(" ")[0];
				String object = line.substring(2, line.length());
					if(value.compareTo("r")==0){
						myList.insert(object,LinkedList.position.LAST);
						myList.setPosition(LinkedList.position.LAST);
					}
					else if(value.compareTo("d")== 0){
						myList.insertHashDesc(value,object);
					}
					else if(value.compareTo("o")==0){
						myList.insertHashOpt(value,object);
					}
					else if(value.compareTo("t")==0){
						value = "o";
						myList.insertHashTag(value,object);
					}
					line = bRead.readLine();
				}
			else if(line.compareTo("")==0){
				line = bRead.readLine();
			}
		}
		bRead.close();
	}
}
