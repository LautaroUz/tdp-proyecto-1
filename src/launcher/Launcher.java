package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	final Student student;
            	student=new Student(125615,"Uzeltinger","Lautaro","lautarouzeltinger@gmail.com","https://github.com/LautaroUz","...");
            	SimplePresentationScreen ventana=new SimplePresentationScreen(student);
            	ventana.setVisible(true);
            }
        });
    }
}